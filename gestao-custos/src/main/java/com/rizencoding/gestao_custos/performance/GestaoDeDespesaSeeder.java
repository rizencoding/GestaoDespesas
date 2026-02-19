package com.rizencoding.gestao_custos.performance;

import com.rizencoding.gestao_custos.entity.DespesaModel;
import com.rizencoding.gestao_custos.repository.DespesaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//@Component
public class GestaoDeDespesaSeeder implements CommandLineRunner {
    @Autowired
    private DespesaRespository despesaRespository;
    @Override
    public void run(String... args) throws Exception {
        List<DespesaModel> despesas = new ArrayList<>();
        System.out.println("Iniciando geração de seed");
        for(int i = 0; i <= 150000; i++){
            DespesaModel d = new DespesaModel();
            d.setDescription("Gasto n° "+i);
            d.setValuee(BigDecimal.valueOf(10 + (i % 50)));
            d.setDate(LocalDate.now().minusDays(i % 30));
            d.setCategory("TESTE");
            d.setEmail("performance@gmail.com");
            despesas.add(d);
        }

        despesaRespository.saveAll(despesas);
        System.out.println("Finalizando a geração de seed.");
    }
}
