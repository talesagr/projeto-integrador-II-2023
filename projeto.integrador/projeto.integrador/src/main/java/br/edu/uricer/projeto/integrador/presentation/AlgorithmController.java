package br.edu.uricer.projeto.integrador.presentation;

import br.edu.uricer.projeto.integrador.algorithms.KnapsackAlgorithm;
import br.edu.uricer.projeto.integrador.domains.Item;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api")
public class AlgorithmController {

    public AlgorithmController(){

    }
    @GetMapping("/default")
    public ResponseEntity<Integer> getByBudget(@PathVariable int budget,@PathVariable List<Item> selectedItems) {
        try {
            KnapsackAlgorithm knapsackAlgorithm = new KnapsackAlgorithm(); //TODO pegar as propriedades dos itens, peso, valor, orcamento...
            Item item1 = new Item(60,250,"item1");
            Item item2 = new Item(160,1000,"item2");
            Item item3 = new Item(260,550,"item3");
            Item item4 = new Item(360,10000,"item4");

            List<Item> availableItems = new ArrayList<>();
            availableItems.add(item1);
            availableItems.add(item2);
            availableItems.add(item3);
            availableItems.add(item4);
            int[] pesoDeTodosOsItens = {item1.getWeight(),item2.getWeight(),item3.getWeight(),item4.getWeight()};
            int[] valoresDosItensDisponíveisQuePodemSerColocadosNaMochila ={
                    item1.getValue(),item2.getValue(),item3.getValue(),item4.getValue()
            };

            int result =  knapsackAlgorithm.knapsackDynamicProgramming(pesoDeTodosOsItens, valoresDosItensDisponíveisQuePodemSerColocadosNaMochila, availableItems.size(), budget, availableItems);
            return new ResponseEntity<>(result,HttpStatus.OK);
        } catch (Exception e) {
            log.error("Problema no Algoritmo Padrao de Knapsack");
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
    }
}
