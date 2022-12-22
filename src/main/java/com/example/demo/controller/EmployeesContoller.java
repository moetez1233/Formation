package com.example.demo.controller;

import com.example.demo.domain.Employe;
import com.example.demo.services.EmployeesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("employees")
public class EmployeesContoller {
    @Autowired
    private EmployeesServiceImpl employeesService;

    @GetMapping("/list")
    public ResponseEntity<List<Employe>> listEmployees(){
        return ResponseEntity.ok(employeesService.getAllEmployees());
    }
    @GetMapping("/list/{nom}")
   // @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<Employe> getEmployees(@Valid  @PathVariable String nom){
        return ResponseEntity.ok(employeesService.getUser(nom));
    }
    @PostMapping("/add")
    public ResponseEntity<Employe> addEmployee(@Valid @RequestBody Employe employe){
        return ResponseEntity.ok(employeesService.SaveEmployees(employe));
    }
    // i comment it to make it globale in each controller ------> voir GlobaleException Class
    /*@ExceptionHandler
    public ResponseEntity<ErrorObject> handleException(NotExist exception){
        ErrorObject errorObject=new ErrorObject(HttpStatus.NOT_FOUND.value(),exception.getMessage(),System.currentTimeMillis());
        return new ResponseEntity<ErrorObject>(errorObject,HttpStatus.NOT_FOUND);

    }*/

}
