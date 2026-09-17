public class DeliveryBoys {
    private int id;
    private String dbCode;
    private String name;
    private String phoneNo;
    private String vehicleNo;
    private boolean isAvailable;

    public int getId(){return id;}

    public String getName() {
        return name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getDbCode() { return dbCode; }

    public void setDbCode(String dbCode) { this.dbCode = dbCode; }

    public void setId(int id) { this.id = id; }

    public void setName(String name) {this.name = name; }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

}

