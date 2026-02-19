package com.rizencoding.gestao_custos.useCases;


import com.rizencoding.gestao_custos.entity.DespesaModel;
import com.rizencoding.gestao_custos.repository.DespesaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroDespesaUseCase {
    @Autowired
    DespesaRespository despesaRespository;

    public DespesaModel execute(DespesaModel d){
        if(d.getCategory() == null || d.getEmail() == null || d.getDate() == null || d.getDescription() == null || d.getValuee() == null){
            throw new IllegalArgumentException("Error. Required fields not filled in.");
        }

        despesaRespository.save(d);
        return d;
    }
}
