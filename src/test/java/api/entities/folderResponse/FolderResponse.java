package api.entities.folderResponse;

import java.util.ArrayList;

public class FolderResponse {
    public String id;
    public String name;
    public int orderindex;
    public boolean override_statuses;
    public boolean hidden;
    public Space space;
    public String task_count;
    public boolean archived;
    public ArrayList<Object> statuses;
    public ArrayList<Object> lists;
    public String permission_level;

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

    public int getOrderindex() {
        return orderindex;
    }

    public void setOrderindex(int orderindex) {
        this.orderindex = orderindex;
    }

    public boolean isOverride_statuses() {
        return override_statuses;
    }

    public void setOverride_statuses(boolean override_statuses) {
        this.override_statuses = override_statuses;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public Space getSpace() {
        return space;
    }

    public void setSpace(Space space) {
        this.space = space;
    }

    public String getTask_count() {
        return task_count;
    }

    public void setTask_count(String task_count) {
        this.task_count = task_count;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public ArrayList<Object> getStatuses() {
        return statuses;
    }

    public void setStatuses(ArrayList<Object> statuses) {
        this.statuses = statuses;
    }

    public ArrayList<Object> getLists() {
        return lists;
    }

    public void setLists(ArrayList<Object> lists) {
        this.lists = lists;
    }

    public String getPermission_level() {
        return permission_level;
    }

    public void setPermission_level(String permission_level) {
        this.permission_level = permission_level;
    }
}
