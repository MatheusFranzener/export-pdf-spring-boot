package br.senai.sc.generatepdf.service;

import br.senai.sc.generatepdf.entities.Student;

import java.util.List;

public interface StudentService {

    void  addStudent(Student student);

    List<Student> getStudentList();
}
