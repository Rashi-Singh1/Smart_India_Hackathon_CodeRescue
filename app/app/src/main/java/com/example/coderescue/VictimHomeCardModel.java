package com.example.coderescue;


public class VictimHomeCardModel {

    private String title;
     private String description;
    // private String rescueUsername;
    private  String latitude, longitude;

//    private double distance;
    // private int img;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

     public String getDescription() {
         return description;
     }

     public void setDescription(String description) {
         this.description = description;
     }

    // public String getRescueUsername() {return rescueUsername; }

    // public void setRescueUsername(String rescueUsername) { this.rescueUsername = rescueUsername; }

    public String getLatitude(){ return latitude; }

    public void setLatitude(String latitude) { this.latitude = latitude; }

    public String getLongitude(){ return longitude; }

    public void setLongitude(String longitude) { this.longitude = longitude; }
//
//    public double getDistance() { return distance;}
//
//    public void setDistance(double distance) {this.distance = distance; }

}
