package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Exercise {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ex_name", nullable = false)
    private String ex_name;

    @Column(name = "body_parts", nullable = false)
    private String bosy_parts;

    @Column(name = "reps_sets", nullable = false)
    private String reps_sets;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEx_name() {
        return ex_name;
    }

    public void setEx_name(String ex_name) {
        this.ex_name = ex_name;
    }

    public String getBosy_parts() {
        return bosy_parts;
    }

    public void setBosy_parts(String bosy_parts) {
        this.bosy_parts = bosy_parts;
    }

    public String getReps_sets() {
        return reps_sets;
    }

    public void setReps_sets(String reps_sets) {
        this.reps_sets = reps_sets;
    }




}
