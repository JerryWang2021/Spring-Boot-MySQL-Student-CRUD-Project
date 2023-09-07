package com.jerrywang.crud;

import com.jerrywang.crud.dao.StudentDAO;
import com.jerrywang.crud.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return runner -> {
//			createStudent(studentDAO);
			
			createMultipleStudents(studentDAO);

//			readStudent(studentDAO);

//			queryForStudents(studentDAO);

//			queryForStudentsByLastName(studentDAO);

//			updateStudent(studentDAO);

//			deleteStudent(studentDAO);

//			deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println(numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		// declare the id: the primary key
		int studentId = 1;
		// remove student
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {

		//retrieve student based on the id: primary key
		int studentId = 1;
		Student myStudent = studentDAO.findById(studentId);

		// Change first name to "Scooby"
		myStudent.setFirstName("Scooby");
		studentDAO.update(myStudent);

		// display updated student
		System.out.println(myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Doe");
		// display a list of students
		for (Student eachStudent : theStudents) {
			System.out.println(eachStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findAll();

		//display list of students
		for (Student eachStudent : theStudents) {
			System.out.println(eachStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		Student theStudent = studentDAO.findById(4);
		System.out.println(theStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		// create multiple students
		Student tempStudent1 = new Student("John", "Doe", "johnDoe@hotmail.com");
		Student tempStudent2 = new Student("Mary", "Public", "mary@hotmail.com");
		Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@hotmail.com");
		// save the student objects
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		System.out.println("Saved student. Generated id: " + tempStudent1.getId());
		System.out.println("Saved student. Generated id: " + tempStudent2.getId());
		System.out.println("Saved student. Generated id: " + tempStudent3.getId());


	}

	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		Student tempStudent = new Student("Jerry", "Wang", "jerrywang65@hotmail.com");

		// save the student object
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}

}
