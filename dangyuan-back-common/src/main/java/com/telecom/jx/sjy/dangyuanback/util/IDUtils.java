package com.telecom.jx.sjy.dangyuanback.util;

import redis.clients.jedis.Jedis;

import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class IDUtils {

    private static AtomicInteger counter = new AtomicInteger(0);

    /**
     * id生成，未使用
     * @return
     */
    public static long getAtomicCounter() {
        if (counter.get() > 999999) {
            counter.set(1);
        }
        long time = System.currentTimeMillis();
        long returnValue = time * 100 + counter.incrementAndGet();
        return returnValue;
    }

    /**
     * 商品id生成
     */
    /*public static long getItemId() {
        //取当前时间的长整形值包含毫秒
        long millis = System.currentTimeMillis();
        //加上两位随机数
        Random random = new Random();
        int end2 = random.nextInt(99);
        //如果不足两位前面补0
        String str = millis + String.format("%02d", end2);
        long id = new Long(str);
        return id;
    }*/


    /**
     * 图片名生成
     * @return
     */
    public static String getImageName() {
        //取当前时间的长整形值包含毫秒
        long millis = System.currentTimeMillis();
        //long millis = System.nanoTime();
        //加上三位随机数
        Random random = new Random();
        int end3 = random.nextInt(999);
        //如果不足三位前面补0
        String str = millis + String.format("%03d", end3);
        return str;
    }

    /**
     * 18位末尾的数字id
     */
    private static int Guid = 100;

    public static long getItemId() {

        IDUtils.Guid += 1;

        long now = System.currentTimeMillis();
        //获取4位年份数字
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
        //获取时间戳
        String time = dateFormat.format(now);
        String info = now + "";
        //获取三位随机数
        //int ran=(int) ((Math.random()*9+1)*100);
        //要是一段时间内的数据量过大会有重复的情况，所以做以下修改
        int ran = 0;
        if (IDUtils.Guid > 999) {
            IDUtils.Guid = 100;
        }
        ran = IDUtils.Guid;
        long id = new Long(time + info.substring(2, info.length()) + ran);
        return id;
    }

    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.147.128",6379);
        //jedis.auth("temp890!@#");
        System.out.println(jedis.keys("*"));
        System.out.println(jedis.get("name"));
    }
}
