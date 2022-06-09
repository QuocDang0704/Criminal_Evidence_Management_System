package com.example.criminal_evidence_management_system_sprint1.core;

import com.example.criminal_evidence_management_system_sprint1.common.CaseStatus;
import com.example.criminal_evidence_management_system_sprint1.common.Rank;

import java.util.Set;


public class Detective {
    private Integer detectiveId;
    private Person person;
    private String badgeNumber;
    private Rank rank;
    private Boolean armed;
    private CaseStatus status;
    private Set<TrackEntry> trackEntries;

    public Detective() {
    }

    public Detective(Integer detectiveId, Person person, String badgeNumber, Rank rank, Boolean armed, CaseStatus status, Set<TrackEntry> trackEntries) {
        this.detectiveId = detectiveId;
        this.person = person;
        this.badgeNumber = badgeNumber;
        this.rank = rank;
        this.armed = armed;
        this.status = status;
        this.trackEntries = trackEntries;
    }

    public Integer getDetectiveId() {
        return detectiveId;
    }

    public void setDetectiveId(Integer detectiveId) {
        this.detectiveId = detectiveId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getBadgeNumber() {
        return badgeNumber;
    }

    public void setBadgeNumber(String badgeNumber) {
        this.badgeNumber = badgeNumber;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Boolean getArmed() {
        return armed;
    }

    public void setArmed(Boolean armed) {
        this.armed = armed;
    }

    public CaseStatus getStatus() {
        return status;
    }

    public void setStatus(CaseStatus status) {
        this.status = status;
    }

    public Set<TrackEntry> getTrackEntries() {
        return trackEntries;
    }

    public void setTrackEntries(Set<TrackEntry> trackEntries) {
        this.trackEntries = trackEntries;
    }
}
