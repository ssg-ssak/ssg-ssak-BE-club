package ssgssak.ssgpointappclub.domain.club.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import ssgssak.ssgpointappclub.domain.club.entity.MomClub;

public interface MomClubRepository extends JpaRepository<MomClub, Long> {
    MomClub findById(long id);
}
