package ssgssak.ssgpointappclub.domain.club.vo;

import lombok.*;
import ssgssak.ssgpointappclub.domain.club.entity.BeautyClub;
import ssgssak.ssgpointappclub.domain.club.entity.BizClub;
import ssgssak.ssgpointappclub.domain.club.entity.CarClub;
import ssgssak.ssgpointappclub.domain.club.entity.MomClub;

import java.util.HashMap;
import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClubListOutputVo {
    private List<HashMap<String, Boolean>> myClubList;
}
