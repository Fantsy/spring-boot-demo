package com.xjk.elasticjob.job.simple;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 任务调度
 */
public class ApiMyElasticJobSimple implements SimpleJob {

    @Override
    public void execute(ShardingContext context) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        int key = context.getShardingItem();

        switch (key) {
            case 0:
                System.out.println("date:" + LocalDateTime.now().format(dtf) + ", task:" + context.getJobName() + ", sharding item 0 " + context.getShardingParameter());
                break;
            case 1:
                System.out.println("date:" + LocalDateTime.now().format(dtf) + ", task:" + context.getJobName() + ", sharding item 1 " + context.getShardingParameter());
                break;
            case 2:
                System.out.println("date:" + LocalDateTime.now().format(dtf) + ", task:" + context.getJobName() + ", sharding item 2 " + context.getShardingParameter());
                break;
            default:
                System.out.println("没有任务调度执行");
                break;
        }

    }


}
