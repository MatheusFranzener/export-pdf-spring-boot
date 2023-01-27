package br.senai.sc.generatepdf.service;

import br.senai.sc.generatepdf.entities.Student;
import br.senai.sc.generatepdf.repository.StudentRepoPDF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepoPDF studentRepo;

    @Override
    public void addStudent(Student student) {
        studentRepo.save(student);
    }

    @Override
    public List<Student> getStudentList() {
        return studentRepo.findAll();
    }

}
