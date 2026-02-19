package com.rizencoding.gestao_custos.repository;

import com.rizencoding.gestao_custos.entity.DespesaModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface DespesaRespository extends JpaRepository<DespesaModel, UUID> {
    List<DespesaModel > findByEmail(String email);
    List<DespesaModel> findByEmailAndDate(String email, LocalDate date);

    Page<DespesaModel> findByEmail(String email, Pageable pageable);
}
