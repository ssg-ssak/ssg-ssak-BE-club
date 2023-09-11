package ssgssak.ssgpointappclub.domain.club.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class BeautyClub {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
