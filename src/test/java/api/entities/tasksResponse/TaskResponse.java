package api.entities.tasksResponse;

import java.util.ArrayList;

public class TaskResponse {
    public String id;
    public Object custom_id;
    public int custom_item_id;
    public String name;
    public String text_content;
    public String description;
    public Status status;
    public String orderindex;
    public String date_created;
    public String date_updated;
    public Object date_closed;
    public Object date_done;
    public boolean archived;
    public Creator creator;
    public ArrayList<Object> assignees;
    public ArrayList<Watcher> watchers;
    public ArrayList<Object> checklists;
    public ArrayList<Object> tags;
    public Object parent;
    public Object priority;
    public Object due_date;
    public Object start_date;
    public Object points;
    public Object time_estimate;
    public int time_spent;
    public ArrayList<Object> custom_fields;
    public ArrayList<Object> dependencies;
    public ArrayList<Object> linked_tasks;
    public ArrayList<Object> locations;
    public String team_id;
    public String url;
    public Sharing sharing;
    public String permission_level;
    public List list;
    public Project project;
    public Folder folder;
    public Space space;
    public ArrayList<Object> attachments;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getCustom_id() {
        return custom_id;
    }

    public void setCustom_id(Object custom_id) {
        this.custom_id = custom_id;
    }

    public int getCustom_item_id() {
        return custom_item_id;
    }

    public void setCustom_item_id(int custom_item_id) {
        this.custom_item_id = custom_item_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText_content() {
        return text_content;
    }

    public void setText_content(String text_content) {
        this.text_content = text_content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getOrderindex() {
        return orderindex;
    }

    public void setOrderindex(String orderindex) {
        this.orderindex = orderindex;
    }

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    public String getDate_updated() {
        return date_updated;
    }

    public void setDate_updated(String date_updated) {
        this.date_updated = date_updated;
    }

    public Object getDate_closed() {
        return date_closed;
    }

    public void setDate_closed(Object date_closed) {
        this.date_closed = date_closed;
    }

    public Object getDate_done() {
        return date_done;
    }

    public void setDate_done(Object date_done) {
        this.date_done = date_done;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public Creator getCreator() {
        return creator;
    }

    public void setCreator(Creator creator) {
        this.creator = creator;
    }

    public ArrayList<Object> getAssignees() {
        return assignees;
    }

    public void setAssignees(ArrayList<Object> assignees) {
        this.assignees = assignees;
    }

    public ArrayList<Watcher> getWatchers() {
        return watchers;
    }

    public void setWatchers(ArrayList<Watcher> watchers) {
        this.watchers = watchers;
    }

    public ArrayList<Object> getChecklists() {
        return checklists;
    }

    public void setChecklists(ArrayList<Object> checklists) {
        this.checklists = checklists;
    }

    public ArrayList<Object> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Object> tags) {
        this.tags = tags;
    }

    public Object getParent() {
        return parent;
    }

    public void setParent(Object parent) {
        this.parent = parent;
    }

    public Object getPriority() {
        return priority;
    }

    public void setPriority(Object priority) {
        this.priority = priority;
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

    public Object getPoints() {
        return points;
    }

    public void setPoints(Object points) {
        this.points = points;
    }

    public Object getTime_estimate() {
        return time_estimate;
    }

    public void setTime_estimate(Object time_estimate) {
        this.time_estimate = time_estimate;
    }

    public int getTime_spent() {
        return time_spent;
    }

    public void setTime_spent(int time_spent) {
        this.time_spent = time_spent;
    }

    public ArrayList<Object> getCustom_fields() {
        return custom_fields;
    }

    public void setCustom_fields(ArrayList<Object> custom_fields) {
        this.custom_fields = custom_fields;
    }

    public ArrayList<Object> getDependencies() {
        return dependencies;
    }

    public void setDependencies(ArrayList<Object> dependencies) {
        this.dependencies = dependencies;
    }

    public ArrayList<Object> getLinked_tasks() {
        return linked_tasks;
    }

    public void setLinked_tasks(ArrayList<Object> linked_tasks) {
        this.linked_tasks = linked_tasks;
    }

    public ArrayList<Object> getLocations() {
        return locations;
    }

    public void setLocations(ArrayList<Object> locations) {
        this.locations = locations;
    }

    public String getTeam_id() {
        return team_id;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Sharing getSharing() {
        return sharing;
    }

    public void setSharing(Sharing sharing) {
        this.sharing = sharing;
    }

    public String getPermission_level() {
        return permission_level;
    }

    public void setPermission_level(String permission_level) {
        this.permission_level = permission_level;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
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

    public ArrayList<Object> getAttachments() {
        return attachments;
    }

    public void setAttachments(ArrayList<Object> attachments) {
        this.attachments = attachments;
    }
}
