package Appliances;

public class Keller extends ElectricalAppliance {
    public Keller(int power, int weight) {
        super(power, weight);
        ElectricalNetworkUtils.getAllAppliances().add(this);
    }
    @Override
    public String toString() {
        return  "Keller" + " " + getPower() + " " + getWeight();
    }
}
