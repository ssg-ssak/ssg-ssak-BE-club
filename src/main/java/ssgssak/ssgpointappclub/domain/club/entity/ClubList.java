package ssgssak.ssgpointappclub.domain.club.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClubList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "uuid")
    private String uuid;
//    //todo: reg_date 제거해야하는지 추후 체크. BaseEntity 활용법 확인하기.
//    @Column(nullable = false, name = "reg_date")
//    private LocalDate regDate;
    @ManyToOne(fetch = FetchType.LAZY)
    private BizClub bizClub;
    @ManyToOne(fetch = FetchType.LAZY)
    private MomClub momClub;
    @ManyToOne(fetch = FetchType.LAZY)
    private CarClub carClub;

    // 비즈니스 클럽 정보 수정
    public void updateBizClubInfo(BizClub bizClub){
        this.bizClub = bizClub;
    }

    // 맘키즈 클럽 정보 수정
    public void updateMomClubInfo(MomClub momClub){
        this.momClub = momClub;
    }

    public void updateCarClubInfo(CarClub carClub) {
        this.carClub = carClub;
    }
}
