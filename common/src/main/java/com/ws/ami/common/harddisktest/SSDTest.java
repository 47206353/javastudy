package com.ws.ami.common.harddisktest;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by hp on 2015/7/3.
 */
@Slf4j
public class SSDTest {

    public static void main(String[] args) throws IOException {

        Date nowTime=new Date();
        System.out.println(nowTime);
        SimpleDateFormat time=new SimpleDateFormat("yyyy -MM- dd  : HH mm ss");
        System.out.println(time.format(nowTime));
        File file = new File("c:\\SYSAUX01.DBF");
        File outerror = new File("c:\\hardisktest\\error.log");
        File outinfo = new File("c:\\hardisktest\\info.log");
        InputStream in = null;
        OutputStream outerrorStream = null;
        Random random = new Random(500000);

        for (int i = 0; i < 10000; i++) {

            in = new FileInputStream(file);

            outerrorStream = new FileOutputStream(outinfo);
            outerrorStream.write("info ifno info info".getBytes());
            outerrorStream.flush();
            outerrorStream.close();

            log.info(" info info info [{}].\n",i);
            log.error(" error error  error [{}].\n",i);
            int r = random.nextInt()%5000000;

            in.skip( r<0?10:r);
            byte[] a = new byte[10];
            in.read(a);
            in.close();
           // log.error("dddd");
           // log.info(" Start to handle request [{}].\n");
        }
         nowTime=new Date();
        System.out.println(time.format(nowTime));

    }

}
