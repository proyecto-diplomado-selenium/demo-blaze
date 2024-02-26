package api.entities.spaces;

public class TimeTracking {
    public boolean enabled;

    public TimeTracking(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
