package com.techelevator.dao;

import com.techelevator.model.Message;

import java.util.List;

public interface MessageDAO {

    List<Message> getMessagesOfCurrentUser(int userId);

    List<Message> sortMessagesByDate();

    List <Message> sortMessagesByBandName();

    Boolean sendMessageToFollowers(Message newMessage,int mgrId);

   // void deleteMessage(int messageId);

}
