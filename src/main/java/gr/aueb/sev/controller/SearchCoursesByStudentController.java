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
import gr.aueb.sev.model.Course;
import gr.aueb.sev.service.IStudentCourseService;
import gr.aueb.sev.service.StudentCourseServiceImpl;


@WebServlet("/search/coursesbystudent")
public class SearchCoursesByStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	IStudentCourseDAO studentCourseDAO = new StudentCourseDAOImpl();
	IStudentCourseService studentCourseServ = new StudentCourseServiceImpl(studentCourseDAO);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		int studentId = Integer.parseInt(request.getParameter("studentId").trim());
		
		try {
			List<Course> courses = studentCourseServ.getCoursesByStudent(studentId);
			
			if (courses.size() == 0) {
				request.setAttribute("courseNotFound", true);
				request.setAttribute("studentId", studentId);
				request.getRequestDispatcher("/jsps/studentsmenu.jsp")
				.forward(request, response);
			} else {
				request.setAttribute("courses", courses);
				request.setAttribute("studentId", studentId);
				request.getRequestDispatcher("/jsps/removecoursefromstudent.jsp")
					.forward(request, response);
			}
		}catch (SQLException e) {
			request.setAttribute("sqlError", true);
			request.getRequestDispatcher("/jsps/removecoursefromstudent.jsp")
				.forward(request, response);
		}
	}
}
