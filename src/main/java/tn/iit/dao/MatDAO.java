package tn.iit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.iit.entity.Mat;
@Repository
public interface MatDAO extends JpaRepository<Mat, Integer> {
}
