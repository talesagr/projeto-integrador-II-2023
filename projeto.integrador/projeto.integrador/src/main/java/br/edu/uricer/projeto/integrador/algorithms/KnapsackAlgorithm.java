package br.edu.uricer.projeto.integrador.algorithms;

import br.edu.uricer.projeto.integrador.domains.Items;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KnapsackAlgorithm {
    public int knapsackDynamicProgramming(int[] w, int[] v, int n, int W, List<Items> itemsList) {
        if (n <= 0 || W <= 0) {
            return 0;
        }

        int[][] m = new int[n + 1][W + 1];
        boolean[][] selected = new boolean[n + 1][W + 1]; // keep track of selected items
        for (int j = 0; j <= W; j++) {
            m[0][j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (w[i - 1] > j) {
                    m[i][j] = m[i - 1][j];
                } else {
                    int valueWithoutItemI = m[i - 1][j];
                    int valueWithItemI = m[i - 1][j - w[i - 1]] + v[i - 1];
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
        List<Items> selectedItems = new ArrayList<>();
        int j = W;
        for (int i = n; i >= 1 && j >= 1; i--) {
            if (selected[i][j]) {
                selectedItems.add(itemsList.get(i - 1));
                j -= w[i - 1];
            }
        }
        Collections.reverse(selectedItems);

        // Print selected items and their values
        System.out.print("Itens selecionados: ");
        for (Items item : selectedItems) {
            System.out.print("(" + item.getName() + ", U$" + item.getValue() + ") ");
        }
        System.out.println();

        // Return maximum value
        return m[n][W];
    }
}
