package ssgssak.ssgpointappclub.domain.club.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssgssak.ssgpointappclub.domain.club.entity.CarClub;

import java.util.Optional;

@Repository
public interface CarClubRepository extends JpaRepository<CarClub, Long> {
    Optional<CarClub> findById(Long id);
}
