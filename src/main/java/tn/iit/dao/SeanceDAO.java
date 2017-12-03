package tn.iit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.iit.entity.Seances;

@Repository
public interface SeanceDAO extends JpaRepository<Seances, Integer> {

}
