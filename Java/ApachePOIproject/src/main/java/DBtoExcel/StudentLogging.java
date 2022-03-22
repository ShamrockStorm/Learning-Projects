package DBtoExcel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


import persistance.StudentEntity;




public class StudentLogging {
	
	private static SessionFactory buildSessionFactory () {
		try {
			Configuration configuration = new Configuration();
			configuration.addAnnotatedClass(StudentEntity.class);
			return configuration.buildSessionFactory(new StandardServiceRegistryBuilder().build());
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("There was an error");
		}
	}
	
	public static List<StudentEntity> getStudentList() {
		SessionFactory sessionfactory = buildSessionFactory();
    	Session session = sessionfactory.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		session.beginTransaction();
        
        CriteriaQuery<StudentEntity> StudentCriteria = builder.createQuery(StudentEntity.class);
		Root<StudentEntity> StudentRoot = StudentCriteria.from(StudentEntity.class);
		StudentCriteria.select(StudentRoot);
		Query<StudentEntity> StudentQuery = session.createQuery(StudentCriteria);
		List<StudentEntity> StudentList = StudentQuery.getResultList();
		
		
		session.getTransaction().commit();
		session.close();
		
		return StudentList;
	}
	public static void main(String... args) throws IOException {
		 List<StudentEntity> StudentList = getStudentList();
		 
		 XSSFWorkbook workbook = new XSSFWorkbook(); 
	     XSSFSheet spreadsheet = workbook.createSheet("StudentsInfo");
	     XSSFRow row;
	     int rowid = 0;
	     row = spreadsheet.createRow(rowid++);
		 int t_cellid = 0;
		 Cell t_cell = row.createCell(t_cellid++);
         t_cell.setCellValue("ID");
         Cell t_cell1 = row.createCell(t_cellid++);
         t_cell1.setCellValue("First Name");
         Cell t_cell2 = row.createCell(t_cellid++);
         t_cell2.setCellValue("Last Name");
         Cell t_cell3 = row.createCell(t_cellid++);
         t_cell3.setCellValue("e-Mail");
		 
		 for(StudentEntity studentEntity : StudentList) {
			 row = spreadsheet.createRow(rowid++);
			 int cellid = 0;
			 Cell cell = row.createCell(cellid++);
             cell.setCellValue(studentEntity.getId());
             Cell cell1 = row.createCell(cellid++);
             cell1.setCellValue(studentEntity.getFirstName());
             Cell cell2 = row.createCell(cellid++);
             cell2.setCellValue(studentEntity.getLastName());
             Cell cell3 = row.createCell(cellid++);
             cell3.setCellValue(studentEntity.getEmail());
			}
		 FileOutputStream out = new FileOutputStream(new File("C:\\Users\\BD01813603\\Desktop\\Workspace\\StudentsWorkbook.xlsx"));

	     workbook.write(out);
	     out.close();
	     System.out.println("StudentsWorkbook.xlsx written successfully");
	}

}
