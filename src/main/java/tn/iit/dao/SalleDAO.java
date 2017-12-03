package tn.iit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.iit.entity.Salle;
@Repository
public interface SalleDAO extends JpaRepository<Salle, Integer> {

}
