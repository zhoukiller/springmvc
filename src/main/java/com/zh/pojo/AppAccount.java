package com.zh.pojo;

public class AppAccount {
    private Integer id;

    private String no;

    private String description;

    public AppAccount(Integer id, String no, String description) {
        this.id = id;
        this.no = no;
        this.description = description;
    }

    public AppAccount() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
