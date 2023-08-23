package ssgssak.ssgpointappclub.domain.club.presentation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ssgssak.ssgpointappclub.domain.club.application.ClubListService;
import ssgssak.ssgpointappclub.domain.club.application.ClubListServiceImpl;
import ssgssak.ssgpointappclub.domain.club.entity.ClubList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/club")
@Slf4j
public class ClubListController {
    ClubListServiceImpl clubListService;

    /*
    User 생성 시에 uuid 필드값만 지니고 나머지 필드값은 null인 ClubList를 생성한다.
     */
    @PostMapping("/clublist/{uuid}")
    public void createClubList(@PathVariable String uuid){
        log.info("INPUT uuid is : {}", uuid);
        clubListService.createClubList(uuid);
    }
}
