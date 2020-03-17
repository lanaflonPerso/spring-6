package com.spring.karim.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.karim.restful.model.*;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}