package com.example.demo.repositories;

import com.example.demo.domain.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EmployeesRepository extends JpaRepository<Employe,Long> {

    @Query(value = "select * from employees em where em.nom =:name",nativeQuery = true)
    Optional<Employe> getEmploteeByidEmplo(@Param("name") String name);
}
