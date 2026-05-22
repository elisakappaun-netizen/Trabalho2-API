package br.com.serratec.trabalho2.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.trabalho2.dto.LancamentoVendasRequestDTO;
import br.com.serratec.trabalho2.dto.LancamentoVendasResponseDTO;
import br.com.serratec.trabalho2.handler.NotFoundException;
import br.com.serratec.trabalho2.model.LancamentoVendas;
import br.com.serratec.trabalho2.model.Vendedor;
import br.com.serratec.trabalho2.repository.LancamentoVendasRepository;
import br.com.serratec.trabalho2.repository.VendedorRepository;

@Service
public class LancamentoVendasService {

    @Autowired
    private LancamentoVendasRepository repository;

    @Autowired
    private VendedorRepository vendedorRepository;

    public LancamentoVendas inserir(LancamentoVendasRequestDTO dto) {
        Optional<Vendedor> vendedor = vendedorRepository.findById(dto.getVendedorId());

        if (vendedor.isEmpty()) {
            throw new NotFoundException("Vendedor não encontrado!");
        }
        Vendedor v = vendedor.get();
        LancamentoVendas lancamentoVendas = new LancamentoVendas();
        lancamentoVendas.setData(dto.getData());
        lancamentoVendas.setValor(dto.getValor());
        lancamentoVendas.setVendedor(v);
        return repository.save(lancamentoVendas);
    }

    public LancamentoVendasResponseDTO listarPorId(Long id) {
        Optional<LancamentoVendas> lancamentos = repository.findById(id);

        if (lancamentos.isEmpty()) {
            throw new NotFoundException("Lançamento não encontrado!");
        }
        LancamentoVendas lancamentoVendas = lancamentos.get();
        return new LancamentoVendasResponseDTO(lancamentoVendas.getData(), lancamentoVendas.getValor(),
                lancamentoVendas.getVendedor().getNome());

    }

}
