package com.bedford.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bedford.demo.entity.Shark;

@Repository
public interface SharkRepo extends JpaRepository<Shark, Long> {

}
