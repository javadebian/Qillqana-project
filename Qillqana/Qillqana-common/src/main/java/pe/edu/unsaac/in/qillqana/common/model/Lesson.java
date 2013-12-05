package pe.edu.unsaac.in.qillqana.common.model;

import java.util.List;

public class Lesson {
	private int id;
	private String title;
	private String state;
	
	private List<LessonFile> files;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<LessonFile> getFiles() {
		return files;
	}

	public void setFiles(List<LessonFile> files) {
		this.files = files;
	}
	
}
