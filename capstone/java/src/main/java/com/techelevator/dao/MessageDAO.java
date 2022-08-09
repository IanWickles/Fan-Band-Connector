package com.techelevator.dao;

import com.techelevator.model.Message;

import java.util.List;

public interface MessageDAO {

    List<Message> getMessages(int userId);

    // messageFans()

    void deleteMessage(int messageId);

}
