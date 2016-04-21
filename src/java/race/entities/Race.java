/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package race.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author Main
 */
@Entity
@Table(name = "RACE")
@NamedQueries({
    @NamedQuery(name = "Race.findAll", query = "SELECT r FROM Race r"),
    @NamedQuery(name = "Race.findById", query = "SELECT r FROM Race r WHERE r.id = :id"),
    @NamedQuery(name = "Race.findByRaceName", query = "SELECT r FROM Race r WHERE r.raceName = :raceName"),
    @NamedQuery(name = "Race.findByRaceDate", query = "SELECT r FROM Race r WHERE r.raceDate = :raceDate")})
public class Race implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 50)
    @Column(name = "RACE_NAME")
    private String raceName;
    @Column(name = "RACE_DATE")
    @Temporal(TemporalType.DATE)
    private Date raceDate;
    @ManyToMany(mappedBy = "raceList")
    private List<Racer> racerList;

    public Race() {
    }

    public Race(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public Date getRaceDate() {
        return raceDate;
    }

    public void setRaceDate(Date raceDate) {
        this.raceDate = raceDate;
    }

    public List<Racer> getRacerList() {
        return racerList;
    }

    public void setRacerList(List<Racer> racerList) {
        this.racerList = racerList;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.raceName);
        hash = 73 * hash + Objects.hashCode(this.raceDate);
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
        final Race other = (Race) obj;
        if (!Objects.equals(this.raceName, other.raceName)) {
            return false;
        }
        if (!Objects.equals(this.raceDate, other.raceDate)) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return "race.entities.Race[ id=" + id + " ]";
    }
    
}
