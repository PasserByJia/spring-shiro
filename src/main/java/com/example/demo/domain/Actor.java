package com.example.demo.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@DynamicInsert(true)
@DynamicUpdate(true)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Actor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(nullable = false)
    protected String name;

    @Column(nullable = false)
    protected String age;

    @Column(nullable = false)
    protected String address;

    @Column(nullable = false)
    protected String no;

    @OneToOne(mappedBy = "actor")
    //@JsonDeserialize(using = UserDeserialized.class)
    protected User user;

    public Actor(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
