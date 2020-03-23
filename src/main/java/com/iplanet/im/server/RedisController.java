package com.iplanet.im.server;


import org.springframework.web.bind.annotation.*;

import org.redisson.api.RedissonClient;

@RestController
public class RedisController {


    // Find
    @GetMapping("/flushall")
    String flushall() {
         RedissonClient client=RedisClusterUtility.getRedisClient();
         client.getKeys().flushall();
        return "Sussess";
    }
@GetMapping("/checkflush")
    String checkFlush() {
         RedissonClient client=RedisClusterUtility.getRedisClient();
         if(client.getKeys().count()==0L){
              return "DONE";
         }else{
              return "SomeProblem";
         }
    }

}
