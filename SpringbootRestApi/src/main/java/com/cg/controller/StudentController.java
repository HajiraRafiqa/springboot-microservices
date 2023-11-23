package com.cg.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bean.Student;

@RestController
public class StudentController {

	@GetMapping("student")
	public Student getStudent()
	{
		Student student = new Student
				(1, "A", "B" );
		return student;
	}
	
	@GetMapping("students")
	public List<Student> getStudents(){
		List<Student> students = new ArrayList<>();
		students.add(new Student(1, "A", "B"));
		students.add(new Student(2, "c", "d"));
		students.add(new Student(3, "d", "c"));
		
		return students;
		
		
	}
	
	//{id} -> URI template variable
	
	@GetMapping("students/{id}")
	public Student studentPathVariable(@PathVariable("id") int studentId,
			@PathVariable("first-name") String firstName,
            @PathVariable("last-name") String lastName)
	{
		return new Student(studentId, "B", "A");
	}
	
	@GetMapping("students/query")
    public Student studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName){
        return new Student(id, firstName, lastName);
    }
}

