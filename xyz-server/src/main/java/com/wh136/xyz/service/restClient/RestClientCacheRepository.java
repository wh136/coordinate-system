package com.wh136.xyz.service.restClient;


import com.wh136.xyz.common.util.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("restClientCacheRepository")
public class RestClientCacheRepository {

    private final String KEY_REDIS_DEMO = "KEY_REDIS_DEMO";

    @Resource
    private RedisUtil redisUtil;


}
