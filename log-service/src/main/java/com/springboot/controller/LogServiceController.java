package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springboot.model.Log;
import com.springboot.repository.LogServiceRepository;

@RestController
@RequestMapping("/log")
public class LogServiceController {

	@Autowired
	private LogServiceRepository repository;

	@PostMapping
	@HystrixCommand
	public void logRequest(@RequestBody Log log) {
		repository.save(log);
	}
}