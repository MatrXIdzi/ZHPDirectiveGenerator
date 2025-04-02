package pl.idzi.app.model.user;

import jakarta.persistence.Embeddable;

@Embeddable
public class Unit {
    //chorągiew
    private String region;

    //hufiec
    private String district;

    //szczep
    private String group;

    //druzyna
    private String troop;

    public Unit(String region, String district, String group, String troop) {
        this.region = region;
        this.district = district;
        this.group = group;
        this.troop = troop;
    }

    public Unit() {

    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getTroop() {
        return troop;
    }

    public void setTroop(String troop) {
        this.troop = troop;
    }
}
