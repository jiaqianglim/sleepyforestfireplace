package com.hype.webmvc._messenging;

public class MessageCount implements Comparable<MessageCount> {

    public int count;
    public String topicname;

    @Override
    public int compareTo(MessageCount o) {
        return (int) (o.count - this.count);
    }

}
