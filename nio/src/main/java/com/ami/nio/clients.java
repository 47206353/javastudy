package com.ami.nio;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ConcurrentHashMap;

public class clients {

	final static String host = "127.0.0.1";
	final static int port = 8080;
	final static int numberOfConnects = 300;
	final static ConcurrentHashMap sockets = new ConcurrentHashMap<Integer, Socket>();

	public static void main(String[] args) throws Exception {

		for (int i = 0; i < numberOfConnects; i++) {
			Socket socket = connect(host, port);
			System.out.println(i);
			add(new Integer(i), socket);
		}

		monitor();

	}

	/**
	 * 打印
	 */
	private static void monitor() {

		Thread monitor = new Thread(new Runnable() {

			public void run() {

				while (true) {
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("client 数码为 =" + sockets.size());
				}
			}
		});

		monitor.start();
	}

	/**
	 * 和主机建立一个socket连接
	 *
	 * @throws java.net.UnknownHostException
	 * @throws java.io.IOException
	 */

	private static Socket connect(final String host, final int port)
			throws UnknownHostException, IOException {

		try {

			Socket client = new Socket(host, port);

			Writer writer = new OutputStreamWriter(client.getOutputStream());
			writer.write("Hello Server.");
			writer.flush();
			return client;
			// writer.close();
			// client.close();

		} catch (Exception e) {
			System.gc();
			System.out.println("内存溢出");
		
		}
		

		return null;

	}

	/**
	 * 将socket进入到map中去
	 * 
	 * @param position
	 * @param socket
	 */
	private synchronized static void add(final Integer position, final Socket socket) {
		if(position != null && socket != null)
		sockets.putIfAbsent(position, socket);

	}

	/*
	 * private static class Monitor implements Runnable {
	 * 
	 * public void run() { System.out.println("client 数码为 =" + sockets.size());
	 * 
	 * } }
	 */
}
