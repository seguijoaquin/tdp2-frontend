package com.example.android.linkup.models;

import java.util.Date;

/**
 * Created by joaquin on 07/10/17.
 */

public class ChatMessage {
    private String message;
    private String messageUser;
    private long messageTime;
    private boolean viewed;

    private String from;
    private boolean highlight;
    private String to;

    public ChatMessage(String messageText, String messageUser) {
        this.message = messageText;
        this.messageUser = messageUser;

        // Initialize to current time
        messageTime = new Date().getTime();
    }

    public ChatMessage(){

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessageUser() {
        return messageUser;
    }

    public void setMessageUser(String messageUser) {
        this.messageUser = messageUser;
    }

    public long getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(long messageTime) {
        this.messageTime = messageTime;
    }

    public boolean getViewed() {
        return viewed;
    }

    public void read() {
        this.viewed = true;
    }

    public void unread() {
        this.viewed = false;
    }
}
