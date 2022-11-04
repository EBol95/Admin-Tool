package gr.aueb.sev.dto;

public class CourseDTO {
	
	private int id;
	private int teacherId;
	private String description;
	
	public CourseDTO() {}

	public CourseDTO(int id, int teacherId, String description) {
		super();
		this.id = id;
		this.teacherId = teacherId;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
