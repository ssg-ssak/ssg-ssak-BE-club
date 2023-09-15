package ssgssak.ssgpointappclub.domain.club.presentation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ssgssak.ssgpointappclub.domain.club.application.BeautyClubService;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/club/beauty")
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class BeautyClubController {
    private final BeautyClubService beautyClubService;

    // 뷰티 클럽 가입
    @PostMapping("")
    public void joinClub(Principal principal){
        log.info("uuid is : {}" , principal.getName());
        beautyClubService.createClubUser(principal.getName());
    }

    // 뷰티 클럽 가입 여부 확인
    @GetMapping("")
    public Boolean isClubUser(Principal principal){
        log.info("uuid is : {}" , principal.getName());
        if(beautyClubService.isBeautyClubUser(principal.getName())) {
            log.info("뷰티 클럽 가입 여부 : {}" , "가입되어있음");
            return true;
        }
        else {
            log.info("뷰티 클럽 가입 여부 : {}" , "미가입");
            return false;
        }
    }

    // 뷰티 클럽 탈퇴
    @PutMapping("")
    public void leaveClub(Principal principal){
        log.info("uuid is : {}" , principal.getName());
        beautyClubService.deleteClubUser(principal.getName());
    }
}
