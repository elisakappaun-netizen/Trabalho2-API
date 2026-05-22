package br.com.serratec.trabalho2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.trabalho2.model.LancamentoVendas;

public interface LancamentoVendasRepository extends JpaRepository<LancamentoVendas, Long>{
}
