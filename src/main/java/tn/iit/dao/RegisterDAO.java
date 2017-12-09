package tn.iit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.iit.entity.Register;

@Repository
public interface RegisterDAO extends JpaRepository<Register, String> {
}
