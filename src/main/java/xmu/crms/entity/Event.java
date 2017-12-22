package xmu.crms.entity;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;

import org.springframework.context.annotation.Bean;

public class Event {
	
	private BigInteger id;
	
	private Date time;
	
	private String beanName;

	private String methodName;

	private HashMap<BigInteger, String> map;

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

	public String getMethodName() {
		return methodName;
	}

	public void setMethod(String beanName) {
		this.methodName = methodName;
	}

	public HashMap getMap() {
		return map;
	}

	public void setMap(HashMap map) {
		this.map = map;
	}

	public Event() {
		
	}

	public Event(Date time, String beanName, String methodName, HashMap<BigInteger, String> map) {
		super();
		this.time = time;
		this.beanName = beanName;
		this.methodName = methodName;
		this.map = map;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + 
				", time=" + time + 
				", beanName=" + beanName + 
				", map=" + map + 
				"]";
	}
	
}
