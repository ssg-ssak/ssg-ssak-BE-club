package ssgssak.ssgpointappclub.domain.club.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ssgssak.ssgpointappclub.domain.club.entity.ClubList;
import ssgssak.ssgpointappclub.domain.club.infrastructure.ClubListRepository;

@Service
@RequiredArgsConstructor
public class ClubListServiceImpl implements ClubListService{
    ClubListRepository clubListRepository;
    @Override
    public void createClubList(String uuid) {
        ClubList clubList = ClubList.builder()
                .uuid(uuid)
                .build();
        clubListRepository.save(clubList);
    }
}
