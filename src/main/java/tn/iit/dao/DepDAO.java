package tn.iit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.iit.entity.Dep;


@Repository
public interface DepDAO extends JpaRepository<Dep, Integer> {

}
