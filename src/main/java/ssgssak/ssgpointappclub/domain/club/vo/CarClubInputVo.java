package ssgssak.ssgpointappclub.domain.club.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ssgssak.ssgpointappclub.domain.club.entity.RegionType;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarClubInputVo {
    // 차량 번호판의 지역
    private RegionType region;
    private String firstNumber;
    private String middleNumber;
    private String lastNumber;
    private Boolean agreementMandatory;
    private Boolean agreementOptional;
}
