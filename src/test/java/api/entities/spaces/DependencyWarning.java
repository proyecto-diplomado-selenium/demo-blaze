package api.entities.spaces;

import com.fasterxml.jackson.annotation.JsonCreator;

public class DependencyWarning {

    @JsonCreator
    public DependencyWarning() {
    }


    public DependencyWarning(boolean enabled) {
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
