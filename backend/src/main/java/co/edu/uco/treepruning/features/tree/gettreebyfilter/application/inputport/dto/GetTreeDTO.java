package co.edu.uco.treepruning.features.tree.gettreebyfilter.application.inputport.dto;

import java.util.UUID;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;

public final class GetTreeDTO {
    private UUID id;
    private String longitude;
    private String latitude;
    private UUID family;
    private String familyCommonName;
    private String familyScientificName;
    private UUID sector;
    private String sectorName;
    private UUID programming;

    public GetTreeDTO(UUID id, String longitude, String latitude,
            UUID family, String familyCommonName, String familyScientificName,
            UUID sector, String sectorName, UUID programming) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
        this.longitude = TextHelper.getDefaultWithTrim(longitude);
        this.latitude = TextHelper.getDefaultWithTrim(latitude);
        this.family = UUIDHelper.getUUIDHelper().getDefault(family);
        this.familyCommonName = TextHelper.getDefaultWithTrim(familyCommonName);
        this.familyScientificName = TextHelper.getDefaultWithTrim(familyScientificName);
        this.sector = UUIDHelper.getUUIDHelper().getDefault(sector);
        this.sectorName = TextHelper.getDefaultWithTrim(sectorName);
        this.programming = UUIDHelper.getUUIDHelper().getDefault(programming);
    }

    public UUID getId() { return id; }
    public String getLongitude() { return longitude; }
    public String getLatitude() { return latitude; }
    public UUID getFamily() { return family; }
    public String getFamilyCommonName() { return familyCommonName; }
    public String getFamilyScientificName() { return familyScientificName; }
    public UUID getSector() { return sector; }
    public String getSectorName() { return sectorName; }
    public UUID getProgramming() { return programming; }
}
