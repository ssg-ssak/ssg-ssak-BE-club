package ssgssak.ssgpointappclub.domain.club.presentation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ssgssak.ssgpointappclub.domain.club.application.BeautyClubService;

@RestController
@RequestMapping("/api/v1/club/beauty")
@Slf4j
@RequiredArgsConstructor
public class BeautyClubController {
    private final BeautyClubService beautyClubService;

    // 뷰티 클럽 가입
    @PostMapping("/{uuid}")
    public void createClubUser(@PathVariable String uuid){
        log.info("uuid is : {}" , uuid);
        beautyClubService.createClubUser(uuid);
    }

    // 뷰티 클럽 가입 여부 확인
    @GetMapping("/{uuid}")
    public Boolean getClubUser(@PathVariable String uuid){
        log.info("uuid is : {}" , uuid);
        if(beautyClubService.getClubUser(uuid)) {
            log.info("뷰티 클럽 가입 여부 : {}" , "가입되어있음");
            return true;
        }
        else {
            log.info("뷰티 클럽 가입 여부 : {}" , "미가입");
            return false;
        }
    }

    // 뷰티 클럽 탈퇴
    @PutMapping("/{uuid}")
    public void deleteClubUser(@PathVariable String uuid){
        log.info("uuid is : {}" , uuid);
        beautyClubService.deleteClubUser(uuid);
    }
}
