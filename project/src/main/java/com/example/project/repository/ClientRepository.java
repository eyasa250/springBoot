package com.example.project.repository;

import com.example.project.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long>,ClientRepositoryCostum{
}
