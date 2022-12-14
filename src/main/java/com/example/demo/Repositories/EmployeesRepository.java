package com.example.demo.Repositories;

import com.example.demo.Models.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface EmployeesRepository extends JpaRepository<Employees,Long> {

    @Query(value = "select * from employees em where em.nom =:name",nativeQuery = true)
    Optional<Employees> getEmploteeByidEmplo(@Param("name") String name);
}
