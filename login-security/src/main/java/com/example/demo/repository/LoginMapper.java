package com.example.demo.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.entity.SpringSession;
import com.example.demo.entity.User;

@Mapper
public interface LoginMapper {
	User selectUserByName(String username);
	
	// セッションの情報を挿入
    //@Insert("INSERT INTO spring_sessions (session_id, principal_name, creation_time, last_accessed_time, max_inactive_interval, attributes) VALUES (#{sessionId}, #{principalName}, #{creationTime}, #{lastAccessedTime}, #{maxInactiveInterval}, #{attributes})")
    void insertSession(SpringSession springSession);

    // セッション情報を取得
    //@Select("SELECT * FROM spring_sessions WHERE session_id = #{sessionId}")
    SpringSession getSessionById(String sessionId);
    
    //ユーザーを追加
    void insertUser(User user);

}
