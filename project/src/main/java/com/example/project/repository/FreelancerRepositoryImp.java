package com.example.project.repository;

import com.example.project.Entity.Freelancer;
import com.example.project.Entity.Freelancer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class FreelancerRepositoryImp implements FreelancerRepositoryCostum {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Freelancer getFreelancerByFullname(String fullname) {
        Query query=entityManager.createNativeQuery("SELECT U.* FROM Freelancer U"+
                "WHERE U.fullname LIKE ?", Freelancer.class);
        query.setParameter( 1, fullname +"%");
        return (Freelancer) query.getSingleResult();
    }

    @Transactional
    public boolean existsByEmailLike(String email) {
        Query query=entityManager.createNativeQuery("SELECT F.email FROM Freelancer F"+
                "WHERE F.email LIKE ?", Freelancer.class);
        query.setParameter( 1, email +"%");
        List<Freelancer> resultList = query.getResultList();
        return !resultList.isEmpty();

    }
    @Transactional
    public boolean existsByUsernameLike (String username) {
        Query query=entityManager.createNativeQuery("SELECT F.username FROM Freelancer F"+
                "WHERE F.username LIKE ?", Freelancer.class);
        query.setParameter( 1, username +"%");
        List<Freelancer> resultList = query.getResultList();
        return !resultList.isEmpty();

    }

}
