package br.edu.uricer.projeto.integrador;

import br.edu.uricer.projeto.integrador.algorithms.KnapsackAlgorithm;
import br.edu.uricer.projeto.integrador.domains.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KnapsackAlgorithmTest {
    public static void main(String[] args) {
        KnapsackAlgorithmTest test = new KnapsackAlgorithmTest();
        test.testKnapsackDynamicProgramming();
        //test.testKnapsackDynamicProgrammingWithDesiredItem();
    }
    public void testKnapsackDynamicProgramming() {
        System.out.println("DIGITE SEU VALOR");
        List<Item> itemList = createItemList();

        int[] weights = getWeights(itemList);
        int[] values = getValues(itemList);

        Scanner sc = new Scanner(System.in);
        int targetValue = sc.nextInt();

        System.out.println("eu tenho um valor de U$"+targetValue);
        KnapsackAlgorithm knapsackAlgorithm = new KnapsackAlgorithm();
        List<Item> selectedItems = knapsackAlgorithm.knapsackDynamicProgramming(weights, values, itemList.size(), targetValue, itemList);
        List<Item> unselectedItems = getUnselectedItems(itemList, selectedItems);

        System.out.println("Itens selecionados:");
        for (Item item : selectedItems) {
            System.out.println("(" + item.getName() + ", U$" + item.getValue() + ")");
        }

        System.out.println("Itens não selecionados:");
        for (Item item : unselectedItems) {
            System.out.println("(" + item.getName() + ", U$" + item.getValue() + ")");
        }
        System.out.println("\nFINAL DO ITEM NORMAL");
    }
   public void testKnapsackDynamicProgrammingWithDesiredItem() {
        List<Item> itemList = createItemList();

        int[] weights = getWeights(itemList);
        int[] values = getValues(itemList);

        int targetValue = 200;
            int posicaoItemDesejado = 1;
        System.out.println("Eu tenho um valor de U$"+targetValue);
            KnapsackAlgorithm knapsackAlgorithm = new KnapsackAlgorithm();
            List<Item> selectedItems = knapsackAlgorithm.knapsackDynamicProgrammingWithDesiredItem(weights, values, itemList.size(), targetValue,posicaoItemDesejado, itemList);
            List<Item> unselectedItems = getUnselectedItems(itemList, selectedItems);

            System.out.println("Itens selecionados:");
            for (Item item : selectedItems) {
                System.out.println("(" + item.getName() + ", U$" + item.getValue() + ")");
            }

            System.out.println("Itens não selecionados:");
            for (Item item : unselectedItems) {
                System.out.println("(" + item.getName() + ", U$" + item.getValue() + ")");
            }
        System.out.println("FINAL DO ITEM ESCOLHIDO");
    }
    private static int[] getValues(List<Item> itemList) {
        int[] values = new int[itemList.size()];
        for (int i = 0; i < itemList.size(); i++) {
            values[i] = itemList.get(i).getValue();
        }
        return values;
    }
    private static int[] getWeights(List<Item> itemList) {
        int[] weights = new int[itemList.size()];
        for (int i = 0; i < itemList.size(); i++) {
            weights[i] = itemList.get(i).getWeight();
        }
        return weights;
    }
    private static List<Item> createItemList() {
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item(10, 60, "Item1"));
        itemList.add(new Item(20, 100, "Item2"));
        itemList.add(new Item(30, 120, "Item3"));
        itemList.add(new Item(40, 150, "Item4"));
        itemList.add(new Item(15, 80, "Item5"));
        itemList.add(new Item(25, 110, "Item6"));
        itemList.add(new Item(35, 130, "Item7"));
        itemList.add(new Item(45, 160, "Item8"));
        itemList.add(new Item(45,1050,"Item9"));
        return itemList;
    }
    private static List<Item> getUnselectedItems(List<Item> itemList, List<Item> selectedItems) {
        List<Item> unselectedItems = new ArrayList<>(itemList);
        unselectedItems.removeAll(selectedItems);
        return unselectedItems;
    }
}
