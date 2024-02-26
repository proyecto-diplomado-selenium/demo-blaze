package api.entities.tasksResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Sharing {
    @JsonProperty("public")
    public boolean mypublic;
    public Object public_share_expires_on;
    public ArrayList<String> public_fields;
    public Object token;
    public boolean seo_optimized;

    public boolean isMypublic() {
        return mypublic;
    }

    public void setMypublic(boolean mypublic) {
        this.mypublic = mypublic;
    }

    public Object getPublic_share_expires_on() {
        return public_share_expires_on;
    }

    public void setPublic_share_expires_on(Object public_share_expires_on) {
        this.public_share_expires_on = public_share_expires_on;
    }

    public ArrayList<String> getPublic_fields() {
        return public_fields;
    }

    public void setPublic_fields(ArrayList<String> public_fields) {
        this.public_fields = public_fields;
    }

    public Object getToken() {
        return token;
    }

    public void setToken(Object token) {
        this.token = token;
    }

    public boolean isSeo_optimized() {
        return seo_optimized;
    }

    public void setSeo_optimized(boolean seo_optimized) {
        this.seo_optimized = seo_optimized;
    }
}
