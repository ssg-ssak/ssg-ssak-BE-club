package ssgssak.ssgpointappclub.domain.club.vo;

import lombok.Getter;
import ssgssak.ssgpointappclub.domain.club.entity.RegionType;

@Getter
public class CarClubInputVo {
    // 차량 번호판의 지역
    private RegionType region;
    private String firstNumber;
    private String middleNumber;
    private String lastNumber;
    private Boolean agreementMandatory;
    private Boolean agreementOptional;
}
