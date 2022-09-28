package com.lenaegerer.messageinabottle.service;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
public class UserService {

    public String getCurrentUserId(){
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

}
