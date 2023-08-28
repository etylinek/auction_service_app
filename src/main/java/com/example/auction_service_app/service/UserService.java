package com.example.auction_service_app.service;


import com.example.auction_service_app.model.UserModel;
import com.example.auction_service_app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void addUser(UserModel user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public UserModel getUserByPrincipal(Principal principal) {
        return userRepository.findByAccountNameEquals(principal.getName());
    }

    public UserModel getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void editUser(UserModel editUser) {
        //editUser.setPassword(passwordEncoder.encode(editUser.getPassword()));
        userRepository.save(editUser);
    }


        public UserModel findByAccountName(String accountName) {
            return userRepository.findByAccountName(accountName).orElse(null);
                 //   .orElseThrow(() -> new UsernameNotFoundException("Użytkownik o podanej nazwie konta nie został znaleziony: " + accountName));
        }

}