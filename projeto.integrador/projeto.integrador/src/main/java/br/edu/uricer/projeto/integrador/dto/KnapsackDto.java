package br.edu.uricer.projeto.integrador.dto;

import br.edu.uricer.projeto.integrador.algorithms.KnapsackAlgorithm;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class KnapsackDto {
    @JsonProperty("budget")
    private int budget;

}
