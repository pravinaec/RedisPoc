/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iplanet.im.server;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.Redisson;
import org.redisson.client.codec.Codec;
import org.redisson.codec.SerializationCodec;
import org.redisson.config.ClusterServersConfig;
import org.redisson.config.ReadMode;

/**
 *
 * @author pravisin
 */
public class RedisClusterUtility {
     private static RedissonClient client = null;
     static Config config = null;
     public static final String CLUSTER_URL = "iim_server.redis_url";
     public static String cluster_url = "";
     private static Codec codec = new SerializationCodec();     

     static {

          try {
               config = new Config();
               cluster_url = "redis://kkm00cya.in.oracle.com:6379, redis://kkm00aot.in.oracle.com:6380,redis://blr00bfm.in.oracle.com:6381";               
               String redis_urls[]=cluster_url.split(",");
               final Codec codec = new SerializationCodec();
               Config config = new Config();
               if(redis_urls.length>1){
               ClusterServersConfig c= config
                  .setCodec(codec)
                  .useClusterServers().setScanInterval(6000);
                    for (String redis_url : redis_urls) { 
                         c.addNodeAddress(redis_url.trim());
                    }
                    c.setReadMode(ReadMode.MASTER);
                    
               }else if(redis_urls.length==1){
                config
                   .setCodec(codec)
                   .useSingleServer().setAddress(redis_urls[0].trim());
               }            

               client = Redisson.create(config);           
          } catch (Throwable e) {
               printErrorOrException(e);
          }
         
     }

     public static RedissonClient getRedisClient() {
          return client;
     }
     public static void getShoutDownClient(RedissonClient client) {
          if (null != client) {
               client.shutdown();
          }
     }

     static void printErrorOrException(Throwable e) {
          ByteArrayOutputStream out1 = new ByteArrayOutputStream();
          PrintStream out2 = new PrintStream(out1);
          e.printStackTrace(out2);
          String message = out1.toString();
     }

}
