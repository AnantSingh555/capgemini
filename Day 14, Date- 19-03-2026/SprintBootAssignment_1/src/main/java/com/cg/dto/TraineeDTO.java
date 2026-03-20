package com.cg.dto;

public class TraineeDTO {

    private int tId;
    private String tName;
    private String tDomain;
    private String tLocation;

    public TraineeDTO(){}

    public TraineeDTO(int tId, String tName, String tDomain, String tLocation) {
        this.tId = tId;
        this.tName = tName;
        this.tDomain = tDomain;
        this.tLocation = tLocation;
    }

    public int getTId() {
        return tId;
    }

    public void setTId(int tId) {
        this.tId = tId;
    }

    public String getTName() {
        return tName;
    }

    public void setTName(String tName) {
        this.tName = tName;
    }

    public String getTDomain() {
        return tDomain;
    }

    public void setTDomain(String tDomain) {
        this.tDomain = tDomain;
    }

    public String getTLocation() {
        return tLocation;
    }

    public void setTLocation(String tLocation) {
        this.tLocation = tLocation;
    }
}