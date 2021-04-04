package go.faddy.hmrsystem.api.responses;

public class UserFetchResponseModel {
    private String name, phone, address;
    private int id;

    public UserFetchResponseModel(String name, String phone, String address, int id) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
