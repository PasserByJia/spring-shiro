package com.example.demo.domain;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@DynamicInsert
@DynamicUpdate
public class Student extends Actor implements Serializable {

    @Column(nullable = false)
    protected String classes;

    public Student(){
        super();
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

}
