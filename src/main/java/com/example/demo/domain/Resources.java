package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@DynamicInsert
@DynamicUpdate
public class Resources implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(nullable = false)
    protected String meun_code;

    @Column(nullable = false)
    protected String meun_name;

    @Column(nullable = false)
    protected String perssion_code;

    @Column(nullable = false)
    protected String perssion_name;

    @ManyToMany(mappedBy="resources")
    @JsonIgnore
    protected Set<Role> roles;

    public Resources(){
        super();
    }

    public Long getId() {
        return id;
    }

    public String getMeun_code() {
        return meun_code;
    }

    public void setMeun_code(String meun_code) {
        this.meun_code = meun_code;
    }

    public String getMeun_name() {
        return meun_name;
    }

    public void setMeun_name(String meun_name) {
        this.meun_name = meun_name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPerssion_code() {
        return perssion_code;
    }

    public void setPerssion_code(String perssion_code) {
        this.perssion_code = perssion_code;
    }

    public String getPerssion_name() {
        return perssion_name;
    }

    public void setPerssion_name(String perssion_name) {
        this.perssion_name = perssion_name;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
