package Appliances;

public class ElectricalAppliance implements Comparable<ElectricalAppliance> {
    public String ElectricalAppliance;
    public int power;
    public int weight;
    public boolean isTurnedOn;



    public ElectricalAppliance(int power, int weight) {
        this.power = power;
        this.weight = weight;
        this.isTurnedOn = false;
    }

    public void setTurnedOn() {
        this.isTurnedOn = true;
        ElectricalNetworkUtils.getAppliancesTurnedOn().add(this);
    }

    public void setTurnedOff() {
        this.isTurnedOn = false;
        ElectricalNetworkUtils.getAppliancesTurnedOn().remove(this);
    }

    public int getPower() {
        return power;
    }

    public int getWeight() {
        return weight;
    }

    public int compareTo(ElectricalAppliance o) {
        return this.getWeight() - o.getWeight();
    }

    @Override
    public String toString() {
        return  ElectricalAppliance + " " + power + " " + weight;
    }
}
