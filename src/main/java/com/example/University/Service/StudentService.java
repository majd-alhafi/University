package com.example.University.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.University.DTO.StudentDTO;
import com.example.University.Model.Course;
import com.example.University.Model.Student;
import com.example.University.Repository.CoursesRepo;
import com.example.University.Repository.StudentRepo;


@Service
public class StudentService {
	@Autowired
	StudentRepo studentRepo;
	
	@Autowired
	CoursesRepo courseRepo;

	public List<Student> getAllStudents() {
		return studentRepo.findAll();
	}
	

	private Optional<Student> getStudent(Long id) {
		return studentRepo.findById(id);
	}
	
	private StudentDTO convertDataIntoDTO(Student student) {
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setName(student.getName());
		return studentDTO;
	}
	
	private boolean checkUserExist(String Email) {
		Student tempStudent =  studentRepo.findByEmail(Email);
		if (tempStudent != null) {
			return true;
		}
		return false;
	}
	
	public boolean checkIfStudentLoggedIn(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) 
				if (cookie.getName().equals("StudentLoggedin"))
					return true;
		}
			return false;
	}
	
	private boolean checkCredentials(Student student, List<Student> students) {
		String studentEmail = student.getEmail();
		String studentPassword = student.getPassword();
		for(int i=0;i<students.size();i++) {
			Student tempStudent = (Student) students.get(i);
			String tempEmail = tempStudent.getEmail();
			String tempPassword = tempStudent.getPassword();
			if (tempEmail.equals(studentEmail) && tempPassword.equals(studentPassword))
				return true;
		}
		return false;
	}
	
	public void addStudent(Student newStudent) {
		if (!checkUserExist(newStudent.getEmail())) {
			studentRepo.save(newStudent);
		}
	}
	
	public List<StudentDTO> getStudents(){
		return getAllStudents()
				.stream() 
				.map(this::convertDataIntoDTO)
				.collect(Collectors.toList());
	}

	public String studentLogging(Student student, HttpServletResponse response) {
		if(checkCredentials(student,getAllStudents())) {
			Cookie cookie = new Cookie("StudentLoggedin", "True");
			response.addCookie(cookie);
			return "Hello ";
		}
		return "Credentials are not corrected try again..";
	}

	public void enrollInCourse(List<Integer> courseId, Long id) {
		Set<Course> courses = new HashSet<Course>();
		courseId.forEach(c -> {
			Optional<Course> t = courseRepo.findById(c);
			courses.add(t.get());
		});
		Student s = getStudent(id).get();
		s.setCourses(courses);
		studentRepo.save(s);
		
	}


	public Set<String> getStudentCoursesName(Long id) {
		Set<String> courses = new HashSet<String>();
		getStudent(id).get().getCourses().forEach(t -> courses.add(t.getName()));
		return courses;
	}
}
