package br.edu.uricer.projeto.integrador.services;

import br.edu.uricer.projeto.integrador.domains.Item;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
@Service
public class ItemService {

    public List getItemList() {
        List<Item> itemList = createItemList();
        return itemList;
    }
    private static List<Item> createItemList() {
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item(0,10, 60, "Item1"));
        itemList.add(new Item(1,20, 100, "Item2"));
        itemList.add(new Item(2, 30,120, "Item3"));
        itemList.add(new Item(3,40, 150, "Item4"));
        itemList.add(new Item(4,50, 80, "Item5"));
        itemList.add(new Item(5,60, 110, "Item6"));
        itemList.add(new Item(6,70, 130, "Item7"));
        itemList.add(new Item(7,80, 160, "Item8"));
        itemList.add(new Item(8,90,1050,"Item9"));
        return itemList;
    }

    public int[] getWeightOfItems() {
        List<Item> itemList = getItemList();
        int[] weightOfItems = new int[itemList.size()];

        for (int i = 0; i < itemList.size(); i++) {
            weightOfItems[i] = itemList.get(i).getWeight();
        }

        return weightOfItems;
    }


    public int[] getValueOfItems(){
        List<Item> itemList = getItemList();
        int[] valueOfItems = new int[itemList.size()];

        for (int i = 0; i < itemList.size(); i++) {
            valueOfItems[i] = itemList.get(i).getValue();
        }

        return valueOfItems;
    }
}
