package com.parrit.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class PairingHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(targetEntity = Workspace.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "workspace_id")
    private Workspace workspace;

    @ManyToOne(targetEntity = Person.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "person_one_id")
    private Person personOne;

    @ManyToOne(targetEntity = Person.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "person_two_id")
    private Person personTwo;

    private Timestamp timestamp;

    private long groupId;

    public PairingHistory() {
    }

    public PairingHistory(Workspace workspace, Person personOne, Person personTwo, Timestamp timestamp, long groupId) {
        this.workspace = workspace;
        this.personOne = personOne;
        this.personTwo = personTwo;
        this.timestamp = timestamp;
        this.groupId = groupId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Workspace getWorkspace() {
        return workspace;
    }

    public void setWorkspace(Workspace workspace) {
        this.workspace = workspace;
    }

    public Person getPersonOne() {
        return personOne;
    }

    public void setPersonOne(Person personOne) {
        this.personOne = personOne;
    }

    public Person getPersonTwo() {
        return personTwo;
    }

    public void setPersonTwo(Person personTwo) {
        this.personTwo = personTwo;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PairingHistory)) return false;

        PairingHistory that = (PairingHistory) o;

        if (getId() != that.getId()) return false;
        if (getGroupId() != that.getGroupId()) return false;
        if (getWorkspace() != null ? !getWorkspace().equals(that.getWorkspace()) : that.getWorkspace() != null)
            return false;
        if (getPersonOne() != null ? !getPersonOne().equals(that.getPersonOne()) : that.getPersonOne() != null)
            return false;
        if (getPersonTwo() != null ? !getPersonTwo().equals(that.getPersonTwo()) : that.getPersonTwo() != null)
            return false;
        return getTimestamp() != null ? getTimestamp().equals(that.getTimestamp()) : that.getTimestamp() == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (getWorkspace() != null ? getWorkspace().hashCode() : 0);
        result = 31 * result + (getPersonOne() != null ? getPersonOne().hashCode() : 0);
        result = 31 * result + (getPersonTwo() != null ? getPersonTwo().hashCode() : 0);
        result = 31 * result + (getTimestamp() != null ? getTimestamp().hashCode() : 0);
        result = 31 * result + (int) (getGroupId() ^ (getGroupId() >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "PairingHistory{" +
            "id=" + id +
            ", workspace=" + workspace +
            ", personOne=" + personOne +
            ", personTwo=" + personTwo +
            ", timestamp=" + timestamp +
            ", groupId=" + groupId +
            '}';
    }
}