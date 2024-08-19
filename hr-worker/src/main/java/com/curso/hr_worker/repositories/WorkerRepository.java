package com.curso.hr_worker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.hr_worker.entity.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
