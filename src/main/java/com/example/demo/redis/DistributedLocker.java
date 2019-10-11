package com.example.demo.redis;

import org.redisson.api.RLock;

import java.util.concurrent.TimeUnit;

public interface DistributedLocker {

    RLock lock(String key);

    RLock lock(String key,long time);

    RLock lock(String key, long time, TimeUnit timeUnit);

    boolean tryLock(String lockKey, TimeUnit unit, long waitTime, long leaseTime);

    void unLock(RLock rLock);

    void unLock(String key);


}
