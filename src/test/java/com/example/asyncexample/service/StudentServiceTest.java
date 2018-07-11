package com.example.asyncexample.service;

import static org.apache.commons.lang.RandomStringUtils.*;
import static org.junit.Assert.*;

import java.util.concurrent.Future;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.scheduling.annotation.AsyncResult;

import com.example.asyncexample.data.StudentDto;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
public class StudentServiceTest {

	@Tested
	StudentService studentService;

	@Injectable
	AsyncService asyncService;
	
	private StudentDto dto;
	private Future<StudentDto> futureDto;
	
	@Before
	public void setUp() {
		dto = new StudentDto();
		dto.setStudentId(1);
		dto.setStudentName(randomAlphanumeric(12));
		dto.setAddress(randomAlphanumeric(50));
		
		dto = new StudentDto();
		dto.setStudentId(1);
		dto.setStudentName(randomAlphanumeric(12));
		dto.setAddress(randomAlphanumeric(50));
		futureDto = new AsyncResult<>(dto);
	}
	
	@Test
	public void testSaveStudent() throws Exception {
		
		new Expectations() {{
			asyncService.save(dto); result = futureDto;
		}};
		
		StudentDto newStudent = studentService.save(dto);
		assertNotNull(newStudent);
		assertEquals(1, newStudent.getStudentId());
	}
}
