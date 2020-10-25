package Exceptions;

import Appliances.ElectricalAppliance;
import Appliances.Iron;
import Appliances.Keller;

import java.util.ArrayList;
import java.util.List;


public class HomeAppliancesWithExceptions {
    public static void main(String[] args) {
        HomeAppliancesWithExceptions appliancesWithExceptions = new HomeAppliancesWithExceptions();
       // appliancesWithExceptions.nullException();
       // appliancesWithExceptions.invalidWeightException();
        appliancesWithExceptions.invalidPowerException();
    }

    private void invalidPowerException() {
        Iron iron = new Iron(0, 2000);
        if (iron.power <= 0)
            try {
                throw new InvalidFormatException("Power is not be zero or negative");
            } catch (InvalidFormatException e) {
                e.printStackTrace();
            }
    }

    public void invalidWeightException() {
        Keller keller = new Keller(1000, -1);
        if (keller.weight < 0)
            try {
                throw new InvalidFormatException("Weight is not be negative value");
            } catch (InvalidFormatException e) {
                e.printStackTrace();
            }
    }

    private void nullException() {
      List <ElectricalAppliance> allAppliances = new ArrayList<>();
         if (allAppliances == null) {
             throw new TestDataException("List of appliances is empty");
         }
    }


}

