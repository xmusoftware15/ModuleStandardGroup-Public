package xmu.crms.entity;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;

import org.springframework.context.annotation.Bean;

public class Event {
	
	private BigInteger id;
	
	private Date time;
	
	private Bean beanName;
	
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

	public Bean getBeanName() {
		return beanName;
	}

	public void setBeanName(Bean beanName) {
		this.beanName = beanName;
	}

	public HashMap getMap() {
		return map;
	}

	public void setMap(HashMap map) {
		this.map = map;
	}

	public Event() {
		
	}

	public Event(BigInteger id, Date time, Bean beanName, HashMap map) {
		super();
		this.id = id;
		this.time = time;
		this.beanName = beanName;
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
