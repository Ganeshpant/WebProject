package com.bway.webdemo.service;

import java.util.List;

import com.bway.webdemo.model.Student;

public interface StudentService {
    public boolean login(String name, String password);
	List<Student> getall();
}
