package xmu.crms.entity;

import java.math.BigInteger;

public class SeminarGroupMember {
	private BigInteger id;
	private SeminarGroup seminarGroup;
	private User student;
	
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public SeminarGroup getSeminarGroup() {
		return seminarGroup;
	}
	public void setSeminarGroup(SeminarGroup seminarGroup) {
		this.seminarGroup = seminarGroup;
	}
	public User getStudent() {
		return student;
	}
	public void setStudent(User student) {
		this.student = student;
	}

}
