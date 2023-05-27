package br.edu.uricer.projeto.integrador.presentation;

import br.edu.uricer.projeto.integrador.algorithms.KnapsackAlgorithm;
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
    public ResponseEntity<String> getresult(@RequestParam int budget) {
        try {
            KnapsackAlgorithm knapsackAlgorithm = new KnapsackAlgorithm();
            //int result =  knapsackAlgorithm.knapsackDynamicProgramming(pesoDeTodosOsItens, valoresDosItensDisponiveisQuePodemSerColocadosNaMochila, availableItems.size(), budget, availableItems,budget);
            String result = "CAMINHO BEM SUCEDIDO! Voce digitou: " + budget;
            return new ResponseEntity<>(result,HttpStatus.OK);
        } catch (Exception e) {
            log.error("Problema no Algoritmo Padrao de Knapsack");
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
            log.error("Problem in the home");
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
