package com.udacity.jwdnd.c1.review.mapper;

import com.udacity.jwdnd.c1.review.model.ChatMessage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MessageMapper {

    @Select("SELECT * FROM Messages")
    List<ChatMessage> getChatMessages();

    @Insert("INSERT INTO Messages (username, messageText) "
        + "VALUES (#{username}, #{messageText})")
    @Options(useGeneratedKeys = true, keyProperty = "messageid")
    int addMessage(ChatMessage chatMessage);
}
