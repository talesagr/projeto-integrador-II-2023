package br.edu.uricer.projeto.integrador.presentation;

import br.edu.uricer.projeto.integrador.algorithms.KnapsackAlgorithm;
import br.edu.uricer.projeto.integrador.domains.Item;
import br.edu.uricer.projeto.integrador.dto.KnapsackDto;
import br.edu.uricer.projeto.integrador.services.ItemService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
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

    private final ItemService itemService;
    public AlgorithmController(ItemService itemService) {
        this.itemService = itemService;
    }
    @GetMapping("/default")
    public ResponseEntity<List> getResult(@RequestBody KnapsackDto knapsackRequest) {
        try {
            int budget = knapsackRequest.getBudget();
            KnapsackAlgorithm knapsackAlgorithm = new KnapsackAlgorithm();

            List result = knapsackAlgorithm.knapsackDynamicProgramming(
                    itemService.getWeightOfItems(),
                    itemService.getValueOfItems(),
                    itemService.getItemList().size(),
                    budget,
                    itemService.getItemList()
            );

            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Problema no Algoritmo Padrão de Knapsack: ", e);
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
    }

    @GetMapping("/home")
    public ResponseEntity<List> getHome() {
        try {
            List itemsList = new ArrayList();
            itemsList.addAll(itemService.getItemList());
            return new ResponseEntity<>(itemsList, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Problema na Home: ", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveItems(@RequestBody List<Item> itemList) {
        try {
            if (itemList != null && !itemList.isEmpty()) {
                itemService.saveItems(itemList);
                return new ResponseEntity<>("Arquivo salvo com sucesso", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Sua lista de itens está vazia", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            log.error("Problema no salvamento de itens", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
