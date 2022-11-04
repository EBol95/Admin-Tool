package gr.aueb.sev.service;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.sev.dto.CourseDTO;
import gr.aueb.sev.dto.StudentCourseDTO;
import gr.aueb.sev.model.Course;
import gr.aueb.sev.model.Student;
import gr.aueb.sev.model.StudentCourse;
import gr.aueb.sev.service.exceptions.CourseNotFoundException;
import gr.aueb.sev.service.exceptions.StudentCourseNotFoundException;
import gr.aueb.sev.service.exceptions.StudentNotFoundException;

public interface IStudentCourseService {
	/**
	 * Inserts a {@link StudentCourse} based on the data carried by the P{@link StudentCourseDTO}
	 * 
	 * @param studentCourseDTO
	 * 			DTO object that contains the data. 
	 * @throws SQLException
	 * 			if any error happens during SQL insert 
	 */
	void insertStudentCourse(StudentCourseDTO studentCourseDTO) throws SQLException;
	/**
	 * Deletes {@link StudentCourse} based on the data carried by the P{@link StudentCourseDTO}
	 * 
	 * @param studentCourseDTO
	 * 			DTO object that contains the data.
	 * @throws SQLException
	 * 			if any error happens during SQL insert
	 * @throws StudentCourseNotFoundException
	 * 			if the course is not found
	 * 			
	 */
	void deleteStudentCourse(StudentCourseDTO studentCourseDTO) throws SQLException, StudentCourseNotFoundException;
	/**
	 * Updates a {@link StudentCourse} based on the data carried by the P{@link StudentCourseDTO} of the new course
	 * 
	 * @param studentDTO
	 * 			DTO object that contains the student data.
	 * @param courseDTO
	 * 			DTO object that contains the new data.
	 * @throws SQLException
	 * 			if any error happens during SQL insert
	 */
	List<Course> getCoursesByStudent(int studentId) throws SQLException;
	
	/**
	 * Returns a {@link List} of {Course} based on h@ id
	 * @param id
	 * 			the id of the courses we are looking for
	 * @return
	 * 			the {@link Course} with the appropriate id or null if the course not found
	 * @throws SQLException
	 * 			if any error happens during SQL insert
	 * @throws StudentNotFoundException
	 * 			if the courses is not found
	 */
	List<Student> getStudentsByCourse(int courseId) throws SQLException;
	
	/**
	 * Returns a {@link List} of {Student} based on h@ id
	 * @param id
	 * 			the id of the students we are looking for
	 * @return
	 * 			the {@link Student} with the appropriate id or null if the student not found
	 * @throws SQLException
	 * 			if any error happens during SQL insert
	 * @throws CourseNotFoundException
	 * 			if the courses is not found
	 */
	
	List<Course> getCoursesNotInStudent (int studentId) throws SQLException;
	
	/**
	 * Returns a {@link List} of {Course} based on h@ id
	 * @param id
	 * 			the id of the courses we are looking for
	 * @return
	 * 			the {@link Course} with the appropriate id or null if the course not found
	 * @throws SQLException
	 * 			if any error happens during SQL insert
	 * @throws StudentNotFoundException
	 * 			if the courses is not found
	 */
	
	List<Student> getStudentsNotInCourse (int courseId) throws SQLException;
	/**
	 * Returns a {@link List} of {Student} based on h@ id
	 * @param id
	 * 			the id of the students we are looking for
	 * @return
	 * 			the {@link Student} with the appropriate id or null if the student not found
	 * @throws SQLException
	 * 			if any error happens during SQL insert
	 * @throws CourseNotFoundException
	 * 			if the courses is not found
	 */
}
