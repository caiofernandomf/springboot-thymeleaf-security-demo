package net.javaguides.springbootsecurity.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springbootsecurity.entities.Message;
import net.javaguides.springbootsecurity.entities.User;

/**
 * @author Caio Fernando
 */
public interface MessageRepository extends JpaRepository<Message,Integer>{
    Optional <User> findUserByEmail(String email);
    List<Message> findByUser(User user);    
}