package go.faddy.hmrsystem.api.responses;

public class CarFetchResponseModel {
    private String CarName, Owner;
    private int Model;

    public CarFetchResponseModel(String carName, String owner, int model) {
        CarName = carName;
        Owner = owner;
        Model = model;
    }

    public String getCarName() {
        return CarName;
    }

    public void setCarName(String carName) {
        CarName = carName;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }

    public int getModel() {
        return Model;
    }

    public void setModel(int model) {
        Model = model;
    }
}
