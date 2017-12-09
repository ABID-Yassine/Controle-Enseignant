package tn.iit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.iit.entity.Matiere;
@Repository
public interface MatiereDAO extends JpaRepository<Matiere, Integer> {
}
