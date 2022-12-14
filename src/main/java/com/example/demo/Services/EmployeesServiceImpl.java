package com.example.demo.Services;

import com.example.demo.CustumException.NotExist;
import com.example.demo.Models.Employees;
import com.example.demo.Repositories.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesServiceImpl implements EmployService{
    @Autowired
    private EmployeesRepository employeesRepository;

    @Override
    public Employees getUser(String nom) {
        return employeesRepository.getEmploteeByidEmplo(nom).orElseThrow(()->new NotExist("user "+nom+ " not found"));
    }

    @Override
    public Employees SaveEmployees(Employees employees) {
        return employeesRepository.save(employees);
    }

    @Override
    public List<Employees> getAllEmployees() {
        return employeesRepository.findAll();
    }
}
