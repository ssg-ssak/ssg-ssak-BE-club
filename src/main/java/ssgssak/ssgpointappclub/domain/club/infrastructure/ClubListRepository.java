package ssgssak.ssgpointappclub.domain.club.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssgssak.ssgpointappclub.domain.club.entity.ClubList;

@Repository
public interface ClubListRepository extends JpaRepository<ClubList, Long>{
    ClubList findByUuid(String uuid);
}