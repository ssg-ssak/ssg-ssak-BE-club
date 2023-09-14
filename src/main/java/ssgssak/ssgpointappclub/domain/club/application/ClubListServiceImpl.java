package ssgssak.ssgpointappclub.domain.club.application;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ssgssak.ssgpointappclub.domain.club.dto.ClubListDto;
import ssgssak.ssgpointappclub.domain.club.entity.ClubList;
import ssgssak.ssgpointappclub.domain.club.infrastructure.ClubListRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClubListServiceImpl implements ClubListService{
    private final ClubListRepository clubListRepository;
    // 1. 회원가입시에 유저에게 할당된 클럽 리스트 데이터 생성
    @Override
    public void createClubList(String uuid) {
        // 이미 존재할 경우 생성하지 않음
        if(clubListRepository.findByUuid(uuid) != null) {
            throw new IllegalArgumentException("이미 존재하는 유저입니다.");
        }

        ClubList clubList = ClubList.builder()
                .uuid(uuid)
                .build();
        clubListRepository.save(clubList);
    }

    // 2. 해당 uuid의 유저가 가입한 클럽 조회
    @Override
    public ClubListDto getMyClubList(String uuid) {
        ClubList clubList = clubListRepository.findByUuid(uuid);
        ArrayList<HashMap<String, Boolean>> myClubList = new ArrayList<>();
        HashMap<String, Boolean> clubMap = new HashMap<>();
        if(clubList.getBeautyClub() != null) {
            clubMap.put("beautyClubExists", true);
        } else {
            clubMap.put("beautyClubExists", false);
        }
        if(clubList.getBizClub() != null) {
            clubMap.put("bizClubExists", true);
        } else {
            clubMap.put("bizClubExists", false);
        }
        if(clubList.getMomClub() != null) {
            clubMap.put("momClubExists", true);
        } else {
            clubMap.put("momClubExists", false);
        }
        if(clubList.getCarClub() != null) {
            clubMap.put("carClubExists", true);
        } else {
            clubMap.put("carClubExists", false);
        }
        myClubList.add(clubMap);
        return ClubListDto.builder().myClubList(myClubList).build();
    }

    @Override
    public void deleteClubList(String uuid) {
        ClubList clubList = clubListRepository.findByUuid(uuid);
        clubListRepository.delete(clubList);
    }
}
