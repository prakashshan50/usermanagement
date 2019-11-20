package org.stack.oasis.application.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.stack.oasis.application.dto.CreateUserDto;
import org.stack.oasis.application.model.User;
import org.stack.oasis.application.repository.UserRepository;


@Service
public class UserService {

    private UserRepository userRepository;
    
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
    public List<User> findAll() {
        return userRepository.findAll();
    }
    public User save(CreateUserDto createUserDto) {
        User user = new User();
        updateUser(user, createUserDto);
        return userRepository.save(user);
    }
    public User activateUser(User user) {
        return userRepository.save(user);
    }
    private void updateUser(User user, CreateUserDto userDto) {
        user.setFullName(userDto.getFullName());
        user.setUserName(userDto.getUserName());
        user.setPassword(userDto.getPassword());
        user.setRoles(userDto.getRoles());
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setLocation(userDto.getLocation());       
    }
}
