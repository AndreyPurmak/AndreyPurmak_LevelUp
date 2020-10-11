package Appliances;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ElectricalNetworkUtils {
    public static List<ElectricalAppliance> appliancesTurnedOn = new ArrayList<>();
    public static List <ElectricalAppliance> allAppliances = new ArrayList<>();


    public static List <ElectricalAppliance> getAllAppliances(){
        return allAppliances;
    }

    public static List <ElectricalAppliance> getAppliancesTurnedOn(){
        return appliancesTurnedOn;
    }
    public static void outputTurnedOn(){
        for (ElectricalAppliance electricalAppliance : appliancesTurnedOn) {
            System.out.println(electricalAppliance);
        }
    }

    public static void outputAll(){
        for (ElectricalAppliance appliancesSortByWeight : allAppliances) {
            System.out.println(appliancesSortByWeight);
        }
    }
    public static void sortByWeight(){
        Collections.sort(allAppliances);
    }
    public static List <ElectricalAppliance> findApplianceByCriterion (int power, int weight){
        List <ElectricalAppliance> result = new ArrayList<>();
        for (ElectricalAppliance appliance : allAppliances){
            if (appliance.getPower() < power && appliance.getWeight() < weight)
                result.add(appliance);
        }
        return result;
    }
    public static int summaryPower(){
        int res=0;
        for (ElectricalAppliance electricalAppliance : appliancesTurnedOn) {
            res += electricalAppliance.getPower();
        }
        return res;
    }
}
