package ssgssak.ssgpointappclub.domain.club.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BizClubInputVo {
    private String companyName;
    private String companyNumber;
    private String companyLeaderName;
    private String companyAddress;
    private String companyEmail;
    private Boolean agreement;
}
