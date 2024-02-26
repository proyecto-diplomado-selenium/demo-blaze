package api.entities.listsResponse;

import java.util.ArrayList;

public class ListResponse {

    public String id;
    public String name;
    public boolean deleted;
    public int orderindex;
    public String content;
    public Object priority;
    public Object assignee;
    public Object due_date;
    public Object start_date;
    public Folder folder;
    public Space space;
    public String inbound_address;
    public boolean archived;
    public boolean override_statuses;
    public ArrayList<Status> statuses;
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

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public int getOrderindex() {
        return orderindex;
    }

    public void setOrderindex(int orderindex) {
        this.orderindex = orderindex;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Object getPriority() {
        return priority;
    }

    public void setPriority(Object priority) {
        this.priority = priority;
    }

    public Object getAssignee() {
        return assignee;
    }

    public void setAssignee(Object assignee) {
        this.assignee = assignee;
    }

    public Object getDue_date() {
        return due_date;
    }

    public void setDue_date(Object due_date) {
        this.due_date = due_date;
    }

    public Object getStart_date() {
        return start_date;
    }

    public void setStart_date(Object start_date) {
        this.start_date = start_date;
    }

    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }

    public Space getSpace() {
        return space;
    }

    public void setSpace(Space space) {
        this.space = space;
    }

    public String getInbound_address() {
        return inbound_address;
    }

    public void setInbound_address(String inbound_address) {
        this.inbound_address = inbound_address;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public boolean isOverride_statuses() {
        return override_statuses;
    }

    public void setOverride_statuses(boolean override_statuses) {
        this.override_statuses = override_statuses;
    }

    public ArrayList<Status> getStatuses() {
        return statuses;
    }

    public void setStatuses(ArrayList<Status> statuses) {
        this.statuses = statuses;
    }

    public String getPermission_level() {
        return permission_level;
    }

    public void setPermission_level(String permission_level) {
        this.permission_level = permission_level;
    }
}
