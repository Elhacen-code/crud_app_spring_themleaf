package com.ouhamza.crud_app.service;

import java.util.List;

import com.ouhamza.crud_app.dao.StudentRepo;
import com.ouhamza.crud_app.model.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    
    @Autowired
    private StudentRepo studentRepo;


    public List<Student> getAll(){
        return studentRepo.findAll();
    }

    public void save(Student student){
        studentRepo.save(student);
    }

    public Student get(long id) {
        return studentRepo.findById(id).get();
    }

}