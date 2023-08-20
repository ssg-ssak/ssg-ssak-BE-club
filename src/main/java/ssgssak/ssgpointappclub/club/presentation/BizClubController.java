package ssgssak.ssgpointappclub.club.presentation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ssgssak.ssgpointappclub.club.application.BizClubServiceImpl;
import ssgssak.ssgpointappclub.club.dto.BizClubDto;
import ssgssak.ssgpointappclub.club.vo.BizClubInputVo;
import ssgssak.ssgpointappclub.club.vo.BizClubOutputVo;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1")
public class BizClubController {
    private final BizClubServiceImpl bizClubService;
    @GetMapping("/club/biz/{uuid}")
    public ResponseEntity<BizClubOutputVo> getClubUser(@PathVariable String uuid){
        log.info("INPUT uuid is : {}" , uuid);
        BizClubDto bizClubDto = bizClubService.getClubUser(uuid);
        log.info("OUTPUT bizClubDto is : {}" , bizClubDto);
        BizClubOutputVo bizClubOutputVo = BizClubOutputVo.builder()
                .companyName(bizClubDto.getCompanyName())
                .companyNumber(bizClubDto.getCompanyNumber())
                .companyLeaderName(bizClubDto.getCompanyLeaderName())
                .companyAddress(bizClubDto.getCompanyAddress())
                .companyEmail(bizClubDto.getCompanyEmail())
                .agreement(bizClubDto.getAgreement())
                .build();
        log.info("OUTPUT bizClubOutputVo is : {}" , bizClubOutputVo);
//        return ResponseEntity.ok(bizClubOutputVo);
        return new ResponseEntity<>(bizClubOutputVo, HttpStatus.OK);
    }

    @PostMapping("/club/biz/{uuid}")
    public void createClubUser(@RequestBody BizClubInputVo bizClubInputVo, @PathVariable String uuid){
        log.info("INPUT Object Data is : {}" , bizClubInputVo);
        BizClubDto bizClubDto = BizClubDto.builder()
                .companyName(bizClubInputVo.getCompanyName())
                .companyNumber(bizClubInputVo.getCompanyNumber())
                .companyLeaderName(bizClubInputVo.getCompanyLeaderName())
                .companyAddress(bizClubInputVo.getCompanyAddress())
                .companyEmail(bizClubInputVo.getCompanyEmail())
                .agreement(bizClubInputVo.getAgreement())
                .build();

        bizClubService.createClubUser(bizClubDto, uuid);
    }

    @PutMapping("/club/biz/{uuid}")
    public void updateClubUser(@RequestBody BizClubInputVo bizClubInputVo, @PathVariable String uuid){
        log.info("INPUT Object Data is : {}" , bizClubInputVo);
        BizClubDto bizClubDto = BizClubDto.builder()
                .companyName(bizClubInputVo.getCompanyName())
                .companyNumber(bizClubInputVo.getCompanyNumber())
                .companyLeaderName(bizClubInputVo.getCompanyLeaderName())
                .companyAddress(bizClubInputVo.getCompanyAddress())
                .companyEmail(bizClubInputVo.getCompanyEmail())
                .agreement(bizClubInputVo.getAgreement())
                .build();

        bizClubService.updateClubUser(bizClubDto, uuid);
    }

}
