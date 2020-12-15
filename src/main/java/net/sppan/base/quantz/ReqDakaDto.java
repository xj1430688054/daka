package net.sppan.base.quantz;

import lombok.Data;

@Data
public class ReqDakaDto {
    private Integer speed ;
    private String steps  = "";
    private String errMsg  = "";
    private String provider  = "";
    private String buildingId  = "";
    private Double longitude  ;
    private Double latitude  ;
    private Integer verticalAccuracy  ;
    private String floorName = "";
    private Integer accuracy ;
    private Double altitude ;
    private Integer direction ;
    private Integer horizontalAccuracy ;
    private Integer timeLong ;

    /**构造方法  输入经度以及纬度 */
    public ReqDakaDto(Double longitude, Double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.speed =  (int) (Math.random()*(18)-1);
        this.errMsg = "getLocation:ok";
        this.provider="gps";
        this.buildingId="";
        this.verticalAccuracy=(int) (Math.random()*(18)+1);
        this.floorName="1000";
        this.accuracy = 65;
        this.direction=-1;
        this.altitude = Math.random()*(50) +20;
        this.horizontalAccuracy = 65;
        this.timeLong = 20;
    }
}
