package com.example.FinalProject.repository;

import com.example.FinalProject.model.Dividend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DividendRepository extends JpaRepository<Dividend, Long> {
}
