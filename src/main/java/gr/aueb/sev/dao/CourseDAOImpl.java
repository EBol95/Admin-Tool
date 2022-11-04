package gr.aueb.sev.dao;

import static gr.aueb.sev.dao.dbutil.DBUtil.closeConnection;
import static gr.aueb.sev.dao.dbutil.DBUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gr.aueb.sev.model.Course;

public class CourseDAOImpl implements ICourseDAO{
	
	@Override
	public void insert(Course course) throws SQLException {
		PreparedStatement pst = null;
		Connection conn = getConnection();
		
		try {
			String sql = "INSERT INTO COURSES (TEACHER_ID, DESCRIPTION) VALUES (?, ?)";
			// + "'" + course.getTeacherId() + "', " + "'" + course.getDescription() + "'"
			
			pst = conn.prepareStatement(sql);
			pst.setInt(1, course.getTeacherId());
			pst.setString(2, course.getDescription());
			
			
			pst.executeUpdate(); // we could add a variable as this returns the count of updates!!! (count of rows affected)
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pst != null) pst.close();
			if (getConnection() != null) closeConnection();
		}
	}
	
	@Override
	public Course delete(Course course) throws SQLException {
		PreparedStatement pst = null;
		Connection conn = getConnection();
		
		try {
			String sql = "DELETE FROM COURSES WHERE ID = ?";
			// + "'" + course.getTeacherId() + "', " + "'" + course.getDescription() + "'"
			
			pst = conn.prepareStatement(sql);
			pst.setInt(1, course.getId());
			
			int n = pst.executeUpdate();
			
			if (n==0) {
				return null;
			} else {
				return course;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pst != null) pst.close();
			if (getConnection() != null) closeConnection();
		}
	}
	
	@Override
	public void update(Course oldCourse, Course newCourse) throws SQLException {
		PreparedStatement pst = null;
		Connection conn = getConnection();
		
		try {
			String sql = "UPDATE COURSES SET TEACHER_ID = ?, DESCRIPTION = ? WHERE ID = ?";
			// + "'" + course.getTeacherId() + "', " + "'" + course.getDescription() + "'"
			
			pst = conn.prepareStatement(sql);
			pst.setInt(1, newCourse.getTeacherId());
			pst.setString(2, newCourse.getDescription());
			pst.setInt(3, oldCourse.getId());
			
			pst.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			if (pst != null) pst.close();
			if (getConnection() != null) closeConnection();
		}
	}
	
	@Override
	public List<Course> getCoursesByDescription(String description) throws SQLException {
		PreparedStatement pst = null;
		Connection conn = getConnection();
		List<Course> courses = new ArrayList<>();
		ResultSet rs = null;
		
		try {
			String sql = "SELECT ID, TEACHER_ID, DESCRIPTION FROM COURSES WHERE DESCRIPTION LIKE ?";
			// + "'" + course.getTeacherId() + "', " + "'" + course.getDescription() + "'"
			
			pst = conn.prepareStatement(sql);
			pst.setString(1, description + "%");
			
			rs = pst.executeQuery(); // the executeQuery returns a result set
			
			while (rs.next()) {
				Course course = new Course();
				course.setId(rs.getInt("ID"));
				course.setTeacherId(rs.getInt("TEACHER_ID"));
				course.setDescription(rs.getString("DESCRIPTION"));
				
				courses.add(course);
				
			}
			
			return courses;
			//return (courses.size() > 0) ? courses : null;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pst != null) pst.close();
			if (getConnection() != null) closeConnection();
		}
	}
	
	@Override
	public Course getCourseById(int id) throws SQLException {
		PreparedStatement pst = null;
		Connection conn = getConnection();
		Course course = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM COURSES WHERE ID = ?";
			// + "'" + course.getTeacherId() + "', " + "'" + course.getDescription() + "'"
			
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			
			rs = pst.executeQuery();
			
			if(rs.next()) {
				course = new Course();
				course.setId(rs.getInt("ID"));
				course.setTeacherId(rs.getInt("TEACHER_ID"));
				course.setDescription(rs.getString("DESCRIPTION"));
				
			}
			
			return course;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pst != null) pst.close();
			if (getConnection() != null) closeConnection();
		}
	
	}
}
