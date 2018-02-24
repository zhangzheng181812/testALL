package com.demo.entity;

import javax.persistence.*;

/**
 * Created by admin on 2017/7/6.
 */
@Entity
@Table(name = "code")
public class Log {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String code;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
