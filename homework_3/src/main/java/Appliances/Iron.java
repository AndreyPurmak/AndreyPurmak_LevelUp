package Appliances;

public class Iron extends ElectricalAppliance {
    public Iron(int power, int weight) {
        super(power, weight);
        ElectricalNetworkUtils.getAllAppliances().add(this);
    }
    @Override
    public String toString() {
        return "Iron" + " " + getPower() + " " + getWeight();
    }
}
