package ssgssak.ssgpointappclub.domain.club.dto;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MomClubDto {
    private Boolean child1Gender;
    private String child1Birth;
    private Boolean child2Gender;
    private String child2Birth;
    private Boolean agreement;
}
