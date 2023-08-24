package ssgssak.ssgpointappclub.domain.club.application;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ssgssak.ssgpointappclub.domain.club.dto.CarClubDto;
import ssgssak.ssgpointappclub.domain.club.entity.CarClub;
import ssgssak.ssgpointappclub.domain.club.entity.ClubList;
import ssgssak.ssgpointappclub.domain.club.infrastructure.CarClubRepository;
import ssgssak.ssgpointappclub.domain.club.infrastructure.ClubListRepository;

@Service
@RequiredArgsConstructor
public class CarClubServiceImpl implements ClubService<CarClubDto>{
    private final CarClubRepository carClubRepository;
    private final ClubListRepository clubListRepository;
    private final ModelMapper modelMapper;

    // 유저 클럽 정보 생성
    @Override
    public void createClubUser(CarClubDto createDto, String uuid) {
        CarClub carClub = CarClub.builder()
                .region(createDto.getRegion())
                .firstNumber(createDto.getFirstNumber())
                .middleNumber(createDto.getMiddleNumber())
                .lastNumber(createDto.getLastNumber())
                .agreementMandatory(createDto.getAgreementMandatory())
                .agreementOptional(createDto.getAgreementOptional())
                .build();
        carClubRepository.save(carClub);

        ClubList clubList = clubListRepository.findByUuid(uuid);
        clubList.updateCarClubInfo(carClub);
        clubListRepository.save(clubList);
    }
    // 유저 클럽 정보 가져오기
    @Override
    public CarClubDto getClubUser(String uuid) {
        ClubList clubList = clubListRepository.findByUuid(uuid);
        CarClub carClub = carClubRepository.findById(clubList.getCarClub().getId())
                .orElseThrow(() -> new IllegalArgumentException("차량 클럽 정보가 없습니다."));
        return modelMapper.map(carClub, CarClubDto.class);
    }
    // 유저 클럽 정보 수정/삭제
    @Override
    public void updateClubUser(CarClubDto clubDto, String uuid) {
        ClubList clubList = clubListRepository.findByUuid(uuid);
        CarClub carClub = carClubRepository.findById(clubList.getCarClub().getId())
                .orElseThrow(() -> new IllegalArgumentException("차량 클럽 정보가 없습니다."));
        // 약관 미동의시 클럽 정보 삭제
        if(!clubDto.getAgreementMandatory()){
            clubList.updateCarClubInfo(null);
            clubListRepository.save(clubList);
            carClubRepository.delete(carClub);
        }
        else {
            CarClub updatedCarClub = carClub.toBuilder()
                    .region(clubDto.getRegion())
                    .firstNumber(clubDto.getFirstNumber())
                    .middleNumber(clubDto.getMiddleNumber())
                    .lastNumber(clubDto.getLastNumber())
                    .agreementMandatory(clubDto.getAgreementMandatory())
                    .agreementOptional(clubDto.getAgreementOptional())
                    .build();
            carClubRepository.save(updatedCarClub);
        }
    }
}
