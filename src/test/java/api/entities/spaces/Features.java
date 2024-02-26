package api.entities.spaces;

public class Features {
    public DueDates due_dates;
    public TimeTracking time_tracking;
    public Tags tags;
    public TimeEstimates time_estimates;
    public Checklists checklists;
    public CustomFields custom_fields;
    public RemapDependencies remap_dependencies;
    public DependencyWarning dependency_warning;
    public Portfolios portfolios;

    public DueDates getDue_dates() {
        return due_dates;
    }

    public void setDue_dates(DueDates due_dates) {
        this.due_dates = due_dates;
    }

    public TimeTracking getTime_tracking() {
        return time_tracking;
    }

    public void setTime_tracking(TimeTracking time_tracking) {
        this.time_tracking = time_tracking;
    }

    public Tags getTags() {
        return tags;
    }

    public void setTags(Tags tags) {
        this.tags = tags;
    }

    public TimeEstimates getTime_estimates() {
        return time_estimates;
    }

    public void setTime_estimates(TimeEstimates time_estimates) {
        this.time_estimates = time_estimates;
    }

    public Checklists getChecklists() {
        return checklists;
    }

    public void setChecklists(Checklists checklists) {
        this.checklists = checklists;
    }

    public CustomFields getCustom_fields() {
        return custom_fields;
    }

    public void setCustom_fields(CustomFields custom_fields) {
        this.custom_fields = custom_fields;
    }

    public RemapDependencies getRemap_dependencies() {
        return remap_dependencies;
    }

    public void setRemap_dependencies(RemapDependencies remap_dependencies) {
        this.remap_dependencies = remap_dependencies;
    }

    public DependencyWarning getDependency_warning() {
        return dependency_warning;
    }

    public void setDependency_warning(DependencyWarning dependency_warning) {
        this.dependency_warning = dependency_warning;
    }

    public Portfolios getPortfolios() {
        return portfolios;
    }

    public void setPortfolios(Portfolios portfolios) {
        this.portfolios = portfolios;
    }
}
