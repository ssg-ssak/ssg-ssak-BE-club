package ssgssak.ssgpointappclub.domain.club.vo;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MomClubOutputVo {
    private Boolean child1Gender;
    private String child1Birth;
    private Boolean child2Gender;
    private String child2Birth;
    private Boolean agreement;
}
