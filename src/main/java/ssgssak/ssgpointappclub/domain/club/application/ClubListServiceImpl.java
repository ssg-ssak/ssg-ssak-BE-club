package ssgssak.ssgpointappclub.domain.club.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ssgssak.ssgpointappclub.domain.club.entity.ClubList;
import ssgssak.ssgpointappclub.domain.club.infrastructure.ClubListRepository;

@Service
@RequiredArgsConstructor
public class ClubListServiceImpl implements ClubListService{
    private final ClubListRepository clubListRepository;
    // 회원가입시에 유저에게 할당된 클럽 리스트 데이터 생성
    @Override
    public void createClubList(String uuid) {
        ClubList clubList = ClubList.builder()
                .uuid(uuid)
                .build();
        clubListRepository.save(clubList);
    }
}
