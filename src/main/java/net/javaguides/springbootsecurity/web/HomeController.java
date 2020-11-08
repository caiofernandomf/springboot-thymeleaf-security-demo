package net.javaguides.springbootsecurity.web;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.springbootsecurity.entities.Message;
import net.javaguides.springbootsecurity.service.MessageService;

/**
 * @author Caio Fernando
 */

 @Controller
public class HomeController {    
    
    @Autowired
    private MessageService messageService;

    @GetMapping("/home")
    public String home(Principal principal,Model model){
        model.addAttribute("msgs",messageService.messageList(principal));
        return "userhome";
    }

    @PostMapping("/messages")
    public String saveMessage(Principal principal
                            ,Message message){        
        messageService.saveMessage(principal, message);
        return "redirect:/home";
    }
}