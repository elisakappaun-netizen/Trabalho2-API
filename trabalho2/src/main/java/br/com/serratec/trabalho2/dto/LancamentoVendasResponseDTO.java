package br.com.serratec.trabalho2.dto;

import java.time.LocalDate;


public record LancamentoVendasResponseDTO(LocalDate data, Double valor, String nome) {
    
}
