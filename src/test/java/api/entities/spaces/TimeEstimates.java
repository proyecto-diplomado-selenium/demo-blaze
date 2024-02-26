package api.entities.spaces;

public class TimeEstimates {

    public TimeEstimates(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean enabled;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
