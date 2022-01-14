package cn.tomhjx.lab.core.service;

import java.util.concurrent.TimeUnit;

import org.redisson.api.RBucket;
import org.redisson.api.RList;
import org.redisson.api.RLock;
import org.redisson.api.RMap;
import org.redisson.api.RQueue;
import org.redisson.api.RSortedSet;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedisSampleService {
    // https://dinghuang.github.io/2019/03/26/Spring%20Data%20Redis%E4%B8%8ERedisson%E5%AF%B9%E6%AF%94/

    @Autowired
    private UtilService utilService;

    @Autowired
    private RedissonClient redis;

    public void general() {
        // string
        RBucket<String> s1 = redis.getBucket("s1");
        s1.set("i test at "+utilService.getCurTime());
        System.out.println(s1.get());

        s1.set("i test at "+utilService.getCurTime()+" (ttl) ", 3600, TimeUnit.SECONDS);
        System.out.println(s1.get());

        s1.delete();

        RBucket<String> s2 = redis.getBucket("s2", new StringCodec("utf-8"));
        s2.set("i test(2) at "+utilService.getCurTime());
        System.out.println(s2.get());


        // hash
        RMap<String, String> h1 = redis.getMap("h1");
        h1.put("f1", "haf1,"+utilService.getCurTime());
        h1.put("f2", "haf2,"+utilService.getCurTime());
        System.out.println(h1.get("f2"));

        // list
        RList<String> l1 = redis.getList("l1", new StringCodec("utf-8"));
        l1.add("l1e1,"+utilService.getCurTime());
        l1.add("l1e2,"+utilService.getCurTime());
        l1.add("l1e3,"+utilService.getCurTime());
        l1.add("l1e4,"+utilService.getCurTime());

        System.out.println("list(1) 0...2:");
        System.out.println(l1.range(0, 2));
        System.out.println("list(1) size:");
        System.out.println(l1.size());
       
        // queue

        RQueue<String> q1 = redis.getQueue("q1");
        q1.add("q1e1,"+utilService.getCurTime());
        q1.add("q1e2,"+utilService.getCurTime());
        q1.offer("q1e3,"+utilService.getCurTime());

        System.out.println(q1.peek());
        System.out.println(q1.remove());

        // SortedSet

        RSortedSet<Integer> ss1 = redis.getSortedSet("ss1");
        ss1.add(3);
        ss1.add(1);
        ss1.add(2);
        System.out.println("sorted set (1) first:");
        System.out.println(ss1.first());

        // lock
        RLock lock1 = redis.getLock("lock1");
        lock1.lock();

    }
}
