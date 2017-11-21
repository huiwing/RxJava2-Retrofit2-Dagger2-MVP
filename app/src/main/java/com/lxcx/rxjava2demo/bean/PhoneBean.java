package com.lxcx.rxjava2demo.bean;

/**
 * Created by ArmyAntAndroid on 2017/11/20.
 */

public class PhoneBean {
    private String province;
    private String city;
    private String areacode;
    private String zip;
    private String company;
    private String card;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "PhoneBean{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", areacode='" + areacode + '\'' +
                ", zip='" + zip + '\'' +
                ", company='" + company + '\'' +
                ", card='" + card + '\'' +
                '}';
    }
}
