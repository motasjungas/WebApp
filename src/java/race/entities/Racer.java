/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package race.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Main
 */
@Entity
@Table(name = "RACER")
@NamedQueries({
    @NamedQuery(name = "Racer.findAll", query = "SELECT r FROM Racer r"),
    @NamedQuery(name = "Racer.findById", query = "SELECT r FROM Racer r WHERE r.id = :id"),
    @NamedQuery(name = "Racer.findByFirstName", query = "SELECT r FROM Racer r WHERE r.firstName = :firstName"),
    @NamedQuery(name = "Racer.findByLastName", query = "SELECT r FROM Racer r WHERE r.lastName = :lastName")})
public class Racer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 20)
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Size(max = 20)
    @Column(name = "LAST_NAME")
    private String lastName;
    @JoinTable(name = "RACER_RACE", joinColumns = {
        @JoinColumn(name = "RACER_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "RACE_ID", referencedColumnName = "ID")})
    @ManyToMany
    private List<Race> raceList;
    @JoinColumn(name = "TEAM_ID", referencedColumnName = "ID")
    @ManyToOne
    private Team teamId;

    public Racer() {
    }

    public Racer(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Race> getRaceList() {
        return raceList;
    }

    public void setRaceList(List<Race> raceList) {
        this.raceList = raceList;
    }

    public Team getTeamId() {
        return teamId;
    }

    public void setTeamId(Team teamId) {
        this.teamId = teamId;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.firstName);
        hash = 73 * hash + Objects.hashCode(this.lastName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Racer other = (Racer) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return "race.entities.Racer[ id=" + id + " ]";
    }
    
}
