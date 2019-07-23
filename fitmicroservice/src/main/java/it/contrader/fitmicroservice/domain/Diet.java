package it.contrader.fitmicroservice.domain;


import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Diet.
 */
@Entity
@Table(name = "diet")
public class Diet implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "monday")
    private String monday;

    @Column(name = "tuesday")
    private String tuesday;

    @Column(name = "wednesday")
    private String wednesday;

    @Column(name = "thursday")
    private String thursday;

    @Column(name = "friday")
    private String friday;

    @Column(name = "saturday")
    private String saturday;

    @Column(name = "sunday")
    private String sunday;

    @Column(name = "id_player")
    private Integer idPlayer;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMonday() {
        return monday;
    }

    public Diet monday(String monday) {
        this.monday = monday;
        return this;
    }

    public void setMonday(String monday) {
        this.monday = monday;
    }

    public String getTuesday() {
        return tuesday;
    }

    public Diet tuesday(String tuesday) {
        this.tuesday = tuesday;
        return this;
    }

    public void setTuesday(String tuesday) {
        this.tuesday = tuesday;
    }

    public String getWednesday() {
        return wednesday;
    }

    public Diet wednesday(String wednesday) {
        this.wednesday = wednesday;
        return this;
    }

    public void setWednesday(String wednesday) {
        this.wednesday = wednesday;
    }

    public String getThursday() {
        return thursday;
    }

    public Diet thursday(String thursday) {
        this.thursday = thursday;
        return this;
    }

    public void setThursday(String thursday) {
        this.thursday = thursday;
    }

    public String getFriday() {
        return friday;
    }

    public Diet friday(String friday) {
        this.friday = friday;
        return this;
    }

    public void setFriday(String friday) {
        this.friday = friday;
    }

    public String getSaturday() {
        return saturday;
    }

    public Diet saturday(String saturday) {
        this.saturday = saturday;
        return this;
    }

    public void setSaturday(String saturday) {
        this.saturday = saturday;
    }

    public String getSunday() {
        return sunday;
    }

    public Diet sunday(String sunday) {
        this.sunday = sunday;
        return this;
    }

    public void setSunday(String sunday) {
        this.sunday = sunday;
    }

    public Integer getIdPlayer() {
        return idPlayer;
    }

    public Diet idPlayer(Integer idPlayer) {
        this.idPlayer = idPlayer;
        return this;
    }

    public void setIdPlayer(Integer idPlayer) {
        this.idPlayer = idPlayer;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Diet diet = (Diet) o;
        if (diet.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), diet.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Diet{" +
            "id=" + getId() +
            ", monday='" + getMonday() + "'" +
            ", tuesday='" + getTuesday() + "'" +
            ", wednesday='" + getWednesday() + "'" +
            ", thursday='" + getThursday() + "'" +
            ", friday='" + getFriday() + "'" +
            ", saturday='" + getSaturday() + "'" +
            ", sunday='" + getSunday() + "'" +
            ", idPlayer=" + getIdPlayer() +
            "}";
    }
}
