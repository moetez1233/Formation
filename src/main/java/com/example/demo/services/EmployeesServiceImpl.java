package com.example.demo.services;

import com.example.demo.custumException.NotExist;
import com.example.demo.domain.Employe;
import com.example.demo.repositories.EmployeesRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class EmployeesServiceImpl implements EmployService{
    @Autowired
    private EmployeesRepository employeesRepository;
    private static final Logger logger = LogManager.getLogger(EmployeesServiceImpl.class);

    @Override
    @Transactional(readOnly = true)
    public Employe getUser(String nom) {
        return employeesRepository.getEmploteeByidEmplo(nom)
                .orElseThrow(()->
                    new NotExist("user "+nom+ " not found")
                );
    }

    @Override
    public Employe SaveEmployees(Employe employe) {
        return employeesRepository.save(employe);
    }

    @Override
    public List<Employe> getAllEmployees() {
        return employeesRepository.findAll();
    }
}
