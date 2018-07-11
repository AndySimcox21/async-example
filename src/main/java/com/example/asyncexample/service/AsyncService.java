package com.example.asyncexample.service;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import com.example.asyncexample.data.StudentDto;

@Service
public class AsyncService {

	@Async("threadPoolTaskExecutor")
	public Future<StudentDto> save(StudentDto dto) throws InterruptedException {
		//some long running process
		Thread.sleep(50000);
		return new AsyncResult<>(dto);
	}
}
