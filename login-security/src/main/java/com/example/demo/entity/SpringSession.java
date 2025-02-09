package com.example.demo.entity;

import lombok.Data;

@Data
public class SpringSession {
	private String sessionId;
    private String principalName;
    private long creationTime;
    private long lastAccessedTime;
    private int maxInactiveInterval;
    private byte[] attributes;

}
