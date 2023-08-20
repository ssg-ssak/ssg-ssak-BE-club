package ssgssak.ssgpointappclub.club.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ssgssak.ssgpointappclub.club.dto.BizClubDto;
import ssgssak.ssgpointappclub.club.entity.BizClub;
import ssgssak.ssgpointappclub.club.entity.ClubList;
import ssgssak.ssgpointappclub.club.infrastructure.BizClubRepository;
import ssgssak.ssgpointappclub.club.infrastructure.ClubListRepository;

@Service
@RequiredArgsConstructor
public class BizClubServiceImpl implements ClubService<BizClubDto>{
    private final BizClubRepository bizClubRepository;
    private final ClubListRepository clubListRepository;
    /*
    유저 클럽 가입(약관 동의를 하지 않으면 가입 자체가 불가능하므로 약관 미동의 여부는 고려하지 않는다)
     */
    @Override
    public void createClubUser(BizClubDto createDto, String uuid) {
        BizClub bizClub = BizClub.builder()
                .companyName(createDto.getCompanyName())
                .companyNumber(createDto.getCompanyNumber())
                .companyLeaderName(createDto.getCompanyLeaderName())
                .companyAddress(createDto.getCompanyAddress())
                .companyEmail(createDto.getCompanyEmail())
                .agreement(createDto.getAgreement())
                .build();
        ClubList clubList = ClubList.builder()
                .uuid(uuid)
                .bizClub(bizClub)
                .build();
        bizClubRepository.save(bizClub);
        clubListRepository.save(clubList);
    }

    @Override
    public void updateClubUser(BizClubDto updateDto, String uuid) {
        ClubList clubList = clubListRepository.findByUuid(uuid);
        if(clubList == null){
            return;
        }
        else{
            /*
            ClubList의 FK인 BizClubId를 통해 bizClub을 찾는다.
             */
            BizClub bizClub = bizClubRepository.findById(
                    (clubList.getBizClub()).getId())
                    .orElseThrow(() -> new IllegalArgumentException("해당 클럽이 존재하지 않습니다."));

            /*
            dto의 동의 필드가 해제일 경우 클럽을 탈퇴한다.
             */
            if(!updateDto.getAgreement()){
                clubListRepository.delete(clubList);
                bizClubRepository.delete(bizClub);
            }
            /*
            dto의 동의 필드가 체크일 경우 클럽 정보 업데이트
             */
            else {
                bizClubRepository.save(
                        bizClub.updateClub(updateDto)
                );
                return;
            }
        }
    }

    @Override
    public BizClubDto getClubUser(String uuid) {
        ClubList clubList = clubListRepository.findByUuid(uuid);
        if(clubList == null){
            return null;
        }
        else{
            /*
            ClubList의 FK인 BizClubId를 통해 bizClub을 찾는다.
             */
            BizClub bizClub = bizClubRepository.findById(
                            (clubList.getBizClub()).getId())
                    .orElseThrow(() -> new IllegalArgumentException("해당 클럽이 존재하지 않습니다."));
            return BizClubDto.builder()
                    .companyName(bizClub.getCompanyName())
                    .companyNumber(bizClub.getCompanyNumber())
                    .companyLeaderName(bizClub.getCompanyLeaderName())
                    .companyAddress(bizClub.getCompanyAddress())
                    .companyEmail(bizClub.getCompanyEmail())
                    .agreement(bizClub.getAgreement())
                    .build();
        }
    }
}
