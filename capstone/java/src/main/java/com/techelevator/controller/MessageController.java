package com.techelevator.controller;

import com.techelevator.dao.BandDAO;
import com.techelevator.dao.MessageDAO;
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

    private MessageDAO messageDAO;

    public MessageController(MessageDAO messageDAO) {this.messageDAO = messageDAO;}

    @GetMapping("/inbox/{userId}")
    public List<Message> getMessagesOfCurrentUser(@PathVariable int userId) {
        return messageDAO.getMessagesOfCurrentUser(userId);
    }
}
