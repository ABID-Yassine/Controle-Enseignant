package tn.iit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.iit.entity.Enseignant;

@Repository
public interface EnseignantDAO extends JpaRepository<Enseignant, Integer> {
}
