package ssgssak.ssgpointappclub.club.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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
}
