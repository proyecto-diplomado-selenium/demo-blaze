package api.entities.spaces;

import com.fasterxml.jackson.annotation.JsonCreator;

public class CustomItems {
    public boolean enabled;

    @JsonCreator
    public CustomItems() {
    }

    public CustomItems(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
