package com.techelevator.controller;

import com.techelevator.dao.MessageDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Message;
import com.techelevator.model.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")

public class MessageController {

    private MessageDao messageDao;
    private UserDao userDao;

    public MessageController(MessageDao messageDao, UserDao userDao) {
        this.messageDao = messageDao;
        this.userDao = userDao;
    }

    @GetMapping("/inbox")
    public List<Message> getMessagesOfCurrentUser(@Valid Principal user) {
        User currentUser = userDao.findByUsername(user.getName());
        int userId = currentUser.getId();
        return messageDao.getMessagesOfCurrentUser(userId);
    }
}
