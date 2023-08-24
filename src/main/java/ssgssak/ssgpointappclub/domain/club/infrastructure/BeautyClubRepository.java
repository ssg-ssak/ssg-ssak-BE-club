package ssgssak.ssgpointappclub.domain.club.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssgssak.ssgpointappclub.domain.club.entity.BeautyClub;

import java.util.Optional;

@Repository
public interface BeautyClubRepository extends JpaRepository<BeautyClub, Long> {
    Optional<BeautyClub> findById(Long id);
}
