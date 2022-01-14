package cn.tomhjx.lab.core.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/***
 * redisson配置
 */
@Configuration
public class RedissonConfig {

    public static final int THREADS = 4;

    public static final int NETTY_THREADS = 4;

    public static final int CONNECTION_MINIMUM_IDLE_SIZE = 2;
    public static final int CONNECTION_POOL_SIZE = 4;

    private final RedisProperties redisProperties;

    public RedissonConfig(RedisProperties redisProperties) {
        this.redisProperties = redisProperties;
    }

    @Bean
    public RedissonClient getRedisson() {
        Config config = new Config();
        config.setThreads(THREADS);
        config.setNettyThreads(NETTY_THREADS);
        SingleServerConfig singleServerConfig = config.useSingleServer().setAddress("redis://" + redisProperties.getHost() + ":" + redisProperties.getPort()).setDatabase(redisProperties.getDatabase());
        singleServerConfig.setConnectionMinimumIdleSize(CONNECTION_MINIMUM_IDLE_SIZE);
        singleServerConfig.setConnectionPoolSize(CONNECTION_POOL_SIZE);
        // if (StringUtils.isNotBlank(redisProperties.getPassword())) {
        //     singleServerConfig.setPassword(redisProperties.getPassword());
        // }

        return Redisson.create(config);
    }

}
