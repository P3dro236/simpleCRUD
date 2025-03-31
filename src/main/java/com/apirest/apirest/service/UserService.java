package com.apirest.apirest.service;

import com.apirest.apirest.repository.UserRepository;
import com.apirest.apirest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Optional<User> findUserById(Integer id) {
        return userRepository.findById(id);
    }

    public User updateEmail(Integer id, String newEmail) {
        if (newEmail == null || newEmail.isEmpty()) {
            throw new IllegalArgumentException("O email não pode ser vazio");
        }
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
        user.setEmail(newEmail);
        return userRepository.save(user);
    }

    public User createUser(User user) {
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new IllegalArgumentException("O email não é válido");
        }
        if (user.getCompleteName() == null || user.getCompleteName().isEmpty()) {
            throw new IllegalArgumentException("O nome não é válido");
        }
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new IllegalArgumentException("A senha não é válida");
        }
        return userRepository.save(user);
    }

    public void deleteUser(Integer id) {
        if (id <= 0) {
            throw new IllegalArgumentException("O id precisa ser um número válido");
        }
        userRepository.deleteById(id);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}