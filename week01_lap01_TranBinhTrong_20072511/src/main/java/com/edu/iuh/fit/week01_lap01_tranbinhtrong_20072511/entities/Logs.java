package com.edu.iuh.fit.week01_lap01_tranbinhtrong_20072511.entities;

import java.util.Date;

public class Logs {
    private int id;
    private String acount_id;
    private Date login_time;
    private Date logout_time;
    private String notes;

    public Logs(int id, String acount_id, Date login_time, Date logout_time, String notes) {
        this.id = id;
        this.acount_id = acount_id;
        this.login_time = login_time;
        this.logout_time = logout_time;
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAcount_id() {
        return acount_id;
    }

    public void setAcount_id(String acount_id) {
        this.acount_id = acount_id;
    }

    public Date getLogin_time() {
        return login_time;
    }

    public void setLogin_time(Date login_time) {
        this.login_time = login_time;
    }

    public Date getLogout_time() {
        return logout_time;
    }

    public void setLogout_time(Date logout_time) {
        this.logout_time = logout_time;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Logs{" +
                "id=" + id +
                ", acount_id='" + acount_id + '\'' +
                ", login_time=" + login_time +
                ", logout_time=" + logout_time +
                ", notes='" + notes + '\'' +
                '}';
    }
}
