package ssgssak.ssgpointappclub.domain.club.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssgssak.ssgpointappclub.domain.club.entity.BizClub;

import java.util.Optional;

@Repository
public interface BizClubRepository extends JpaRepository<BizClub, Long> {
    Optional<BizClub> findById(Long id);
}
