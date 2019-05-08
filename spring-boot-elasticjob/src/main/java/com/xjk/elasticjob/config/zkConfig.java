package com.xjk.elasticjob.config;

import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class zkConfig {

    /**
     * 配置zookeeper
     *
     * @param serverLists
     * @param namespace
     * @return
     */
    @Bean
    public ZookeeperRegistryCenter regCenter(@Value("${zookeeper.serverLists}") final String serverLists, @Value("${zookeeper.namespace}") final String namespace) {
        ZookeeperRegistryCenter registryCenter = new ZookeeperRegistryCenter(new ZookeeperConfiguration(serverLists, namespace));
        registryCenter.init();
        return registryCenter;
    }
}
