package ssgssak.ssgpointappclub.domain.club.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ssgssak.ssgpointappclub.domain.club.entity.BeautyClub;
import ssgssak.ssgpointappclub.domain.club.entity.ClubList;
import ssgssak.ssgpointappclub.domain.club.infrastructure.BeautyClubRepository;
import ssgssak.ssgpointappclub.domain.club.infrastructure.ClubListRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BeautyClubService {
    private final ClubListRepository clubListRepository;
    private final BeautyClubRepository beautyClubRepository;

    // 유저 클럽 가입
    public void createClubUser(String uuid) {
        BeautyClub beautyClub = new BeautyClub();
        beautyClubRepository.save(beautyClub);
        ClubList clubList = clubListRepository.findByUuid(uuid);
        clubList.updateBeautyClubInfo(beautyClub);
        clubListRepository.save(clubList);
    }
    
    // 유저 클럽 가입 여부 확인
    public Boolean isBeautyClubUser(String uuid) {
        ClubList clubList = clubListRepository.findByUuid(uuid);
        try {
            beautyClubRepository.findById(clubList.getBeautyClub().getId());
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    // 유저 클럽 정보 삭제
    public void deleteClubUser(String uuid) {
        ClubList clubList = clubListRepository.findByUuid(uuid);
        BeautyClub beautyClub = beautyClubRepository.findById(clubList.getBeautyClub().getId())
                .orElseThrow(() -> new IllegalArgumentException("해당 클럽이 존재하지 않습니다."));
        clubList.updateBeautyClubInfo(null);
        clubListRepository.save(clubList);
        beautyClubRepository.delete(beautyClub);
    }
}
