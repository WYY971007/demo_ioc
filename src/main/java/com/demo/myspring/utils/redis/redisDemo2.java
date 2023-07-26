package com.demo.myspring.utils.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;

public class redisDemo2 {


    //排行榜
    public static void main(String[] args) {
        JedisPoolConfig config = new JedisPoolConfig();//设置最大连接数
        config.setMaxTotal(30);//设置最大的空闲连接数
        JedisPool jedisPool = new JedisPool(config,"127.0.0.1",6379);//获得核心对象：jedis
        Jedis jedis = null;
        jedis =jedisPool.getResource();//设置数据


        long start = System.currentTimeMillis();
        int n = 50;

        for (int i = 0; i < 20000; i++) {
            int num = 0 +(int)(Math.random()*(50 - 0 + 1));
            insert_redis(jedis, String.valueOf(num));

        }

        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }



    public static void insert_redis(Jedis jedis, String answer_id) {
        jedis.zincrby("answer1", 1, answer_id);
    }

    public static void query_redis(Jedis jedis) {
        List<String> R = jedis.lrange("answer",0,-1);
        System.out.println(R);
    }

}
