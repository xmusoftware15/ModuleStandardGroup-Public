package xmu.crms.entity;

import java.math.BigInteger;
import java.util.Date;

public class Event {

    private BigInteger id;
    private String beanName;
    private String methodName;
    private String parameter;
    private Date time;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", beanName='" + beanName + '\'' +
                ", methodName='" + methodName + '\'' +
                ", parameter='" + parameter + '\'' +
                ", time=" + time +
                '}';
    }
}