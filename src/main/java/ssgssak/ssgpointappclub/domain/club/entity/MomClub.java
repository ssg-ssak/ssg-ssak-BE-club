package ssgssak.ssgpointappclub.domain.club.entity;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MomClub {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "child_1_gender")
    private Boolean child1Gender;
    @Column(nullable = false, name = "child_1_birth", columnDefinition = "DATE")
    private LocalDate child1Birth;
    @Column(name = "child_2_gender")
    private Boolean child2Gender;
    @Column(name = "child_2_birth", columnDefinition = "DATE")
    private LocalDate child2Birth;
    @Column(nullable = false, name = "agreement")
    private Boolean agreement;
    
    // 첫번째 자녀 정보 업데이트
    public void updateFirstChildInfo(Boolean child1Gender, LocalDate child1Birth){
        this.child1Gender = child1Gender;
        this.child1Birth = child1Birth;
    }

    // 두번째 자녀 정보 업데이트
    public void updateSecondChildInfo(Boolean child2Gender, LocalDate child2Birth){
        this.child2Gender = child2Gender;
        this.child2Birth = child2Birth;
    }

    public void updateAgreement(Boolean agreement){
        this.agreement = agreement;
    }
}
