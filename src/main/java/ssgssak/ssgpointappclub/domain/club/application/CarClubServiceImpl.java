package ssgssak.ssgpointappclub.domain.club.application;

import lombok.RequiredArgsConstructor;
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

    /*
    유저 클럽 가입
     */
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

    @Override
    public void updateClubUser(CarClubDto clubDto, String uuid) {

    }

    @Override
    public CarClubDto getClubUser(String uuid) {
        return null;
    }
}
