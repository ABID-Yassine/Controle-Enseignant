package tn.iit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.iit.entity.Enseignement;
@Repository
public interface EnseignementDAO extends JpaRepository<Enseignement, Integer> {
}
