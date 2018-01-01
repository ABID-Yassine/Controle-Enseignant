package tn.iit.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.iit.entity.Enseignement;
@Repository
public interface EnseignementDAO extends JpaRepository<Enseignement, Integer> {

	List<Enseignement> findByDate(Date date);
	
}
