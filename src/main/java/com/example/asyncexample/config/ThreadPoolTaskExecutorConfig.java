package com.example.asyncexample.config;

import java.util.concurrent.Executor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class ThreadPoolTaskExecutorConfig {

	@Value("${threadpool.core.pool.size}")
	private int corePoolSize;
	
	@Value("${threadpool.max.size}")
	private int maxPoolSize;
	
	@Value("${threadpool.queue.capacity}")
	private int queueCapacity;
	
	@Value("${threadpool.keepalive.seconds}")
	private int keepAliveSeconds;
	
	@Bean(name = "threadPoolTaskExecutor")
	public Executor threadPoolTaskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(corePoolSize);
		executor.setMaxPoolSize(maxPoolSize);
		executor.setQueueCapacity(queueCapacity);
		executor.setThreadNamePrefix("AsyncPool-");
		executor.setKeepAliveSeconds(keepAliveSeconds);
		executor.initialize();
		return executor;
	}
}
