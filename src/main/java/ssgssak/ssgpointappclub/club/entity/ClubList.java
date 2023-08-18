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
    @Column(nullable = false, name = "reg_date")
    private LocalDate regDate;
    @ManyToOne(fetch = FetchType.LAZY)
    private BizClub bizClub;
}
