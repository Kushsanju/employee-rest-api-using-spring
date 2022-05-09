package rancom.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rancom.example.demo.exception.ResourceNotFoundeException;
import rancom.example.demo.model.Employee;
import rancom.example.demo.repository.Employee_Repository;

import java.util.AbstractList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
    @Autowired
    private Employee_Repository employee_repository;
    //get all employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employee_repository.findAll();
    }
    //create employee rest API
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        return employee_repository.save(employee);
    }
    //get employee by id rest api
    @GetMapping("/employees/{id}")
    public ResponseEntity <Employee> getEmployeeId(@PathVariable Long id){
        Employee employee=employee_repository.findById(id)
                .orElseThrow(()->new ResourceNotFoundeException("Employeenot exist with id:" + id));
        return ResponseEntity.ok(employee);
    }

    //update employee rest api
    @PutMapping("/employees/{id}")
    public ResponseEntity <Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee employeeDetails){
        Employee employee=employee_repository.findById(id)
                .orElseThrow(()->new ResourceNotFoundeException("Employeenot exist with id:" + id));
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmailId(employeeDetails.getEmailId());
        Employee updatedEmployee=employee_repository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }
    //delete emloyee rest api
    @DeleteMapping("/employees/{id}")
    public ResponseEntity< Map<String,Boolean>> deleteEmployee(@PathVariable Long id){
        Employee employee=employee_repository.findById(id)
                .orElseThrow(()->new ResourceNotFoundeException("Employeenot exist with id:" + id));
        employee_repository.delete(employee);
        Map<String,Boolean> response= new HashMap<>();
        response.put("Deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
