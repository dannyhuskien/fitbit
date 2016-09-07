package com.chyld.entities;

import com.chyld.enums.ExerciseEnum;
import com.chyld.enums.ProductEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "devices")
@Data
public class Device {
    private int id;
    private int version;
    private String serial;
    private ProductEnum product;
    private ExerciseEnum category;
    private User user;
    private List<Run> runs;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Version
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Column(name="serialnumber")
    public String getSerial() {
        return serial;
    }
    public void setSerial(String serial) {
        this.serial = serial;
    }

    @Enumerated(EnumType.STRING)
    public ProductEnum getProduct() {
        return product;
    }

    public void setProduct(ProductEnum product) {
        this.product = product;
    }

    @Enumerated(EnumType.STRING)
    public ExerciseEnum getCategory() {
        return category;
    }


    public void setCategory(ExerciseEnum category) {
        this.category = category;
    }

    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonIgnore
    public User getUser() {return user;}
    public void setUser(User user) {this.user = user;}

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "device")
    public List<Run> getRuns() {
        return runs;
    }

    public void setRuns(List<Run> runs) {
        this.runs = runs;
    }



}
