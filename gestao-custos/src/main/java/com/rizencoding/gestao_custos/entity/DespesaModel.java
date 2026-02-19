package com.rizencoding.gestao_custos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tb_despesas")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DespesaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private LocalDate date;
    @Column(nullable = false)
    private BigDecimal valuee;
    @Column(nullable = false)
    private String email;
    @Column(length = 100, nullable = false)
    private String category;
    @CreationTimestamp
    private LocalDate creationDate;


    @Override
    public String toString() {
        return "DespesaModel{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", value=" + valuee +
                ", email='" + email + '\'' +
                ", category='" + category + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
