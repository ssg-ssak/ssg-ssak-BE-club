package ssgssak.ssgpointappclub.domain.club.presentation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ssgssak.ssgpointappclub.domain.club.application.CarClubServiceImpl;
import ssgssak.ssgpointappclub.domain.club.dto.CarClubDto;
import ssgssak.ssgpointappclub.domain.club.vo.CarClubInputVo;
import ssgssak.ssgpointappclub.domain.club.vo.CarClubOutputVo;

import java.security.Principal;

@RestController
@Slf4j
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/club/car")
public class CarClubController {
    private final CarClubServiceImpl carClubService;
    private final ModelMapper modelMapper;

    // 차량 클럽 가입
    @PostMapping("")
    public void joinClub(@RequestBody CarClubInputVo carClubInputVo, Principal principal){
        log.info("INPUT Object Data is : {}" , carClubInputVo);
        CarClubDto carClubDto = modelMapper.map(carClubInputVo, CarClubDto.class);
        carClubService.createClubUser(carClubDto, principal.getName());
    }

    // 차량 클럽 정보 불러오기
    @GetMapping("")
    public ResponseEntity<CarClubOutputVo> getClubUserInfo(Principal principal){
        log.info("INPUT UUID is : {}" , principal.getName());
        CarClubDto carClubDto = carClubService.getClubUser(principal.getName());
        log.info("OUTPUT carClubDto is : {}" , carClubDto);
        CarClubOutputVo carClubOutputVo = modelMapper.map(carClubDto, CarClubOutputVo.class);
        log.info("OUTPUT carClubOutputVo is : {}" , carClubOutputVo);
        return new ResponseEntity<>(carClubOutputVo, HttpStatus.OK);
    }

    // 차량 클럽 정보 수정 및 삭제하기
    @PutMapping("")
    public void updateClubUserInfo(@RequestBody CarClubInputVo carClubInputVo, Principal principal){
        log.info("INPUT Object Data is : {}" , carClubInputVo);
        CarClubDto carClubDto = modelMapper.map(carClubInputVo, CarClubDto.class);
        carClubService.updateClubUser(carClubDto, principal.getName());
    }
}
