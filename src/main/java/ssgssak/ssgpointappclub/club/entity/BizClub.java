package ssgssak.ssgpointappclub.club.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BizClub {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "company_name")
    private String companyName;
    @Column(nullable = false, name = "company_number")
    private String companyNumber;
    @Column(nullable = false, name = "company_leader_name")
    private String companyLeaderName;
    @Column(nullable = false, name = "company_address")
    private String companyAddress;
    @Column(nullable = false, name = "company_email")
    private String companyEmail;
    @Column(nullable = false, name = "agreement")
    private Boolean agreement;
}
