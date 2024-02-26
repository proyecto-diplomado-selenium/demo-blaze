package api.entities.teams;

public class Member {
    public User user;
    public InvitedBy invited_by;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public InvitedBy getInvited_by() {
        return invited_by;
    }

    public void setInvited_by(InvitedBy invited_by) {
        this.invited_by = invited_by;
    }
}
