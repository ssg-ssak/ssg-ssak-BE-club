package ssgssak.ssgpointappclub.domain.club.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder(toBuilder = true)
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

    public void updateCompanyName(String companyName){
        this.companyName = companyName;
    }
    public void updateCompanyNumber(String companyNumber){
        this.companyNumber = companyNumber;
    }
    public void updateCompanyLeaderName(String CompanyLeaderName){
        this.companyLeaderName = companyLeaderName;
    }
    public void updateCompanyAddress(String companyAddress){
        this.companyAddress = companyAddress;
    }
    public void updateCompanyEmail(String companyEmail){
        this.companyEmail = companyEmail;
    }
    public void updateAgreement(Boolean agreement){
        this.agreement = agreement;
    }
}
