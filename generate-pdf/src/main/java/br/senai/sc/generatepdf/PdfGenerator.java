package br.senai.sc.generatepdf;

import br.senai.sc.generatepdf.entities.Student;
import com.lowagie.text.*;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class PdfGenerator {
    public void generate(List<Student> studentList, HttpServletResponse response) throws DocumentException, IOException {
        // Creating the Object of Document
        Document document = new Document(PageSize.A4);
        // Getting instance of PdfWriter
        PdfWriter.getInstance(document, response.getOutputStream());
        // Opening the created document to change it
        document.open();
        // Creating font
        // Setting font style and size
        Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        fontTiltle.setSize(20);
        // Creating paragraph
        Paragraph paragraph1 = new Paragraph("List of the Students", fontTiltle);
        // Aligning the paragraph in the document
        paragraph1.setAlignment(Paragraph.ALIGN_CENTER);
        // Adding the created paragraph in the document
        document.add(paragraph1);
        // Creating a table of the 4 columns
        PdfPTable table = new PdfPTable(4);
        // Setting width of the table, its columns and spacing
        table.setWidthPercentage(100);
        table.setWidths(new int[]{3, 3, 3, 3});
        table.setSpacingBefore(5);
        // Create Table Cells for the table header
        PdfPCell cell = new PdfPCell();
        // Setting the background color and padding of the table cell
        cell.setBackgroundColor(CMYKColor.BLUE);
        cell.setPadding(5);
        // Creating font
        // Setting font style and size
        Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        font.setColor(CMYKColor.WHITE);
        // Adding headings in the created table cell or  header
        // Adding Cell to table
        cell.setPhrase(new Phrase("ID", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Student Name", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Email", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Mobile No", font));
        table.addCell(cell);
        // Iterating the list of students
        for (Student student : studentList) {
            // Adding student id
            table.addCell(String.valueOf(student.getId()));
            // Adding student name
            table.addCell(student.getStudentName());
            // Adding student email
            table.addCell(student.getEmail());
            // Adding student mobile
            table.addCell(student.getMobileNo());
        }
        // Adding the created table to the document
        document.add(table);
        // Closing the document
        document.close();
    }

//    public void generateDemanda(Demanda demanda,  HttpServletResponse response) throws  DocumentException, IOException{
//
//        Document document = new Document(PageSize.A4);
//
//        PdfWriter.getInstance(document, response.getOutputStream());
//
//        document.open();
//
//        Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
//        fontTiltle.setSize(20);
//
//        Paragraph paragraph1 = new Paragraph("Demanda 01", fontTiltle);
//        paragraph1.setAlignment(Paragraph.ALIGN_CENTER);
//        document.add(paragraph1);
//
//        Paragraph paragraph2 = new Paragraph("T??tulo: ", fontTiltle);
//        paragraph2.setAlignment(Paragraph.ALIGN_LEFT);
//        document.add(paragraph2);
//
//        Paragraph paragraph3 = new Paragraph(demanda.getTitulo(), fontTiltle);
//        paragraph3.setAlignment(Paragraph.ALIGN_LEFT);
//        document.add(paragraph3);
//
//        document.close();
//    }
}
