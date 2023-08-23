package ssgssak.ssgpointappclub.domain.club.presentation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import ssgssak.ssgpointappclub.domain.club.application.CarClubServiceImpl;
import ssgssak.ssgpointappclub.domain.club.dto.CarClubDto;
import ssgssak.ssgpointappclub.domain.club.vo.CarClubInputVo;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/club/car")
public class CarClubController {
    private final CarClubServiceImpl carClubService;
    private final ModelMapper modelMapper;

    @PostMapping("/{uuid}")
    public void createClubUser(@RequestBody CarClubInputVo carClubInputVo, @PathVariable String uuid){
        log.info("INPUT Object Data is : {}" , carClubInputVo);
        CarClubDto carClubDto = modelMapper.map(carClubInputVo, CarClubDto.class);
        carClubService.createClubUser(carClubDto, uuid);
    }
}
