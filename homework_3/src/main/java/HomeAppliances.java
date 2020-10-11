import Appliances.*;

public class HomeAppliances {
    public static void main(String[] args){
        Iron iron = new Iron(2500, 3);
        iron.setTurnedOff();

        Keller keller = new Keller(1500, 2);
        keller.setTurnedOn();

        TV tv = new TV(100,16);
        tv.setTurnedOn();

        Playstation4 playstation4 = new Playstation4(165, 2);
        playstation4.setTurnedOn();

        System.out.println("Appliances in network:");
        ElectricalNetworkUtils.outputTurnedOn();
        System.out.println("\nSummary power: " + ElectricalNetworkUtils.summaryPower());

        System.out.println("\nAll appliances sorted by weight:");
        ElectricalNetworkUtils.sortByWeight();
        ElectricalNetworkUtils.outputAll();


        int power=1000;
        int weight = 12;
        System.out.println("\nAppliances with power less than " + power +
                " and weight less than " + weight + ElectricalNetworkUtils.findApplianceByCriterion(power, weight));
    }
}
