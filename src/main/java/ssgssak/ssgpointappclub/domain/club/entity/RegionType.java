package ssgssak.ssgpointappclub.domain.club.entity;

import lombok.Getter;

@Getter
public enum RegionType {
//    SEOUL,
//    BUSAN,
//    GYEONGGI,
//    GANGWON,
//    CHUNGBUK,
//    CHUNGNAM,
//    JEONBUK,
//    JEONNAM,
//    GYEONGBUK,
//    GYEONGNAM,
//    JEJU,
//    DAEGU,
//    INCHEON,
//    GWANGJU,
//    DAEJEON;
    SEOUL("서울"),
    BUSAN("부산"),
    GYEONGGI("경기"),
    GANGWON("강원"),
    CHUNGBUK("충북"),
    CHUNGNAM("충남"),
    JEONBUK("전북"),
    JEONNAM("전남"),
    GYEONGBUK("경북"),
    GYEONGNAM("경남"),
    JEJU("제주"),
    DAEGU("대구"),
    INCHEON("인천"),
    GWANGJU("광주"),
    DAEJEON("대전");

    private final String region;

    RegionType(String region) {
        this.region = region;
    }

    public String region(){
        return region;
    }
}
