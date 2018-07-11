package com.example.asyncexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.asyncexample.data.TaskCacheDto;
import com.example.asyncexample.service.CacheService;

@RestController
public class ExampleController {
	
	@Autowired
	private CacheService cacheService;

	@GetMapping("/api/getCachedQueueTasks")
	public @ResponseBody TaskCacheDto getCachedQueueTasks() throws Exception {
		return cacheService.getCacheQueueTasks();
	}
}
