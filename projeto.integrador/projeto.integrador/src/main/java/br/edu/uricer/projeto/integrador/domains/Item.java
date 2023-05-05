package br.edu.uricer.projeto.integrador.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class Item {
    int weight;
    int value;
    String name;

}