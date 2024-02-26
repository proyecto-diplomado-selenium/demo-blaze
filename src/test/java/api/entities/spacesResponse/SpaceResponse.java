package api.entities.spacesResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class SpaceResponse {
    public String id;
    public String name;
    public Object color;
    @JsonProperty("private")
    public boolean myprivate;
    public Object avatar;
    public Object admin_can_manage;
    public ArrayList<Status> statuses;
    public boolean multiple_assignees;
    public Features features;
    public boolean archived;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getColor() {
        return color;
    }

    public void setColor(Object color) {
        this.color = color;
    }

    public boolean isMyprivate() {
        return myprivate;
    }

    public void setMyprivate(boolean myprivate) {
        this.myprivate = myprivate;
    }

    public Object getAvatar() {
        return avatar;
    }

    public void setAvatar(Object avatar) {
        this.avatar = avatar;
    }

    public Object getAdmin_can_manage() {
        return admin_can_manage;
    }

    public void setAdmin_can_manage(Object admin_can_manage) {
        this.admin_can_manage = admin_can_manage;
    }

    public ArrayList<Status> getStatuses() {
        return statuses;
    }

    public void setStatuses(ArrayList<Status> statuses) {
        this.statuses = statuses;
    }

    public boolean isMultiple_assignees() {
        return multiple_assignees;
    }

    public void setMultiple_assignees(boolean multiple_assignees) {
        this.multiple_assignees = multiple_assignees;
    }

    public Features getFeatures() {
        return features;
    }

    public void setFeatures(Features features) {
        this.features = features;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }
}
