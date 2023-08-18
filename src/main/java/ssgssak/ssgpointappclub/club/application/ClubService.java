package ssgssak.ssgpointappclub.club.application;

public interface ClubService<Dto> {
    void createClubUser(Dto clubDto);
    void updateClubUser(Dto clubDto, String uuid);
    void getClubUser(Dto clubDto, String uuid);
}
