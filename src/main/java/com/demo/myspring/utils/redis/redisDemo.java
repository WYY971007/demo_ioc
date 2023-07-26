package com.demo.myspring.utils.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;


public class redisDemo {

    //最新n篇文章
    public static void main(String[] args) {

        JedisPoolConfig config = new JedisPoolConfig();//设置最大连接数
        config.setMaxTotal(30);//设置最大的空闲连接数
        JedisPool jedisPool = new JedisPool(config,"127.0.0.1",6379);//获得核心对象：jedis
        Jedis jedis = null;
        jedis = jedisPool.getResource();//设置数据


        long start = System.currentTimeMillis();
        int n = 50;

        for (int i = 0; i < 150; i++) {
            insert_redis(jedis, String.valueOf(i), n);

            for (int j = 0; j < 150; j++) {
                query_redis(jedis);
            }
        }

        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }







    public static void insert_redis(Jedis jedis, String answer_id, int n) {
        jedis.lpush("answer", answer_id);
        jedis.ltrim("answer",0,n-1);
    }

    public static void query_redis(Jedis jedis) {
         List<String> R = jedis.lrange("answer",0,-1);
        System.out.println(R);
    }



}
