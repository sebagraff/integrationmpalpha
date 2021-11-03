package com.tiendaecommerce.tienda.models;

import com.fasterxml.jackson.databind.node.ObjectNode;

import javax.persistence.*;

@Entity
public class WebHook {
    @Id
    private long id;
    private boolean live_mode;
    private String type;
    private String date_created;
    private int application_id;
    private int user_id;
    private int version;
    private String api_version;
    private String action;
    private ObjectNode data;

    public WebHook() {
    }

    public WebHook(long id, boolean live_mode, String type, String date_created, int application_id, int user_id, int version, String api_version, String action, ObjectNode data) {
        this.id = id;
        this.live_mode = live_mode;
        this.type = type;
        this.date_created = date_created;
        this.application_id = application_id;
        this.user_id = user_id;
        this.version = version;
        this.api_version = api_version;
        this.action = action;
        this.data = data;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isLive_mode() {
        return live_mode;
    }

    public void setLive_mode(boolean live_mode) {
        this.live_mode = live_mode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    public int getApplication_id() {
        return application_id;
    }

    public void setApplication_id(int application_id) {
        this.application_id = application_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getApi_version() {
        return api_version;
    }

    public void setApi_version(String api_version) {
        this.api_version = api_version;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public ObjectNode getData() {
        return data;
    }

    public void setData(ObjectNode data) {
        this.data = data;
    }
}
