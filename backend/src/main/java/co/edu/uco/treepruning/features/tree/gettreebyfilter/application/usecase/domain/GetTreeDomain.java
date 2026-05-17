package co.edu.uco.treepruning.features.tree.gettreebyfilter.application.usecase.domain;

import java.util.UUID;

public final class GetTreeDomain {
    private final UUID id;
    private final String longitude;
    private final String latitude;
    private final UUID family;
    private final String familyCommonName;
    private final String familyScientificName;
    private final UUID sector;
    private final String sectorName;
    private final UUID programming;

    public GetTreeDomain(UUID id, String longitude, String latitude,
            UUID family, String familyCommonName, String familyScientificName,
            UUID sector, String sectorName, UUID programming) {
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
        this.family = family;
        this.familyCommonName = familyCommonName;
        this.familyScientificName = familyScientificName;
        this.sector = sector;
        this.sectorName = sectorName;
        this.programming = programming;
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
