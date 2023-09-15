package ssgssak.ssgpointappclub.domain.club.presentation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import ssgssak.ssgpointappclub.domain.club.application.ClubListServiceImpl;
import ssgssak.ssgpointappclub.domain.club.dto.ClubListDto;
import ssgssak.ssgpointappclub.domain.club.vo.ClubListOutputVo;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/club")
@Slf4j
public class ClubListController {
    private final ClubListServiceImpl clubListService;
    private final ModelMapper modelMapper;

    /*
    아래는 어드민 API
    1. User 생성 시에 uuid 필드값만 지니고 나머지 필드값은 null인 ClubList를 생성한다.
    2. clubList데이터 삭제.
     */

    // 1. User 생성 시에 uuid 필드값만 지니고 나머지 필드값은 null인 ClubList를 생성한다.
    @PostMapping("/admin/clublist")
    public void createUserClubList(Principal principal){
        log.info("INPUT uuid is : {}", principal.getName());
        clubListService.createClubList(principal.getName());
    }

    // 2. clubList데이터 삭제
    @PutMapping("/admin/clublist")
    public void deleteUserClubList(Principal principal){
        log.info("INPUT uuid is : {}", principal.getName());
        clubListService.deleteClubList(principal.getName());
    }


    /*
    아래는 유저 API
    1. 마이 클럽 보여주기(클럽 카테고리로 이동할 시)
     */
    // 1. 마이 클럽 보여주기(클럽 카테고리로 이동할 시)
    @GetMapping("/clublist")
    public ResponseEntity<ClubListOutputVo> getMyClubList(Principal principal){
        log.info("INPUT uuid is : {}", principal.getName());
        ClubListDto clubListDto = clubListService.getMyClubList(principal.getName());
        log.info("OUTPUT clubListDto is : {}", clubListDto);
        ClubListOutputVo clubListOutputVo = modelMapper.map(clubListDto, ClubListOutputVo.class);
        log.info("OUTPUT clubListOutputVo is : {}", clubListOutputVo);
        return new ResponseEntity<>(clubListOutputVo, HttpStatus.OK);
    }
}
