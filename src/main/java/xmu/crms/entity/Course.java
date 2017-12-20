package xmu.crms.entity;

import java.math.BigInteger;
import java.util.Date;

public class Course {
	private BigInteger id;
	private String name;
	private Date startDate;
	private Date endDate;
	private User teacher;
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
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public User getTeacher() {
		return teacher;
	}
	public void setTeacher(User teacher) {
		this.teacher = teacher;
	}
	public String getDescription() {
		return description;
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
