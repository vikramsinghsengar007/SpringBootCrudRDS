package com.springboot.crud.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer eid;
    @Column
    public String ename;
    @Column
    public String email;
    @Column
    public String comments;
    @Column
    public Date doj;
}
