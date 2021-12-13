package main.java.ObjectOriented.chatServer;

import java.util.Date;

public class Message {
    private String content;
    private Date timeStamp;

    public Message(String content, Date timeStamp){
        this.content = content;
        this.timeStamp = timeStamp;
    }

    public String getContent(){
        return content;
    }

    public Date getTimeStamp(){
        return timeStamp;
    }
}
