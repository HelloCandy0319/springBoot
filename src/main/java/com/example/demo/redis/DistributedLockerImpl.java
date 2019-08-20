package com.example.demo.redis;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class DistributedLockerImpl implements DistributedLocker {

    @Autowired
    RedissonClient redissonClient;

    @Override
    public RLock lock(String key) {
        RLock rLock = redissonClient.getLock(key);
        rLock.lock();
        return rLock;
    }

    @Override
    public RLock lock(String key, long time) {
        RLock rLock = redissonClient.getLock(key);
        rLock.lock(time,TimeUnit.SECONDS);
        return rLock;
    }

    @Override
    public RLock lock(String key, long time, TimeUnit timeUnit) {
        RLock rLock = redissonClient.getLock(key);
        rLock.lock(time,timeUnit);
        return rLock;
    }

    @Override
    public boolean tryLock(String lockKey, TimeUnit unit, long waitTime, long leaseTime) {
       RLock lock = redissonClient.getLock(lockKey);
       try {
           return lock.tryLock(waitTime,leaseTime,unit);
       }catch (Exception e){
           return false;
       }
    }

    @Override
    public void unLock(RLock rLock) {
       rLock.unlock();
    }

    @Override
    public void unLock(String key) {
        RLock rLock = redissonClient.getLock(key);
        rLock.unlock();
    }
}
