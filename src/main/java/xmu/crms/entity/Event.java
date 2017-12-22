package xmu.crms.entity;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;

public class Event {
	
	private BigInteger id;
	
	private Date time;
	
	private String beanName;
	
	private String methodName;
	
	private HashMap<BigInteger, String> paramMap;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public HashMap<BigInteger, String> getParamMap() {
		return paramMap;
	}

	public void setParamMap(HashMap<BigInteger, String> paramMap) {
		this.paramMap = paramMap;
	}

	public Event() {
		
	}

	public Event(BigInteger id, Date time, String beanName, String methodName, HashMap<BigInteger, String> paramMap) {
		super();
		this.id = id;
		this.time = time;
		this.beanName = beanName;
		this.methodName = methodName;
		this.paramMap = paramMap;
	}


	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	

	@Override
	public String toString() {
		return "Event [id=" + id + 
				", time=" + time + 
				", beanName=" + beanName + 
				", methodName=" + methodName + 
				", paramMap=" + paramMap + "]";
	}
	
}
