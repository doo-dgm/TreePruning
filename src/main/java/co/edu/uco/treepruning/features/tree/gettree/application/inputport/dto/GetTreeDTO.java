package co.edu.uco.treepruning.features.tree.gettree.application.inputport.dto;

import java.util.UUID;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;

public final class GetTreeDTO {

    private UUID id;
    private String longitude;
    private String latitude;
    private UUID family;
    private UUID sector;
    private UUID programming;

    public GetTreeDTO(UUID id, String longitude, String latitude,
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
    	return latitude; }
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
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
    }
    private void setLongitude(String longitude) {
        this.longitude = TextHelper.getDefaultWithTrim(longitude);
    }
    private void setLatitude(String latitude) {
        this.latitude = TextHelper.getDefaultWithTrim(latitude);
    }
    private void setFamily(UUID family) {
        this.family = UUIDHelper.getUUIDHelper().getDefault(family);
    }
    private void setSector(UUID sector) {
        this.sector = UUIDHelper.getUUIDHelper().getDefault(sector);
    }
    private void setProgramming(UUID programming) {
        this.programming = UUIDHelper.getUUIDHelper()
                .getDefault(programming);
    }
}
