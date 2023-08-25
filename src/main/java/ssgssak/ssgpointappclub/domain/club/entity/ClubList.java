package ssgssak.ssgpointappclub.domain.club.entity;

import jakarta.persistence.*;
import lombok.*;
import ssgssak.ssgpointappclub.global.common.entity.BaseTimeEntity;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClubList extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "uuid")
    private String uuid;
    @OneToOne(fetch = FetchType.LAZY)
    private BizClub bizClub;
    @OneToOne(fetch = FetchType.LAZY)
    private MomClub momClub;
    @OneToOne(fetch = FetchType.LAZY)
    private CarClub carClub;
    @OneToOne(fetch = FetchType.LAZY)
    private BeautyClub beautyClub;

    // 비즈니스 클럽 정보 수정
    public void updateBizClubInfo(BizClub bizClub){
        this.bizClub = bizClub;
    }

    // 맘키즈 클럽 정보 수정
    public void updateMomClubInfo(MomClub momClub){
        this.momClub = momClub;
    }

    // 차량관리 클럽 정보 수정
    public void updateCarClubInfo(CarClub carClub) {
        this.carClub = carClub;
    }

    // 뷰티 클럽 정보 수정
    public void updateBeautyClubInfo(BeautyClub beautyClub) {
        this.beautyClub = beautyClub;
    }
}
