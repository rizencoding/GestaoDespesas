package com.rizencoding.gestao_custos.performance;

import com.rizencoding.gestao_custos.entity.DespesaModel;
import com.rizencoding.gestao_custos.repository.DespesaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/gestao/performance")
@RestController
public class GestaoDeDespesaPerformance {
    @Autowired
    DespesaRespository respository;

    @GetMapping("/sem-paginacao")
    public ResponseEntity<List<DespesaModel>> listarSemPaginacao(){
        long inicio = System.currentTimeMillis();

        var despesas = respository.findAll();

        long fim = System.currentTimeMillis();
        System.out.println("Tempo até a conclusão: "+(fim - inicio)+ " ms");
        return  ResponseEntity.ok(despesas);
    }

    @GetMapping("/com-paginacao")
    public ResponseEntity<Page<DespesaModel>> listarComPaginacao(Pageable pageable){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        var despesas = respository.findAll(pageable);

        stopWatch.stop();
        System.out.println("Tempo com paginação: "+stopWatch.getTotalTimeMillis()+ " ms");
        return  ResponseEntity.ok(despesas);
    }

    @GetMapping("/com-paginacao/{email}")
    public ResponseEntity<Page<DespesaModel>> listarComPaginacao(@PathVariable String email, Pageable pageable){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        var despesas = respository.findByEmail(email, pageable);

        stopWatch.stop();
        System.out.println("Tempo com paginação: "+stopWatch.getTotalTimeMillis()+ " ms");
        return  ResponseEntity.ok(despesas);
    }

    @Cacheable(value = "gastosPorEmailCache", key = "#email + '-'+ #pageable.pageNumber + '-' + #pageable.pageSize + '-'")
    @GetMapping("/cache/{email}")
    public ResponseEntity<Page<DespesaModel>> cacheComPaginacao(@PathVariable String email, Pageable pageable){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        var depesas = respository.findByEmail(email, pageable);
        stopWatch.stop();

        System.out.println("Tempo: "+ stopWatch.getTotalTimeMillis()+" ms");
        return  ResponseEntity.ok(depesas);
    }
}
