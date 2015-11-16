package com.chat.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by victor on 15.11.15.
 */
@Entity
@Table(name = "CLIENT")
public class Client {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "CLIENT_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ID")
    private Integer id;

    @Column(name = "FIRSTNAME", nullable = false)
    private String name;

    @Column(name = "SECONDNAME", nullable = false)
    private String secondName;

    @Column(name = "BIRTHDATE", nullable = false)
    private Date birthDate;

    @Column(name = "historyPath", nullable = false)
    private String path;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", birthDate=" + birthDate +
                ", path='" + path + '\'' +
                '}';
    }
}