package com.example.demo.Services;

import com.example.demo.Models.Employees;

import java.util.List;

public interface EmployService {
    Employees getUser(String nom);
    Employees SaveEmployees(Employees employees);
    List<Employees> getAllEmployees();
}
