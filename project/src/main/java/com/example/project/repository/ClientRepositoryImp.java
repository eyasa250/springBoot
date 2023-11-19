package com.example.project.repository;

import com.example.project.Entity.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ClientRepositoryImp implements  ClientRepositoryCostum{
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Client getClientByFullname(String fullname) {
        Query query=entityManager.createNativeQuery("SELECT C.* FROM Client c"+
                "WHERE C.fullname LIKE ?", Client.class);
        query.setParameter( 1, fullname +"%");
        return (Client) query.getSingleResult();
    }

    @Transactional
    public boolean existsByEmailLike(String email) {
        Query query=entityManager.createNativeQuery("SELECT C.email FROM Client c"+
                "WHERE C.email LIKE ?", Client.class);
        query.setParameter( 1, email +"%");
        List<Client> resultList = query.getResultList();
        return !resultList.isEmpty();

    }
    @Transactional
    public boolean existsByUsernameLike (String username){
        Query query=entityManager.createNativeQuery("SELECT C.username FROM Client c"+
                "WHERE C.username LIKE ?", Client.class);
        query.setParameter( 1, username +"%");
        List<Client> resultList = query.getResultList();
        return !resultList.isEmpty();

    }

}
