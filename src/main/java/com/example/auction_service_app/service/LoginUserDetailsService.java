package com.example.auction_service_app.service;

import com.example.auction_service_app.dao.LoginUserPrincipal;
import com.example.auction_service_app.model.UserModel;
import com.example.auction_service_app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = userRepository.findByAccountNameEquals(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new LoginUserPrincipal(user);
    }


}
