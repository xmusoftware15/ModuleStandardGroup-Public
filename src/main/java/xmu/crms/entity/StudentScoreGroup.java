package xmu.crms.entity;

import java.math.BigInteger;

public class StudentScoreGroup {
	private BigInteger id;
	private User student;
	private SeminarGroupTopic seminarGroupTopic;
	private Integer grade;
	
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public User getStudent() {
		return student;
	}
	public void setStudent(User student) {
		this.student = student;
	}
	public SeminarGroupTopic getSeminarGroupTopic() {
		return seminarGroupTopic;
	}
	public void setSeminarGroupTopic(SeminarGroupTopic seminarGroupTopic) {
		this.seminarGroupTopic = seminarGroupTopic;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "StudentScoreGroup{" +
				"id=" + id +
				", student=" + student +
				", seminarGroupTopic=" + seminarGroupTopic +
				", grade=" + grade +
				'}';
	}
}
