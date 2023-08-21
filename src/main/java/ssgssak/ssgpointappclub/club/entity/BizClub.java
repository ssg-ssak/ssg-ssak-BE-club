package ssgssak.ssgpointappclub.club.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ssgssak.ssgpointappclub.club.dto.BizClubDto;
import ssgssak.ssgpointappclub.club.vo.BizClubInputVo;

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

    public BizClub updateClub(BizClubDto dto) {
        this.companyName = dto.getCompanyName();
        this.companyNumber = dto.getCompanyNumber();
        this.companyLeaderName = dto.getCompanyLeaderName();
        this.companyAddress = dto.getCompanyAddress();
        this.companyEmail = dto.getCompanyEmail();
        this.agreement = dto.getAgreement();
        return this;
    }
}
