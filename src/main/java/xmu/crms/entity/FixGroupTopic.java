package xmu.crms.entity;

import java.math.BigInteger;

/**
 *
 * @author badcode
 * @date 2017/12/23
 *
 */
public class FixGroupTopic {

    private BigInteger id;
    private FixGroup fixGroup;
    private Topic topic;

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

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "FixGroupTopic{" +
                "id=" + id +
                ", fixGroup=" + fixGroup +
                ", topic=" + topic +
                '}';
    }
}
