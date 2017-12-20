package xmu.crms.entity;

import java.math.BigInteger;

public class ClassInfo {
	private BigInteger id;
	private String name;
	private Course course;
	private String site;
	private String classTime;
	private String description;
	private Integer reportPercentage;
	private Integer presentationPercentage;
	private Integer fivePointPercentage;
	private Integer fourPointPercentage;
	private Integer threePointPercentage;
	
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getClassTime() {
		return classTime;
	}
	public void setClassTime(String classTime) {
		this.classTime = classTime;
	}
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getReportPercentage() {
		return reportPercentage;
	}
	public void setReportPercentage(Integer reportPercentage) {
		this.reportPercentage = reportPercentage;
	}
	public Integer getPresentationPercentage() {
		return presentationPercentage;
	}
	public void setPresentationPercentage(Integer presentationPercentage) {
		this.presentationPercentage = presentationPercentage;
	}
	public Integer getFivePointPercentage() {
		return fivePointPercentage;
	}
	public void setFivePointPercentage(Integer fivePointPercentage) {
		this.fivePointPercentage = fivePointPercentage;
	}
	public Integer getFourPointPercentage() {
		return fourPointPercentage;
	}
	public void setFourPointPercentage(Integer fourPointPercentage) {
		this.fourPointPercentage = fourPointPercentage;
	}
	public Integer getThreePointPercentage() {
		return threePointPercentage;
	}
	public void setThreePointPercentage(Integer threePointPercentage) {
		this.threePointPercentage = threePointPercentage;
	}
	
}