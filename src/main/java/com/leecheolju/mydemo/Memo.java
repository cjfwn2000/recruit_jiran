package com.leecheolju.mydemo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.sql.Timestamp;

@Entity
public class Memo {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)  // 이 경우 오류가 난다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String writer;
    private String content;
    private Timestamp regtime;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id){
        this.id = id;
    }

    public String getWriter() {
        return writer;
    }
    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getRegtime() {
        return regtime;
    }
    public void setRegtime(Timestamp regtime) {
        this.regtime = regtime;
    }

}
