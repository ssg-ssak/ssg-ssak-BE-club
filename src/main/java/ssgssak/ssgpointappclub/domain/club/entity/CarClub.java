package ssgssak.ssgpointappclub.domain.club.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CarClub {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "region")
    @Enumerated(EnumType.STRING)
    private RegionType region;
    @Column(nullable = false, name = "first_number")
    private String firstNumber;
    @Column(nullable = false, name = "middle_number")
    private String middleNumber;
    @Column(nullable = false, name = "last_number")
    private String lastNumber;
    @Column(nullable = false, name = "agreement_mandatory")
    private Boolean agreementMandatory;
    @Column(nullable = false, name = "agreement_optional")
    private Boolean agreementOptional;
}
