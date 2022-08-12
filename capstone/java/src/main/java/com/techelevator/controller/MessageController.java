package com.techelevator.controller;

import com.techelevator.dao.MessageDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Message;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
// @PreAuthorize("isAuthenticated()")

public class MessageController {

    private MessageDao messageDao;
    private UserDao userDao;

    public MessageController(MessageDao messageDao) {this.messageDao = messageDao;}

    @GetMapping("/inbox/{userId}")
    public List<Message> getMessagesOfCurrentUser(@PathVariable int userId) {
        return messageDao.getMessagesOfCurrentUser(userId);
    }
}
