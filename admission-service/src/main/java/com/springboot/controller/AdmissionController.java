package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Admission;
import com.springboot.repository.AdmissionRepository;

@RestController
@RequestMapping("/admission")
public class AdmissionController {

	@Autowired
	private AdmissionRepository admissionRepository;

	@PostMapping
	public ResponseEntity<Admission> admitStudentToSchool(@RequestBody Admission admission) {
		return new ResponseEntity<>(admissionRepository.save(admission), HttpStatus.OK);
	}
}