package ssgssak.ssgpointappclub.domain.club.dto;

import lombok.*;

@Builder
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BizClubDto {
    private String companyName;
    private String companyNumber;
    private String companyLeaderName;
    private String companyAddress;
    private String companyEmail;
    private Boolean agreement;
}
