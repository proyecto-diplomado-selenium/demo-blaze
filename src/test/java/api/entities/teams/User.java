package api.entities.teams;

public class User {
    public int id;
    public String username;
    public String email;
    public String color;
    public Object profilePicture;
    public String initials;
    public int role;
    public Object custom_role;
    public String last_active;
    public String date_joined;
    public String date_invited;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Object getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(Object profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public Object getCustom_role() {
        return custom_role;
    }

    public void setCustom_role(Object custom_role) {
        this.custom_role = custom_role;
    }

    public String getLast_active() {
        return last_active;
    }

    public void setLast_active(String last_active) {
        this.last_active = last_active;
    }

    public String getDate_joined() {
        return date_joined;
    }

    public void setDate_joined(String date_joined) {
        this.date_joined = date_joined;
    }

    public String getDate_invited() {
        return date_invited;
    }

    public void setDate_invited(String date_invited) {
        this.date_invited = date_invited;
    }
}
