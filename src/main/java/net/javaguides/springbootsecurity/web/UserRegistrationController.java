package net.javaguides.springbootsecurity.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import net.javaguides.springbootsecurity.dto.UserRegistrationDto;
import net.javaguides.springbootsecurity.entities.Role;
import net.javaguides.springbootsecurity.repositories.RoleRepository;
import net.javaguides.springbootsecurity.service.UserService;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
    
    @Autowired
    private UserService userService;
    @Autowired
    private RoleRepository roleRepository;
    
    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto(){
        return new UserRegistrationDto();
    }

    @ModelAttribute("roles")
    public List<Role> listOfRoles(){
        return roleRepository.findAll();
    }

    @GetMapping
    public String showRegistrationForm(Model model){
        return "registration";
    }
}