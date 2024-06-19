package com.example.hippobookproject.service.user;

import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.service.DefaultMessageService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserOtpService {

    private final Map<String, String> otpStorage = new HashMap<>();
    private final DefaultMessageService messageService;

    public UserOtpService() {
        this.messageService = NurigoApp.INSTANCE.initialize("NCSY9XIYBUMND1DU", "EALLGJXCESAO60SMBUXZMTNITX0QKCCB", "https://api.coolsms.co.kr");
    }
//
//    public String generateOtp(String, UserPhonenubmer) {
//
//    }
}
