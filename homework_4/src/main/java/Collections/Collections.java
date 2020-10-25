package Collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Collections {
    public static void main(String[] args) {
        Collections collections = new Collections();
        collections.runCollections();
    }

    private void runCollections() {
        ArrayList<Integer> generateNumbers = new ArrayList<>();
        for (int i = 1; i <= 100000; i++)
            generateNumbers.add(i);
        makeRandomOrder(generateNumbers);
        validateUnique(generateNumbers);
        findDivider(generateNumbers);
    }

    private ArrayList<Integer> makeRandomOrder(ArrayList<Integer> integerArrayList) {
        Set <Integer> randomOrder = addNumbers(integerArrayList);
        return new ArrayList<>(randomOrder);
    }

    private Set<Integer> addNumbers(ArrayList<Integer> integerArrayList) {
        Set <Integer> randomOrder = new HashSet<>();
        randomOrder.addAll(integerArrayList);
        return randomOrder;
    }

    private void validateUnique(ArrayList<Integer> integerArrayList){
        Set <Integer> randomOrder = addNumbers(integerArrayList);
        if (randomOrder.size() == integerArrayList.size())
            System.out.println("Коллекция уникальна");
        else
            System.out.println("Коллекция не уникальна");
    }

    private void findDivider(ArrayList<Integer> list){
        List<Integer> divider2 = new ArrayList<>();
        List<Integer> divider3 = new ArrayList<>();
        List<Integer> divider5 = new ArrayList<>();
        List<Integer> divider7 = new ArrayList<>();

        for (Integer i : list){
            if (i % 2 == 0){
                divider2.add(i);
            }
            else
            if (i % 3 == 0){
                divider3.add(i);
            }
            else
            if (i % 5 == 0){
                divider5.add(i);
            }
            else
            if (i % 7 == 0){
                divider7.add(i);
            }
        }

        System.out.println("Делятся на 2: " + divider2);
        System.out.println("Делятся на 3: " + divider3);
        System.out.println("Делятся на 5: " + divider5);
        System.out.println("Делятся на 7: " + divider7);
    }
}
