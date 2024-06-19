package com.example.hippobookproject.controller.user;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Pattern;

@RestController
@RequestMapping("/user")
public class UserPasswordDuplicateController {

    @PostMapping("/checkPassword")
    public boolean checkPassword(@RequestBody PasswordRequest passwordRequest){
        String userPassword = passwordRequest.getUserPassword();
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=`~{}|:;'<>,.?/]).{8,20}$";

        return Pattern.matches(passwordRegex, userPassword);
    }

    @Setter
    @Getter
    public static class PasswordRequest {
        private String userPassword;
    }
}
