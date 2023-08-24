package ssgssak.ssgpointappclub.domain.club.application;

public interface ClubService<Dto> {
    void createClubUser(Dto clubDto, String uuid);
    Dto getClubUser(String uuid);
    void updateClubUser(Dto clubDto, String uuid);
}
