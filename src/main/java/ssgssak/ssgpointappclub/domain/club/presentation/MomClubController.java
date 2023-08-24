package ssgssak.ssgpointappclub.domain.club.presentation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ssgssak.ssgpointappclub.domain.club.dto.MomClubDto;
import ssgssak.ssgpointappclub.domain.club.application.MomClubServiceImpl;
import ssgssak.ssgpointappclub.domain.club.vo.MomClubInputVo;
import ssgssak.ssgpointappclub.domain.club.vo.MomClubOutputVo;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/club/mom-kids")
public class MomClubController {
    private final MomClubServiceImpl momClubService;
    private final ModelMapper modelMapper;
    // 맘키즈 클럽 가입
    @PostMapping("/{uuid}")
    public void joinClub(@RequestBody MomClubInputVo momClubInputVo, @PathVariable String uuid){
        log.info("INPUT Object Data is : {}" , momClubInputVo);
        MomClubDto momClubDto = modelMapper.map(momClubInputVo, MomClubDto.class);
        momClubService.createClubUser(momClubDto, uuid);
    }
    // 맘키즈 클럽 정보 불러오기
    @GetMapping("/{uuid}")
    public ResponseEntity<MomClubOutputVo> getClubUserInfo(@PathVariable String uuid){
        log.info("INPUT uuid is : {}", uuid);
        MomClubDto momClubDto = momClubService.getClubUser(uuid);
        log.info("OUTPUT momClubDto is : {}", momClubDto);
        MomClubOutputVo momClubOutputVo = modelMapper.map(momClubDto, MomClubOutputVo.class);
        log.info("OUTPUT momClubOutputVo is : {}", momClubOutputVo);
        return new ResponseEntity<>(momClubOutputVo, HttpStatus.OK);
    }
    // 맘키즈 클럽 정보 수정 및 삭제하기
    @PutMapping("/{uuid}")
    public void updateClubUserInfo(@RequestBody MomClubInputVo momClubInputVo, @PathVariable String uuid){
        log.info("INPUT Object Data is : {}" , momClubInputVo);
        MomClubDto momClubDto = modelMapper.map(momClubInputVo, MomClubDto.class);
        momClubService.updateClubUser(momClubDto, uuid);
    }

}
