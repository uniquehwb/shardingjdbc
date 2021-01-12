package com.example.shardingjdbc.sharding;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

public class UserShardingAlgorithm {
    public static final DatabaseShardingAlgorithm databaseShardingAlgorithm = new DatabaseShardingAlgorithm();
    public static final TableShardingAlgorithm tableShardingAlgorithm = new TableShardingAlgorithm();

    static class DatabaseShardingAlgorithm implements PreciseShardingAlgorithm<Long> {
        @Override
        public String doSharding(Collection<String> databaseNames, PreciseShardingValue<Long> shardingValue) {
            for (String database : databaseNames) {
                if (database.endsWith(String.valueOf(shardingValue.getValue() % 2))) {
                    return database;
                }
            }

            return "";
        }
    }

    static class TableShardingAlgorithm implements PreciseShardingAlgorithm<Long> {
        @Override
        public String doSharding(Collection<String> tableNames, PreciseShardingValue<Long> shardingValue) {
            for (String table : tableNames) {
                if (table.endsWith(String.valueOf(shardingValue.getValue() % 2))) {
                    return table;
                }
            }

            return "";
        }
    }
}
