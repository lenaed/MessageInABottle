package com.lenaegerer.messageinabottle.services;

import com.lenaegerer.messageinabottle.model.User;
import com.lenaegerer.messageinabottle.repositories.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Component
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private String getCurrentUserId(){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes instanceof ServletRequestAttributes) {
            HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
            String userId = request.getHeader("user-id");
            if (userId == null) {
                throw new RuntimeException("user-id not set in the request header");
            }
            return userId;
        }
        throw new RuntimeException("not a http request");
    }

    public void checkIfUserExists(String userId) {
        userRepository.existsById(userId);


        if (!userRepository.existsById(userId)){
            throw new RuntimeException("user" + userId + " doesn't exist!");
        }
    }

    public User getCurrentUser(){
        String userId = getCurrentUserId();
       Optional<User> user= userRepository.findById(userId);
      return user.orElseThrow(() -> new RuntimeException("user" + userId + " doesn't exist!"));

    }

}
