package br.edu.uricer.projeto.integrador.services;

import br.edu.uricer.projeto.integrador.domains.Item;
import org.springframework.stereotype.Service;

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
}
