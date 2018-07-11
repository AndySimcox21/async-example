package com.example.asyncexample.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.asyncexample.data.TaskCacheDto;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;

@Service
public class CacheService {

	private static final Logger log = LoggerFactory.getLogger(CacheService.class);
	
	@Autowired
	private CacheManager cacheManager;
	
	public TaskCacheDto getCacheQueueTasks() throws Exception{
		log.debug("Received request getCacheQueueTasks");
		TaskCacheDto result = new TaskCacheDto();
		Cache taskCache = cacheManager.getCache("tasks");
		result.setSize(taskCache.getKeys().size());
		
		if(!taskCache.getKeys().isEmpty()) {
			result.setKeys(taskCache.getKeys());
		}
		
		return result;
	}
	
}
