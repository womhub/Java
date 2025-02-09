package com.example.demo.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.SpringSession;
import com.example.demo.repository.LoginMapper;

import jakarta.servlet.http.HttpSession;

@Service
public class CustomSessionService {
	@Autowired
	private LoginMapper mapper;
	
	public void saveSession(HttpSession session) {
        SpringSession springSession = new SpringSession();
        springSession.setSessionId(session.getId());
        springSession.setPrincipalName((String) session.getAttribute("username"));
        springSession.setCreationTime(session.getCreationTime());
        springSession.setLastAccessedTime(session.getLastAccessedTime());
        springSession.setMaxInactiveInterval(session.getMaxInactiveInterval());
        springSession.setAttributes(serializeSessionAttributes(session));
        
        mapper.insertSession(springSession);  // セッションをDBに保存
    }

	
	 private byte[] serializeSessionAttributes(HttpSession session) { 
		 try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		         ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {
		        
		        // セッションの属性をすべてシリアライズする
		        Enumeration<String> attributeNames = session.getAttributeNames();
		        
		        // 属性のMapを作成
		        Map<String, Object> attributes = new HashMap<>();
		        while (attributeNames.hasMoreElements()) {
		            String attributeName = attributeNames.nextElement();
		            Object attributeValue = session.getAttribute(attributeName);
		            attributes.put(attributeName, attributeValue);
		        }
		        
		        // 属性のMapをシリアライズ
		        objectOutputStream.writeObject(attributes);
		        objectOutputStream.flush();
		        
		        // シリアライズされたデータをバイト配列として返す
		        return byteArrayOutputStream.toByteArray();
		        
		    } catch (IOException e) {
		        e.printStackTrace();
		        return null; // エラー処理は適宜行ってください
		    }
		}
	 
	 
}
