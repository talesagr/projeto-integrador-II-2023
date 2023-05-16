package br.edu.uricer.projeto.integrador.presentation;

import br.edu.uricer.projeto.integrador.algorithms.KnapsackAlgorithm;
import br.edu.uricer.projeto.integrador.domains.Item;
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
@NoArgsConstructor
@RequestMapping("/api")
public class AlgorithmController {
    @GetMapping("/default")
    public ResponseEntity<Integer> getresult(@RequestParam int budget) {
        try {
            KnapsackAlgorithm knapsackAlgorithm = new KnapsackAlgorithm();
            //TODO retornar tambem os Itens e nao somente o valor final, esta atualmente imprimindo no console

            //Foi criado uma classe de teste para realizar testes do algoritmo sem ser via requisicao HTTP
            //int result =  knapsackAlgorithm.knapsackDynamicProgramming(pesoDeTodosOsItens, valoresDosItensDisponiveisQuePodemSerColocadosNaMochila, availableItems.size(), budget, availableItems,budget);
            int result = 0;
            return new ResponseEntity<>(result,HttpStatus.OK);
        } catch (Exception e) {
            log.error("Problema no Algoritmo Padrao de Knapsack");
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
    }
}
