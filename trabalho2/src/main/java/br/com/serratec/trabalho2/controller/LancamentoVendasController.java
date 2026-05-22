package br.com.serratec.trabalho2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.trabalho2.dto.LancamentoVendasRequestDTO;
import br.com.serratec.trabalho2.dto.LancamentoVendasResponseDTO;
import br.com.serratec.trabalho2.model.LancamentoVendas;
import br.com.serratec.trabalho2.service.LancamentoVendasService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoVendasController {

    @Autowired
    private LancamentoVendasService service;

    @GetMapping("{id}")
    public ResponseEntity<LancamentoVendasResponseDTO> listarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.listarPorId(id));
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LancamentoVendas inserir(@Valid @RequestBody LancamentoVendasRequestDTO dto){
        return service.inserir(dto);
    }
}
