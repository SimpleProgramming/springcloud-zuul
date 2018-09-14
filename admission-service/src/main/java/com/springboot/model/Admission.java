package com.springboot.model;

import java.io.Serializable;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

public class Admission implements Serializable {

	private static final long serialVersionUID = 1L;

	@PrimaryKeyColumn(name = "admission_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
	@Column("admission_id")
	private String admissionId;

	@PrimaryKeyColumn(name = "school_name", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
	@Column("school_name")
	private String schoolName;

	@Column("student")
	private Student student;

	public String getAdmissionId() {
		return admissionId;
	}

	public void setAdmissionId(String admissionId) {
		this.admissionId = admissionId;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}
