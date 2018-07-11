package com.example.asyncexample.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.asyncexample.data.StudentDto;
import com.example.asyncexample.data.TaskCacheDto;
import com.example.asyncexample.service.CacheService;
import com.example.asyncexample.service.StudentService;

@RestController
public class ExampleController {
	
	@Autowired
	private CacheService cacheService;
	
	@Autowired
	private StudentService studentService;

	@GetMapping("/api/getCachedQueueTasks")
	public @ResponseBody TaskCacheDto getCachedQueueTasks() throws Exception {
		return cacheService.getCacheQueueTasks();
	}
	
	@PostMapping("/api/student")
	public @ResponseBody ResponseEntity<StudentDto> save(@Valid @RequestBody StudentDto dto) throws Exception {
		return ResponseEntity.status(HttpStatus.CREATED).body(studentService.save(dto));
	}
}
