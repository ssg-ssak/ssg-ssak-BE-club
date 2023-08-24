package ssgssak.ssgpointappclub.domain.club.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssgssak.ssgpointappclub.domain.club.entity.MomClub;

import java.util.Optional;

@Repository
public interface MomClubRepository extends JpaRepository<MomClub, Long> {
    Optional<MomClub> findById(Long id);
}
