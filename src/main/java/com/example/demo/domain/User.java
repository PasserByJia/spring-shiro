package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@DynamicInsert
@DynamicUpdate
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(nullable = false)
    protected String username;

    @Column(nullable = false)
    protected String password;

    @Column(nullable = false)
    protected String nickname;

    @javax.persistence.ManyToMany
    protected Set<Role> role;

    @javax.persistence.OneToOne
    @JsonIgnore
    @NotFound(action=NotFoundAction.IGNORE)
    private Actor actor;

    public User(){
        super();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Actor getActor() {
        return actor;
    }
    public void setActor(Actor actor) {
        this.actor = actor;
    }
}
