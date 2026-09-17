public class Customer {
    private int id;
    private String username;
    private String location;
    private String phoneNo;

    public int getId(){ return id; }

    public String getUsername() {
        return username;
    }

    public String getLocation(){
        return location;
    }

    public String getPhoneNo(){
        return phoneNo;
    }

    public void setId(int id){ this.id = id; }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
