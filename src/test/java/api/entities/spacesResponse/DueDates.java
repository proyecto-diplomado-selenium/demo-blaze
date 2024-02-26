package api.entities.spacesResponse;

public class DueDates {
    public boolean enabled;
    public boolean start_date;
    public boolean remap_due_dates;
    public boolean remap_closed_due_date;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isStart_date() {
        return start_date;
    }

    public void setStart_date(boolean start_date) {
        this.start_date = start_date;
    }

    public boolean isRemap_due_dates() {
        return remap_due_dates;
    }

    public void setRemap_due_dates(boolean remap_due_dates) {
        this.remap_due_dates = remap_due_dates;
    }

    public boolean isRemap_closed_due_date() {
        return remap_closed_due_date;
    }

    public void setRemap_closed_due_date(boolean remap_closed_due_date) {
        this.remap_closed_due_date = remap_closed_due_date;
    }
}
