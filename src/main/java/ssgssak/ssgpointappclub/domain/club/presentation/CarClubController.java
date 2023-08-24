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

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/club/car")
public class CarClubController {
    private final CarClubServiceImpl carClubService;
    private final ModelMapper modelMapper;

    // 차량 클럽 가입
    @PostMapping("/{uuid}")
    public void joinClub(@RequestBody CarClubInputVo carClubInputVo, @PathVariable String uuid){
        log.info("INPUT Object Data is : {}" , carClubInputVo);
        CarClubDto carClubDto = modelMapper.map(carClubInputVo, CarClubDto.class);
        carClubService.createClubUser(carClubDto, uuid);
    }

    // 차량 클럽 정보 불러오기
    @GetMapping("/{uuid}")
    public ResponseEntity<CarClubOutputVo> getClubUserInfo(@PathVariable String uuid){
        log.info("INPUT UUID is : {}" , uuid);
        CarClubDto carClubDto = carClubService.getClubUser(uuid);
        log.info("OUTPUT carClubDto is : {}" , carClubDto);
        CarClubOutputVo carClubOutputVo = modelMapper.map(carClubDto, CarClubOutputVo.class);
        log.info("OUTPUT carClubOutputVo is : {}" , carClubOutputVo);
        return new ResponseEntity<>(carClubOutputVo, HttpStatus.OK);
    }

    // 차량 클럽 정보 수정 및 삭제하기
    @PutMapping("/{uuid}")
    public void updateClubUserInfo(@RequestBody CarClubInputVo carClubInputVo, @PathVariable String uuid){
        log.info("INPUT Object Data is : {}" , carClubInputVo);
        CarClubDto carClubDto = modelMapper.map(carClubInputVo, CarClubDto.class);
        carClubService.updateClubUser(carClubDto, uuid);
    }
}
