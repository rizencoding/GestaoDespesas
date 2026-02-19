package com.rizencoding.gestao_custos.controller;

import com.rizencoding.gestao_custos.entity.DespesaModel;
import com.rizencoding.gestao_custos.useCases.BuscarDespesaUseCase;
import com.rizencoding.gestao_custos.useCases.CadastroDespesaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/management")
public class GestaoDespesasController {
    @Autowired
    CadastroDespesaUseCase cadastroDespesaUseCase;

    @Autowired
    BuscarDespesaUseCase buscarDespesaUseCase;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DespesaModel despesa){
        try {
            var result = cadastroDespesaUseCase.execute(despesa);
            return  ResponseEntity.ok(result);
        } catch (IllegalArgumentException e){
            return  ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @GetMapping("/{email}")
    public List<DespesaModel> findByEmailAndDate(@PathVariable String email, @RequestParam(required = false) LocalDate date){
        return  buscarDespesaUseCase.execute(email,date);
    }
}
