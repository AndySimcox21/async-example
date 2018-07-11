package com.example.asyncexample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.asyncexample.data.StudentDto;

@Service
public class StudentService {
	
	@Autowired
	private AsyncService asyncService;

	public StudentDto save(StudentDto dto) throws InterruptedException {
		asyncService.save(dto);
		return dto;
	}
}
