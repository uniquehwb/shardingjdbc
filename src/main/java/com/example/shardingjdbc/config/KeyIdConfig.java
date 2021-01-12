package com.example.shardingjdbc.config;

import org.apache.shardingsphere.core.strategy.keygen.SnowflakeShardingKeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeyIdConfig {
    @Bean("userKeyGenerator")
    public SnowflakeShardingKeyGenerator userKeyGenerator() {
        return new SnowflakeShardingKeyGenerator();
    }

    @Bean("orderKeyGenerator")
    public SnowflakeShardingKeyGenerator orderKeyGenerator() {
        return new SnowflakeShardingKeyGenerator();
    }
}
