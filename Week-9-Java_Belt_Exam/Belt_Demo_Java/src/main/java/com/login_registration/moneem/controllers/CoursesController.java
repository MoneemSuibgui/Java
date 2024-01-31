package com.login_registration.moneem.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.login_registration.moneem.models.Course;
import com.login_registration.moneem.models.Student;
import com.login_registration.moneem.models.User;
import com.login_registration.moneem.services.CourseService;
import com.login_registration.moneem.services.StudentService;
import com.login_registration.moneem.services.UserService;

@Controller
public class CoursesController {

	// inject our services using @Autowired annotation
	@Autowired
	private CourseService courseServ;

	@Autowired
	private UserService userServ;

	@Autowired
	private StudentService studentServ;

	// Display route for dashboard page
	@GetMapping("/classes")
	public String Dashboard(Model modelView, HttpSession session) {
		// test if the userId in session or not
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		List<Course> courses = courseServ.all();
		modelView.addAttribute("courses", courses);
		Long id = (Long) session.getAttribute("userId");
		User loggedUser = userServ.findUserById(id);
		modelView.addAttribute("loggedUser", loggedUser);
		return "dashboard.jsp";
	}

	// Display route for new course form page
	@GetMapping("/classes/new")
	public String createCourse(@ModelAttribute("course") Course course, Model modelView,HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		return "newCourse.jsp";
	}

	// Action route adding course to database
	@PostMapping("/create/course")
	public String addCourse(@Valid @ModelAttribute("course") Course course, BindingResult result, HttpSession session) {
		if (result.hasErrors()) {
			return "newCourse.jsp";
		}
		User user = userServ.findUserById((Long) session.getAttribute("userId"));
		course.setCreator(user);
		courseServ.add(course);
		return "redirect:/classes";
	}

	// Display route edit course form page
	@GetMapping("/classes/{courseId}/edit")
	public String editCourse(@ModelAttribute("course") Course course, Model model,
							@PathVariable("courseId") Long courseId,HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		model.addAttribute("course", courseServ.getOne(courseId));
		return "editCourse.jsp";
	}

	// Action route update course
	@PutMapping("/update/course/{id}")
	public String updateCourse(@Valid @ModelAttribute("course") Course course, BindingResult result,
			@PathVariable("id") Long id, HttpSession session) {

		if (result.hasErrors()) {
			return "editCourse.jsp";
		}
		User user = userServ.findUserById((Long) session.getAttribute("userId"));
		course.setCreator(user);
		courseServ.update(course);

		return "redirect:/classes";

	}

	// Display route show course info 
	@GetMapping("/classes/{id}")
	public String showCourse(@ModelAttribute("student") Student student, @PathVariable("id") Long id, Model model,HttpSession session) {
		
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		Course course = courseServ.getOne(id);
		model.addAttribute("course", course);
		List<Student> students = studentServ.all();
		model.addAttribute("students", students);

		return "showOne.jsp";
	}


	@GetMapping("/delete/{courseId}")
	public String destroyCourse(@PathVariable("courseId") Long id) {
		Course course = courseServ.getOne(id);
		course.setCreator(null);
		courseServ.deleteCourse(id);
		return "redirect:/classes";
	}

	// Action route add student to db
	@PostMapping("/add/student/{courseId}")
	public String addStudent(@ModelAttribute("student") Student student, @PathVariable("courseId") Long courseId) {

		studentServ.add(student);
		return "redirect:/classes/" + courseId;
	}

	// Action route set student to the course and saved to database
	@PostMapping("/add/newStudent/{courseId}")
	public String addNewStudent(@PathVariable("courseId") Long courseId,
			@RequestParam(value = "studentId") Long studentId, Model model) {

		Course course = courseServ.getOne(courseId);

		Student student = studentServ.oneStudent(studentId);
		studentServ.add(student);
		course.getStudentsCourse().add(student);
		courseServ.update(course);
		model.addAttribute("student", new Student());

		return "redirect:/classes/" + courseId;
	}

}
