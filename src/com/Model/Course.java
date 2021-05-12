package com.Model;

import java.time.LocalDate;

public class Course {
	private int courseID;
	private String courseName;
	private int courseTrainer;
	private int preRequisite;
	private int duration;
	private LocalDate startDate;
	private LocalDate endDate;
	private String timings;
	private String url;
	
	public Course() {}
	public Course(int courseID, String courseName, int courseTrainer, int preRequisites,
			int duration, LocalDate startDate, LocalDate endDate, String timings, String url) {
		super();
		this.courseID = courseID;
		this.courseName = courseName;
		this.courseTrainer = courseTrainer;
		this.preRequisite = preRequisites;
		this.duration = duration;
		this.startDate = startDate;
		this.endDate = endDate;
		this.timings = timings;
		this.url = url;
	}
	public int getCourseID() {
		return courseID;
	}
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getCourseTrainer() {
		return courseTrainer;
	}
	public void setCourseTrainer(int courseTrainer) {
		this.courseTrainer = courseTrainer;
	}
	public int getPreRequisite() {
		return preRequisite;
	}
	public void setPreRequisite(int preRequisites) {
		this.preRequisite = preRequisites;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public String getTimings() {
		return timings;
	}
	public void setTimings(String timings) {
		this.timings = timings;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
