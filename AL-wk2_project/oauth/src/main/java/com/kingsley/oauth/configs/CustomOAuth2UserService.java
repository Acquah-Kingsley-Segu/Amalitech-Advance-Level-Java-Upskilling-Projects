package com.kingsley.oauth.configs;

import com.kingsley.oauth.Users;
import com.kingsley.oauth.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipal;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService{
    private final UserRepository userRepository;

    public CustomOAuth2UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        String username = oAuth2User.getAttribute("name");
        String email = oAuth2User.getAttribute("email");
        Users user = userRepository.findByEmail(email)
                .orElseGet(() -> {
                    String password = email+"-"+username;
                    return  new Users(email, password, username);
                });
        userRepository.save(user);
        return oAuth2User;
    }
}
