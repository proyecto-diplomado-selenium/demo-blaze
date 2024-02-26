package api.entities.spacesResponse;

public class TimeEstimates {
    public boolean enabled;
    public boolean rollup;
    public boolean per_assignee;

//    public TimeEstimates(boolean enabled, boolean rollup, boolean per_assignee) {
//        this.enabled = enabled;
//        this.rollup = rollup;
//        this.per_assignee = per_assignee;
//    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isRollup() {
        return rollup;
    }

    public void setRollup(boolean rollup) {
        this.rollup = rollup;
    }

    public boolean isPer_assignee() {
        return per_assignee;
    }

    public void setPer_assignee(boolean per_assignee) {
        this.per_assignee = per_assignee;
    }
}
