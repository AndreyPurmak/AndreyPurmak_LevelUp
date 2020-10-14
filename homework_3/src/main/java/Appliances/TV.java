package Appliances;

public class TV extends ElectricalAppliance {
    public TV(int power, int weight) {
        super(power, weight);
        ElectricalNetworkUtils.getAllAppliances().add(this);
    }
    @Override
    public String toString() {
        return "TV" + " " + getPower() + " " + getWeight();
    }
}

