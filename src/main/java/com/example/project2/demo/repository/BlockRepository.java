package com.example.project2.demo.repository;

import com.example.project2.demo.domain.Block;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BlockRepository extends JpaRepository<Block, Long> {
}
