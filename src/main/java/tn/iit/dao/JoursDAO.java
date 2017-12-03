package tn.iit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.iit.entity.Jours;

@Repository
public interface JoursDAO extends JpaRepository<Jours, Integer> {
}
