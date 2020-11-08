package net.javaguides.springbootsecurity.service;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springbootsecurity.entities.Message;
import net.javaguides.springbootsecurity.repositories.MessageRepository;

@Service
public class MessageService {
    
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> messageList(Principal principal){
                
        return messageRepository.
                findByUser(
                    messageRepository.
                    findUserByEmail(
                        principal.getName()
                    ).get()
                );
    }
}