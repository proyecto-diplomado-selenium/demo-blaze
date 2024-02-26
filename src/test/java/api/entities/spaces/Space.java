package api.entities.spaces;

public class Space {
    public String name;
    public boolean multiple_assignees;
    public Features features;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
