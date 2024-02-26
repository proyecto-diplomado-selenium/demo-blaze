package api.entities.spacesResponse;
public class Features {
    public DueDates due_dates;
    public Sprints sprints;
    public Points points;
    public CustomItems custom_items;
    public Tags tags;
    public TimeEstimates time_estimates;
    public Checklists checklists;
    public Zoom zoom;
    public Milestones milestones;
    public CustomFields custom_fields;
    public RemapDependencies remap_dependencies;
    public DependencyWarning dependency_warning;
    public StatusPies status_pies;
    public MultipleAssignees multiple_assignees;
    public Portfolios portfolios;
    public Emails emails;
    public TimeTracking time_tracking;

    public TimeTracking getTime_tracking() {
        return time_tracking;
    }

    public void setTime_tracking(TimeTracking time_tracking) {
        this.time_tracking = time_tracking;
    }

    public DueDates getDue_dates() {
        return due_dates;
    }

    public void setDue_dates(DueDates due_dates) {
        this.due_dates = due_dates;
    }

    public Sprints getSprints() {
        return sprints;
    }

    public void setSprints(Sprints sprints) {
        this.sprints = sprints;
    }

    public Points getPoints() {
        return points;
    }

    public void setPoints(Points points) {
        this.points = points;
    }

    public CustomItems getCustom_items() {
        return custom_items;
    }

    public void setCustom_items(CustomItems custom_items) {
        this.custom_items = custom_items;
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

    public Zoom getZoom() {
        return zoom;
    }

    public void setZoom(Zoom zoom) {
        this.zoom = zoom;
    }

    public Milestones getMilestones() {
        return milestones;
    }

    public void setMilestones(Milestones milestones) {
        this.milestones = milestones;
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

    public StatusPies getStatus_pies() {
        return status_pies;
    }

    public void setStatus_pies(StatusPies status_pies) {
        this.status_pies = status_pies;
    }

    public MultipleAssignees getMultiple_assignees() {
        return multiple_assignees;
    }

    public void setMultiple_assignees(MultipleAssignees multiple_assignees) {
        this.multiple_assignees = multiple_assignees;
    }

    public Portfolios getPortfolios() {
        return portfolios;
    }

    public void setPortfolios(Portfolios portfolios) {
        this.portfolios = portfolios;
    }

    public Emails getEmails() {
        return emails;
    }

    public void setEmails(Emails emails) {
        this.emails = emails;
    }
}
