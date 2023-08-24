package ssgssak.ssgpointappclub.domain.club.application;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ssgssak.ssgpointappclub.domain.club.dto.BizClubDto;
import ssgssak.ssgpointappclub.domain.club.entity.BizClub;
import ssgssak.ssgpointappclub.domain.club.entity.ClubList;
import ssgssak.ssgpointappclub.domain.club.infrastructure.BizClubRepository;
import ssgssak.ssgpointappclub.domain.club.infrastructure.ClubListRepository;

@Service
@RequiredArgsConstructor
public class BizClubServiceImpl implements ClubService<BizClubDto> {
    private final BizClubRepository bizClubRepository;
    private final ClubListRepository clubListRepository;
    private final ModelMapper modelMapper;

    // 유저 클럽 정보 생성
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
        bizClubRepository.save(bizClub);
        /*
        clubList의 BizClub필드에 생성한 bizClub 추가
         */
        ClubList clubList = clubListRepository.findByUuid(uuid);
        clubList.updateBizClubInfo(bizClub);
        clubListRepository.save(clubList);
    }
    // 유저 정보 가져오기
    @Override
    public BizClubDto getClubUser(String uuid) {
        ClubList clubList = clubListRepository.findByUuid(uuid);
        /*
        ClubList의 FK인 BizClubId를 통해 bizClub을 찾는다.
         */
        BizClub bizClub = bizClubRepository.findById(clubList.getBizClub().getId())
                .orElseThrow(() -> new IllegalArgumentException("해당 클럽이 존재하지 않습니다."));
        return modelMapper.map(bizClub, BizClubDto.class);
    }
    // 유저 정보 삭제/수정
    @Override
    public void updateClubUser(BizClubDto updateDto, String uuid) {
        ClubList clubList = clubListRepository.findByUuid(uuid);
        /*
        ClubList의 FK인 BizClubId를 통해 bizClub을 찾는다.
         */
        BizClub bizClub = bizClubRepository.findById(clubList.getBizClub().getId())
                .orElseThrow(() -> new IllegalArgumentException("해당 클럽이 존재하지 않습니다."));

        /*
        dto의 동의 필드가 해제일 경우 클럽을 탈퇴한다.
         */
        if(!updateDto.getAgreement()){
            clubList.updateBizClubInfo(null);
            clubListRepository.save(clubList);
            bizClubRepository.delete(bizClub);
        }
        /*
        dto의 동의 필드가 체크일 경우 클럽 정보 업데이트
         */
        else {
            BizClub updatedBizClub = bizClub.toBuilder()
                    .companyName(updateDto.getCompanyName())
                    .companyNumber(updateDto.getCompanyNumber())
                    .companyLeaderName(updateDto.getCompanyLeaderName())
                    .companyAddress(updateDto.getCompanyAddress())
                    .companyEmail(updateDto.getCompanyEmail())
                    .build();
            bizClubRepository.save(updatedBizClub);
        }
    }
}
