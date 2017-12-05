package tn.iit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.iit.entity.Pointage;

@Repository
public interface PointageDAO extends JpaRepository<Pointage, Integer> {


}
