package com.example.criminal_evidence_management_system_sprint1.core;


import java.util.Set;


public class Storage {
    private Integer storageId;
    private String name;
    private String location;
    private Set<Evidence> evidenceSet;

    public Storage(Integer storageId, String name, String location, Set<Evidence> evidenceSet) {
        this.storageId = storageId;
        this.name = name;
        this.location = location;
        this.evidenceSet = evidenceSet;
    }

    public Integer getStorageId() {
        return storageId;
    }

    public void setStorageId(Integer storageId) {
        this.storageId = storageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Set<Evidence> getEvidenceSet() {
        return evidenceSet;
    }

    public void setEvidenceSet(Set<Evidence> evidenceSet) {
        this.evidenceSet = evidenceSet;
    }

    public Storage() {
    }
}
