package lecture;

public class Lecture {
	private String lectureName;
	private String lectureUrl;
	private String lectureDesc;
	
	public Lecture() {
		super();
	}

	public Lecture(String lectureName, String lectureUrl, String lectureDesc) {
		super();
		this.lectureName = lectureName;
		this.lectureUrl = lectureUrl;
		this.lectureDesc = lectureDesc;
	}

	public String getLectureName() {
		return lectureName;
	}

	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}

	public String getLectureUrl() {
		return lectureUrl;
	}

	public void setLectureUrl(String lectureUrl) {
		this.lectureUrl = lectureUrl;
	}

	public String getLectureDesc() {
		return lectureDesc;
	}

	public void setLectureDesc(String lectureDesc) {
		this.lectureDesc = lectureDesc;
	}
	
}
