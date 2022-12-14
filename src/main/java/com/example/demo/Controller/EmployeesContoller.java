package com.example.demo.Controller;

import com.example.demo.CustumException.ErrorObject;
import com.example.demo.CustumException.NotExist;
import com.example.demo.Models.Employees;
import com.example.demo.Services.EmployeesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<List<Employees>> listEmployees(){
        return ResponseEntity.ok(employeesService.getAllEmployees());
    }
    @GetMapping("/list/{nom}")
   // @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<Employees> getEmployees(@Valid  @PathVariable String nom){
        return ResponseEntity.ok(employeesService.getUser(nom));
    }
    @PostMapping("/add")
    public ResponseEntity<Employees> addEmployee(@Valid @RequestBody Employees employees){
        return ResponseEntity.ok(employeesService.SaveEmployees(employees));
    }
    // i comment it to make it globale in each controller ------> voir GlobaleException Class
    /*@ExceptionHandler
    public ResponseEntity<ErrorObject> handleException(NotExist exception){
        ErrorObject errorObject=new ErrorObject(HttpStatus.NOT_FOUND.value(),exception.getMessage(),System.currentTimeMillis());
        return new ResponseEntity<ErrorObject>(errorObject,HttpStatus.NOT_FOUND);

    }*/

}
