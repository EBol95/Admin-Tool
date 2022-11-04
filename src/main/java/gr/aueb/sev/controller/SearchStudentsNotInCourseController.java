package gr.aueb.sev.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.aueb.sev.dao.IStudentCourseDAO;
import gr.aueb.sev.dao.StudentCourseDAOImpl;
import gr.aueb.sev.model.Student;
import gr.aueb.sev.service.IStudentCourseService;
import gr.aueb.sev.service.StudentCourseServiceImpl;


@WebServlet("/search/studentsnotincourse")
public class SearchStudentsNotInCourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	IStudentCourseDAO studentCourseDAO = new StudentCourseDAOImpl();
	IStudentCourseService studentCourseServ = new StudentCourseServiceImpl(studentCourseDAO);
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		int courseId = Integer.parseInt(request.getParameter("courseId").trim());
		
		try {
			List<Student> students = studentCourseServ.getStudentsNotInCourse(courseId);
			
			if (students.size() == 0) {
				request.setAttribute("studentNotFound", true);
				request.setAttribute("courseId", courseId);
				request.getRequestDispatcher("/coursesmenu")
				.forward(request, response);
			} else {
				request.setAttribute("students", students);
				request.setAttribute("courseId", courseId);
				request.getRequestDispatcher("/jsps/addstudenttocourse.jsp")
					.forward(request, response);
			}
		}catch (SQLException e) {
			request.setAttribute("sqlError", true);
			request.getRequestDispatcher("/jsps/addstudenttocourse.jsp")
				.forward(request, response);
		}
	}
}
