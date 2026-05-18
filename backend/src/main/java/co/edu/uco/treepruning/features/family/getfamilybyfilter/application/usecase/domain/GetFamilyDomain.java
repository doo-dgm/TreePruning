package co.edu.uco.treepruning.features.family.getfamilybyfilter.application.usecase.domain;

import java.util.UUID;

public final class GetFamilyDomain {
    private UUID id;
    private String commonName;
    private String scientificName;

    public GetFamilyDomain(UUID id, String commonName, String scientificName) {
        setId(id);
        setCommonName(commonName);
        setScientificName(scientificName);
    }

    public UUID getId() { return id; }
    public String getCommonName() { return commonName; }
    public String getScientificName() { return scientificName; }

    private void setId(final UUID id) { this.id = id; }
    private void setCommonName(final String commonName) { this.commonName = commonName; }
    private void setScientificName(final String scientificName) { this.scientificName = scientificName; }
}
