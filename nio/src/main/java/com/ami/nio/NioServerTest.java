package com.ami.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import javax.naming.spi.DirectoryManager;

public class NioServerTest {
    private final static int port = 8080;
    final private Selector selector;
    final private Map<Integer, Channel> channels = Collections
            .synchronizedMap(new HashMap());
    AtomicReference<Integer> count = new AtomicReference<Integer>(0);

    public NioServerTest(int port) throws IOException {

        ServerSocketChannel serverChannel = ServerSocketChannel.open();

        // serverChannel.
        serverChannel.configureBlocking(false);
        serverChannel.socket().bind(new InetSocketAddress(port));
        this.selector = Selector.open();
        // 在选择器中注册该ServerSocketChannel的accpt事件。注册后client连接事件，会被选择器触发
        SelectionKey selectionKey = serverChannel.register(this.selector,
                SelectionKey.OP_ACCEPT, null);
    }

    public static void main(String[] args) throws IOException {
        System.setProperty("http.maxConnections", "100000");
        System.out.println(System.getProperty("http.maxConnections"));

        System.setProperty("http.maxConnections", "100000");
        System.setProperty("http.keepAlive", "false");

        NioServerTest ser = new NioServerTest(port);
        ser.listen();

    }

    public void listen() throws IOException {
        while (true) {

            // 阻塞，等待该选择器注册的事件。
            this.selector.select();

            System.out.println("select");

            // SelectionKey表示了一个channel和事件的关联
            Iterator ite = this.selector.selectedKeys().iterator();
            while (ite.hasNext()) {


                SelectionKey key = (SelectionKey) ite.next();
                ite.remove();

                // client 连接到server事件
                if (key.isAcceptable()) {

                    System.out.println("可以接收");
                    accepte(key);
                }
                if (key.isReadable()) {
                    System.out.println("可以read");
                    read(key);
                }

            }
        }

    }

    /**
     * 处理client连接事件：将该channel注册到选择器中，注册读事件。这样可以在client发送信息时候 可以读取信息。
     *
     * @param key
     * @throws java.io.IOException
     */
    private final void accepte(final SelectionKey key) throws IOException {
        ServerSocketChannel ser = (ServerSocketChannel) key.channel();
        SocketChannel channel = ser.accept();

        addChannel(channel);
        configure(channel);


    }

    private final void configure(final SocketChannel channel)
            throws IOException {

        channel.configureBlocking(false);
        channel.register(this.selector, SelectionKey.OP_READ);
    }

    /**
     * 将channel添加到hashmap中
     *
     * @param channel
     * @throws java.io.IOException
     */
    private final void addChannel(final SocketChannel channel)
            throws IOException {

        String ip = channel.getRemoteAddress().toString();

        this.channels.put(this.channels.size(), channel);
        for (Integer counter = this.count.get(); !this.count.compareAndSet(
                counter, counter + 1); counter = this.count.get()) {

        }
        System.out.println("cas   old counter =" + this.count.get()
                + " remote ip =" + ip);

    }

    /**
     * 读取接收到的数据
     *
     * @param key
     * @throws java.io.IOException
     */
    private final void read(final SelectionKey key) throws IOException {


        SocketChannel channel = (SocketChannel) key.channel();
        ByteBuffer buf = ByteBuffer.allocate(1024);
        //ByteBuffer.

        channel.read(buf);
        buf.flip();

        byte[] bs = new byte[buf.limit()];
        buf.get(bs);
        System.out.println("接收到的消息：=" + new String(bs));

        ;

        //	((DirectBuffer)buf).cleaner().clean();

        //channel.write(ByteBuffer.wrap("receive".getBytes()));

    }


}
