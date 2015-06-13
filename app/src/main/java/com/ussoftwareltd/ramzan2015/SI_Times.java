package com.ussoftwareltd.ramzan2015;

/**
 * Created by Bappy on 6/2/2015.
 */
public class SI_Times {
    private int id;
    private String date;
    private String day;
    private String sher;
    private String iftar;
    private String country;

    public SI_Times(int id, String date, String day, String sher, String country, String iftar) {
        this.id = id;
        this.day = day;
        this.date = date;
        this.sher = sher;
        this.country = country;
        this.iftar = iftar;
    }

    public SI_Times(String date, String day, String sher, String iftar, String country) {
        this.date = date;
        this.day = day;
        this.sher = sher;
        this.iftar = iftar;
        this.country = country;
    }

    public SI_Times(String date, String day, String sher, String iftar) {
        this.date = date;
        this.day = day;
        this.sher = sher;
        this.iftar = iftar;
    }
    public SI_Times() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIftar() {
        return iftar;
    }

    public void setIftar(String iftar) {
        this.iftar = iftar;
    }

    public String getSher() {
        return sher;
    }

    public void setSher(String sher) {
        this.sher = sher;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "SI_Times{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", day='" + day + '\'' +
                ", sher='" + sher + '\'' +
                ", iftar='" + iftar + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
