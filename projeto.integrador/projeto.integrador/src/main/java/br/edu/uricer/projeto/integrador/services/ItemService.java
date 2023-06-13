package br.edu.uricer.projeto.integrador.services;

import br.edu.uricer.projeto.integrador.domains.Item;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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


        itemList.add(new Item(8,3000,3000,"Conjunto Mesa de Jantar VIP"));
        itemList.add(new Item(6,1000, 1000, "Mesa de Jantar VIP"));
        itemList.add(new Item(7,500, 500, "Cadeira VIP"));
        itemList.add(new Item(5,350, 350, "Mesa de Jantar de Vidro"));
        itemList.add(new Item(4,200, 200, "Mesa de Jantar de Madeira"));
        itemList.add(new Item(3,150, 150, "Cadeira de Ferro - Preta"));
        itemList.add(new Item(2, 140,140, "Cadeira de Ferro - Branca"));
        itemList.add(new Item(1,100, 100, "Mesa de Centro"));
        itemList.add(new Item(0,80, 80, "Cadeira de Madeira"));
        itemList.add(new Item(10,50,50, "Luminária para mesa de centro"));
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
