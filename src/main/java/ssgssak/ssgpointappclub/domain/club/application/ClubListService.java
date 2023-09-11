package ssgssak.ssgpointappclub.domain.club.application;

import ssgssak.ssgpointappclub.domain.club.dto.ClubListDto;

import java.util.HashMap;
import java.util.List;

public interface ClubListService {
    void createClubList(String uuid);
    ClubListDto getMyClubList(String uuid);
}
