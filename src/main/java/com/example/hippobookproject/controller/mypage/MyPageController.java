package com.example.hippobookproject.controller.mypage;

import com.example.hippobookproject.dto.mypage.*;
import com.example.hippobookproject.service.mypage.MypageService;
import com.example.hippobookproject.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MyPageController {
    private final UserService userService;
    private final MypageService mypageService;

    @GetMapping("/int")
    public String myPageInt(Model model/*@SessionAttribute("userId") Long userId*/) {
        Long userId = 1L;

        IntProfileDto profilePhoto = mypageService.findProfilePhoto(userId);
        model.addAttribute("profilePhoto", profilePhoto);

        IntProfileDto profileDto = mypageService.findProfile(userId);
        model.addAttribute("profileDto", profileDto);
        log.info("profileDto={}", profileDto);

        IntBoardDto intBoardDto = mypageService.findIntBoardText(userId);
        model.addAttribute("intBoardDto", intBoardDto);


        List<BookContainerDto> bookContainerList = mypageService.findRecentBook(userId);
        model.addAttribute("bookContainerList", bookContainerList);
        return "mypage/myPageInt";
    }

    @PostMapping("/int")
    public String myPageInt(IntBoardDto intBoardDto) {
        intBoardDto.setUserId(1L);
        log.info("IntBoardDto = {}", intBoardDto);
        mypageService.registerIntBoardText(intBoardDto);
        return "redirect:/mypage/int";
    }


    @GetMapping("/book/container")
    public String bookContainer(Model model) {
        Long userId = 1L;

        IntProfileDto profilePhoto = mypageService.findProfilePhoto(userId);
        model.addAttribute("profilePhoto", profilePhoto);

        List<BookContainerDto> bookContainerList = mypageService.findBookContainer(userId);
        model.addAttribute("bookContainerList", bookContainerList);

        IntProfileDto profileDto = mypageService.findProfile(userId);
        model.addAttribute("profileDto", profileDto);


        log.info("bookContainerList={}", bookContainerList);
        return "mypage/myPageBookContainer";
    }


    @GetMapping("/book/write-content")
    public String bookWriteContent(Model model/*@SessionAttribute("userId") Long userId*/) {
        Long userId = 1L;

        IntProfileDto profileDto = mypageService.findProfile(userId);
        model.addAttribute("profileDto", profileDto);
        log.info("profileDto={}", profileDto);

        List<MyContentDto> myContentList = mypageService.findMyContent(userId);
        model.addAttribute("myContentList", myContentList);

        log.info("myContentList={}", myContentList);

        Long reviewCount = mypageService.findReviewCount(userId);
        model.addAttribute("reviewCount", reviewCount);

        Long postCount = mypageService.findPostCount(userId);
        model.addAttribute("postCount", postCount);

        IntProfileDto profilePhoto = mypageService.findProfilePhoto(userId);
        model.addAttribute("profilePhoto", profilePhoto);


        return "mypage/myWriteContent";
    }

    @GetMapping("/sticker")
    public String myPageSticker(Model model/*@SessionAttribute("userId") Long userId*/) {
        Long userId = 1L;
        IntProfileDto profileDto = mypageService.findProfile(userId);
        model.addAttribute("profileDto", profileDto);
        log.info("profileDto={}", profileDto);

        IntProfileDto profilePhoto = mypageService.findProfilePhoto(userId);
        model.addAttribute("profilePhoto", profilePhoto);

        return "mypage/myPageInt_stiker";
    }

    @PostMapping("/sticker")
    public String myPageSticker(StickerDto stickerDto,
                                @SessionAttribute(value = "userId", required = false) Long userId,
                                RedirectAttributes redirectAttributes) {
        stickerDto.setUserId(1L);
        log.info("stickerDto={}", stickerDto);
        mypageService.registerSticker(stickerDto);
        redirectAttributes.addFlashAttribute("stickerId", stickerDto.getStikerId());
        return "redirect:/mypage/sticker";
    }
//            intBoardDto.setUserId(1L);
//        log.info("IntBoardDto = {}", intBoardDto);
//        mypageService.registerIntBoardText(intBoardDto);
//        return "redirect:/mypage/int";


    @GetMapping("/manage")
    public String myPageManage() {
        return "mypage/myPageInt_manage";
    }

    @GetMapping("/modify")
    public String myPageModify() {
        return "mypage/myPageInt_modify";
    }

    @GetMapping("/secession")
    public String myPageSecession() {
        return "mypage/myPageInt_secession";
    }
}
