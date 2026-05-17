package co.edu.uco.treepruning.features.tree.gettree.application.usecase.domain;

import java.util.UUID;

public final class GetTreeDomain {

    private UUID id;
    private String longitude;
    private String latitude;
    private UUID family;
    private UUID sector;
    private UUID programming;

    public GetTreeDomain(UUID id, String longitude, String latitude,
            UUID family, UUID sector, UUID programming) {
        setId(id);
        setLongitude(longitude);
        setLatitude(latitude);
        setFamily(family);
        setSector(sector);
        setProgramming(programming);
    }

    public UUID getId() { 
    	return id;
    	}
    public String getLongitude() {
    	return longitude; 
    	}
    public String getLatitude() {
    	return latitude;
    	}
    public UUID getFamily() {
    	return family; 
    	}
    public UUID getSector() {
    	return sector; 
    	}
    public UUID getProgramming() {
    	return programming;
    	}

    private void setId(UUID id) {
    	this.id = id; 
    	}
    private void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    private void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    private void setFamily(UUID family) { 
    	this.family = family; 
    	}
    private void setSector(UUID sector) {
    	this.sector = sector;
    	}
    private void setProgramming(UUID programming) {
        this.programming = programming;
    }
}
