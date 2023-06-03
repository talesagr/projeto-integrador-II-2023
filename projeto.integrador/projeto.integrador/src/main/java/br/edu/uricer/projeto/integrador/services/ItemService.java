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
        itemList.add(new Item(1,20, 100, "Cadeira de Madeira"));
        itemList.add(new Item(2, 30,175, "Mesa de Madeira"));
        itemList.add(new Item(3,40, 160, "Armario de Madeira"));
        itemList.add(new Item(4,50, 200, "Cama de Madeira"));
        itemList.add(new Item(5,60, 100, "Cabeçeira de Madeira"));
        itemList.add(new Item(6,70, 130, "Bancada de Madeira"));
        itemList.add(new Item(7,80, 1650, "Adega de Madeira"));
        itemList.add(new Item(8,90,1050,"Nicho de Madeira"));
        itemList.add(new Item(9,100,3450,"Mesa de Madeira de ambiente externo"));
        itemList.add(new Item(10,110,450,"Cadeira de Madeira de ambiente externo"));
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

    public File saveItems(List<Item> newList) {
        Gson gson = new Gson();
        String json = gson.toJson(newList);
        String filename = "items.json";

        try (FileWriter fileWriter = new FileWriter(filename)) {
            fileWriter.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new File(filename);
    }
}
