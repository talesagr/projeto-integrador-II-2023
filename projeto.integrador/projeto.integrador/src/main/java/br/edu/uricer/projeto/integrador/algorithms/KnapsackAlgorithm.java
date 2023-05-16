package br.edu.uricer.projeto.integrador.algorithms;

import br.edu.uricer.projeto.integrador.domains.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KnapsackAlgorithm {
    public List<Item> knapsackDynamicProgramming(int[] weightOfAvailableItems, int[] valuesOfWeightOfAvailableItems, int availableItemsToPutInside, int targetValue, List<Item> itemList) {
        if (availableItemsToPutInside <= 0 || targetValue <= 0) {
            return new ArrayList<>();
        }

        int[][] m = new int[availableItemsToPutInside + 1][targetValue + 1];
        boolean[][] selected = new boolean[availableItemsToPutInside + 1][targetValue + 1];

        for (int i = 1; i <= availableItemsToPutInside; i++) {
            for (int j = 1; j <= targetValue; j++) {
                int valueWithoutItemI = m[i - 1][j];
                if (valuesOfWeightOfAvailableItems[i - 1] > j) {
                    m[i][j] = valueWithoutItemI;
                } else {
                    int valueWithItemI = m[i - 1][j - valuesOfWeightOfAvailableItems[i - 1]] + weightOfAvailableItems[i - 1];
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
        int j = targetValue;
        for (int i = availableItemsToPutInside; i >= 1 && j >= 1; i--) {
            if (selected[i][j]) {
                selectedItems.add(itemList.get(i - 1));
                j -= valuesOfWeightOfAvailableItems[i - 1];
            }
        }
        Collections.reverse(selectedItems);

        return selectedItems;
    }

    public List<Item> knapsackDynamicProgrammingWithDesiredItem(int[] weights, int[] values, int size, int targetValue, int desiredItemIndex, List<Item> itemList) {
        if (size <= 0 || targetValue <= 0 || desiredItemIndex < 0 || desiredItemIndex >= itemList.size()) {
            return new ArrayList<>();
        }

        int[][] dp = new int[size + 1][targetValue + 1];
        boolean[][] selected = new boolean[size + 1][targetValue + 1];

        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= targetValue; j++) {
                int valueWithoutItemI = dp[i - 1][j];
                if (values[i - 1] > j) {
                    dp[i][j] = valueWithoutItemI;
                } else {
                    int valueWithItemI = dp[i - 1][j - values[i - 1]] + weights[i - 1];
                    if (valueWithItemI > valueWithoutItemI) {
                        dp[i][j] = valueWithItemI;
                        selected[i][j] = true;
                    } else {
                        dp[i][j] = valueWithoutItemI;
                    }
                }
            }
        }

        // Find selected items
        List<Item> selectedItems = new ArrayList<>();
        int j = targetValue;
        for (int i = size; i >= 1 && j >= 1; i--) {
            if (selected[i][j]) {
                if (i - 1 == desiredItemIndex) {
                    selectedItems.add(itemList.get(i - 1));
                }
                j -= values[i - 1];
            }
        }
        Collections.reverse(selectedItems);

        return selectedItems;
    }
}
