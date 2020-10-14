package Appliances;

public class Playstation4 extends ElectricalAppliance {
    public Playstation4 (int power, int weight) {
        super(power, weight);
        ElectricalNetworkUtils.getAllAppliances().add(this);
    }
    @Override
    public String toString() {
        return "Playstation 4" + " " + getPower() + " " + getWeight() ;
    }
}
