package gr.aueb.sev.model;

public class StudentCourse {
	private int studentId;
	private int courseId;
	
	
	public StudentCourse() {}


	public StudentCourse(int studentId, int courseId) {
		super();
		this.studentId = studentId;
		this.courseId = courseId;
	}


	public int getStudentId() {
		return studentId;
	}


	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}


	public int getCourseId() {
		return courseId;
	}


	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	
	
	
	

}
