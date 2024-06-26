package com.example.hippobookproject.controller.user;

import com.example.hippobookproject.dto.user.UserResponseDto;
import com.example.hippobookproject.service.user.UserIdDuplicateService;
import com.example.hippobookproject.service.user.UserIdDuplicateServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.regex.Pattern;

import static org.springframework.web.servlet.function.ServerResponse.badRequest;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserIdDuplicateController {

    @Autowired
    private UserIdDuplicateService userIdDuplicateService;

    private static final Pattern ID_PATTERN = Pattern.compile("^[a-z0-9]{6,12}$");

    @PostMapping("/checkDuplicate")
    @ResponseBody
    public ResponseEntity<Boolean> confirmId(@RequestBody Map<String, String> requestBody){
        String userLoginId = requestBody.get("userLoginId");
        log.info("register..............");
        log.info("userLoginId:"+userLoginId);

        if(!isValidId(userLoginId)) {
            log.info("Invalid userLoginId : " + userLoginId);
            return ResponseEntity.badRequest().build();
        }

       boolean result = !userIdDuplicateService.selectId(userLoginId);

       return new ResponseEntity<>(result, HttpStatus.OK);
    }

    private boolean isValidId(String id) {
        return ID_PATTERN.matcher(id).matches();
    }
}
