package gr.aueb.sev.service;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.sev.dto.CourseDTO;
import gr.aueb.sev.model.Course;
import gr.aueb.sev.service.exceptions.CourseNotFoundException;

public interface ICourseService {
	/**
	 * Inserts a {@link Course} based on the data carried by the P{@link CourseDTO}
	 * 
	 * @param courseDTO
	 * 			DTO object that contains the data. 
	 * @throws SQLException
	 * 			if any error happens during SQL insert 
	 */
	void insertCourse(CourseDTO courseDTO) throws SQLException;
	/**
	 * Deletes {@link Course} based on the data carried by the P{@link CourseDTO}
	 * 
	 * @param courseDTO
	 * 			DTO object that contains the data.
	 * @throws SQLException
	 * 			if any error happens during SQL insert
	 * @throws CourseNotFoundException
	 * 			if the course is not found
	 * 			
	 */
	void deleteCourse(CourseDTO courseDTO) throws SQLException, CourseNotFoundException;
	/**
	 * Updates a {@link Course} based on the data carried by the P{@link CourseDTO} of the new course
	 * 
	 * @param oldCourseDTO
	 * 			DTO object that contains the old data.
	 * @param newCourseDTO
	 * 			DTO object that contains the new data.
	 * @throws SQLException
	 * 			if any error happens during SQL insert
	 */
	void updateCourse(CourseDTO oldCourseDTO, CourseDTO newCourseDTO) throws SQLException;
	/**
	 * Gets a list of {@link List} of {@link Course} based on their descriptions
	 * @param description 
	 * 			a string of object that contains the description of the courses we are looking for or part of it
	 * @return 
	 * 			{@link List} of {@link Course} found based on description
	 * @throws SQLException
	 * 			if any error happens during SQL insert
	 */
	List<Course> getCoursesByDescription(String description) throws SQLException;
	
	/**
	 * Returns a {@link Course} based on h@ id
	 * @param id
	 * 			the id of the courses we are looking for
	 * @return
	 * 			the {@link Course} with the appropriate id or null if the course not found
	 * @throws SQLException
	 * 			if any error happens during SQL insert
	 * @throws CourseNotFoundException
	 * 			if the courses is not found
	 */
	Course getCourseById(int id) throws SQLException, CourseNotFoundException;



}
