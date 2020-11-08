package net.javaguides.springbootsecurity.web;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.springbootsecurity.entities.Message;
import net.javaguides.springbootsecurity.repositories.MessageRepository;

/**
 * @author Caio Fernando
 */

 @Controller
public class HomeController {
    
    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/home")
    public String home(Model model){

        model.addAttribute("msgs",messageRepository.findAll());
        return "userhome";
    }

    @PostMapping("/messages")
    public String saveMessage(Principal principal
                            ,Message message){        
        messageRepository.save(message);        
        return "redirect:/home";
    }
}