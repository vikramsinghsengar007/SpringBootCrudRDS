package com.springboot.crud.repository;

import com.springboot.crud.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public interface EmpOracleRepository extends CrudRepository<Employee, Integer> {

}
