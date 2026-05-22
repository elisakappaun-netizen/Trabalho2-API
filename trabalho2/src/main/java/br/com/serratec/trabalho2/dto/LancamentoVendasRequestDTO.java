package br.com.serratec.trabalho2.dto;

import java.time.LocalDate;

public class LancamentoVendasRequestDTO {

    private LocalDate data;
    private Double valor;
    private Long vendedorId;

    
    public LancamentoVendasRequestDTO(LocalDate data, Double valor, Long vendedorId) {
        this.data = data;
        this.valor = valor;
        this.vendedorId = vendedorId;
    }

    public LancamentoVendasRequestDTO() {
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Long getVendedorId() {
        return vendedorId;
    }

    public void setVendedorId(Long vendedorId) {
        this.vendedorId = vendedorId;
    }

}
