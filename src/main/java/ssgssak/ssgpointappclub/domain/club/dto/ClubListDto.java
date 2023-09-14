package ssgssak.ssgpointappclub.domain.club.dto;

import lombok.*;

import java.util.HashMap;
import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClubListDto {
    private List<HashMap<String, Boolean>> myClubList;
}
