package ssgssak.ssgpointappclub.domain.club.presentation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ssgssak.ssgpointappclub.domain.club.application.BizClubServiceImpl;
import ssgssak.ssgpointappclub.domain.club.dto.BizClubDto;
import ssgssak.ssgpointappclub.domain.club.vo.BizClubInputVo;
import ssgssak.ssgpointappclub.domain.club.vo.BizClubOutputVo;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/club/biz")
public class BizClubController {
    private final BizClubServiceImpl bizClubService;
    private final ModelMapper modelMapper;

    // 비즈니스 클럽 가입
    @PostMapping("/{uuid}")
    public void createClubUser(@RequestBody BizClubInputVo bizClubInputVo, @PathVariable String uuid){
        log.info("INPUT Object Data is : {}" , bizClubInputVo);
        BizClubDto bizClubDto = modelMapper.map(bizClubInputVo, BizClubDto.class);
        bizClubService.createClubUser(bizClubDto, uuid);
    }
    // 비즈니스 클럽 가입 정보 불러오기
    @GetMapping("/{uuid}")
    public ResponseEntity<BizClubOutputVo> getClubUser(@PathVariable String uuid){
        log.info("INPUT uuid is : {}" , uuid);
        BizClubDto bizClubDto = bizClubService.getClubUser(uuid);
        log.info("OUTPUT bizClubDto is : {}" , bizClubDto);
        BizClubOutputVo bizClubOutputVo = modelMapper.map(bizClubDto, BizClubOutputVo.class);
        log.info("OUTPUT bizClubOutputVo is : {}" , bizClubOutputVo);
        return new ResponseEntity<>(bizClubOutputVo, HttpStatus.OK);
    }
    // 비즈니스 클럽 정보 수정 및 삭제하기
    @PutMapping("/{uuid}")
    public void updateClubUser(@RequestBody BizClubInputVo bizClubInputVo, @PathVariable String uuid){
        log.info("INPUT Object Data is : {}" , bizClubInputVo);
        BizClubDto bizClubDto = modelMapper.map(bizClubInputVo, BizClubDto.class);
        bizClubService.updateClubUser(bizClubDto, uuid);
    }
}
