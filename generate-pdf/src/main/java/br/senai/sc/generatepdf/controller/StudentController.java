package br.senai.sc.generatepdf.controller;

import br.senai.sc.generatepdf.PdfGenerator;
import br.senai.sc.generatepdf.entities.Student;
import br.senai.sc.generatepdf.service.StudentService;
import com.lowagie.text.DocumentException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/export-to-pdf")
    public void generatePdfFile(HttpServletResponse response) throws DocumentException, IOException
    {
        response.setContentType("application/pdf");
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
        String currentDateTime = dateFormat.format(new Date());
        String headerkey = "Content-Disposition";
        String headervalue = "attachment; filename=student" + currentDateTime + ".pdf";
        response.setHeader(headerkey, headervalue);
        List<Student> listofStudents = studentService.getStudentList();
        PdfGenerator generator = new PdfGenerator();
        generator.generate(listofStudents, response);
    }
}
