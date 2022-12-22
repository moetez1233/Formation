package com.example.demo.services;

import com.example.demo.domain.Employe;

import java.util.List;

public interface EmployService {
    Employe getUser(String nom);
    Employe SaveEmployees(Employe employe);
    List<Employe> getAllEmployees();
}
