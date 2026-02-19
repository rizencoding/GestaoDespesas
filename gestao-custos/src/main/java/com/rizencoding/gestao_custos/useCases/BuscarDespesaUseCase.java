package com.rizencoding.gestao_custos.useCases;

import com.rizencoding.gestao_custos.entity.DespesaModel;
import com.rizencoding.gestao_custos.repository.DespesaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BuscarDespesaUseCase {
    @Autowired
    private DespesaRespository despesaRespository;
    public List<DespesaModel> execute(String email, LocalDate date){
        List<DespesaModel> despesas;
        if(date != null){
            despesas = despesaRespository.findByEmailAndDate(email, date);
        }else{
            despesas = despesaRespository.findByEmail(email);
        }
        return  despesas;
    }
}
