package br.edu.uricer.projeto.integrador.algorithms;

import br.edu.uricer.projeto.integrador.domains.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KnapsackAlgorithm {
    public int knapsackDynamicProgramming(int[] weightOfAvailableItens, int[] valuesOfWeightOfAvailableItens, int availableItensToPutInside, int maxWeightOfTheBag, List<Item> itemList) {

        if (availableItensToPutInside <= 0 || maxWeightOfTheBag <= 0) {
            return 0;
        }

        int[][] m = new int[availableItensToPutInside + 1][maxWeightOfTheBag + 1];
        boolean[][] selected = new boolean[availableItensToPutInside + 1][maxWeightOfTheBag + 1]; // keep track of selected items
        for (int j = 0; j <= maxWeightOfTheBag; j++) {
            m[0][j] = 0;
        }

        for (int i = 1; i <= availableItensToPutInside; i++) {
            for (int j = 1; j <= maxWeightOfTheBag; j++) {
                if (weightOfAvailableItens[i - 1] > j) {
                    m[i][j] = m[i - 1][j];
                } else {
                    int valueWithoutItemI = m[i - 1][j];
                    int valueWithItemI = m[i - 1][j - weightOfAvailableItens[i - 1]] + valuesOfWeightOfAvailableItens[i - 1];
                    if (valueWithItemI > valueWithoutItemI) {
                        m[i][j] = valueWithItemI;
                        selected[i][j] = true;
                    } else {
                        m[i][j] = valueWithoutItemI;
                    }
                }
            }
        }

        // Find selected items
        List<Item> selectedItems = new ArrayList<>();
        int j = maxWeightOfTheBag;
        for (int i = availableItensToPutInside; i >= 1 && j >= 1; i--) {
            if (selected[i][j]) {
                selectedItems.add(itemList.get(i - 1));
                j -= weightOfAvailableItens[i - 1];
            }
        }
        Collections.reverse(selectedItems);

        // Print selected items and their values
        System.out.print("Itens selecionados: ");
        for (Item item : selectedItems) {
            System.out.print("(" + item.getName() + ", U$" + item.getValue() + ") ");
        }
        System.out.println();


        return m[availableItensToPutInside][maxWeightOfTheBag];
    }
}
