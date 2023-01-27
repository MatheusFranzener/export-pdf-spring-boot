package br.senai.sc.generatepdf.repository;

import br.senai.sc.generatepdf.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepoPDF extends JpaRepository<Student, Long> {

}
