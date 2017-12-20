package xmu.crms.entity;

import java.math.BigInteger;

public class FixGroupMember {
	private BigInteger id;
	private FixGroup fixGroup;
	private User student;
	
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public FixGroup getFixGroup() {
		return fixGroup;
	}
	public void setFixGroup(FixGroup fixGroup) {
		this.fixGroup = fixGroup;
	}
	public User getStudent() {
		return student;
	}
	public void setStudent(User student) {
		this.student = student;
	}

}
