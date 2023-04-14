package br.edu.uricer.projeto.integrador.presentation;

import br.edu.uricer.projeto.integrador.algorithms.KnapsackAlgorithm;
import br.edu.uricer.projeto.integrador.domains.Items;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api")
public class AlgorithmController {

    public AlgorithmController(){

    }
    @GetMapping("/default")
    public ResponseEntity<KnapsackAlgorithm> get(int Budget, List<Items> selectedItems) {
        try {
            KnapsackAlgorithm knapsackAlgorithm = new KnapsackAlgorithm(); //TODO pegar as propriedades dos itens, peso, valor, orcamento...
        } catch (Exception e) {
            log.error("Problema no Algoritmo Padrao de Knapsack");
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
