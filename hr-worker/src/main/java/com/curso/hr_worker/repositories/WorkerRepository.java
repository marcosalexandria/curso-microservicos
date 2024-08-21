package com.curso.hr_worker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.hr_worker.entity.Worker;
@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
