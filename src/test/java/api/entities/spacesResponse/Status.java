package api.entities.spacesResponse;

//import com.fasterxml.jackson.annotation.JsonCreator;

public class Status {
    public String id;
    public String status;
    public String type;
    public int orderindex;
    public String color;

//    @JsonCreator
//    public Status() {
//    }
//
//    public Status(String id, String status, String type, int orderindex, String color) {
//        this.id = id;
//        this.status = status;
//        this.type = type;
//        this.orderindex = orderindex;
//        this.color = color;
//    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getOrderindex() {
        return orderindex;
    }

    public void setOrderindex(int orderindex) {
        this.orderindex = orderindex;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
