package ssgssak.ssgpointappclub.domain.club.dto;

import lombok.*;
import ssgssak.ssgpointappclub.domain.club.entity.RegionType;

@Builder
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CarClubDto {
    // 차량 번호판의 지역
    private RegionType region;
    private String firstNumber;
    private String middleNumber;
    private String lastNumber;
    private Boolean agreementMandatory;
    private Boolean agreementOptional;
}
