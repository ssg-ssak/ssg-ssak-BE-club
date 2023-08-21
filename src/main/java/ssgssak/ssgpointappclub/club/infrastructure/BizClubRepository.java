package ssgssak.ssgpointappclub.club.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssgssak.ssgpointappclub.club.entity.BizClub;

@Repository
public interface BizClubRepository extends JpaRepository<BizClub, Long> {
    /**
    delete, save는 JpaRepository에서 제공되기 때문에 find만 구현.
     */
//    BizClub findById(Long id);
}
