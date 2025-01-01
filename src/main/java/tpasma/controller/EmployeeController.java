package tpasma.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tpasma.model.Employee;
import tpasma.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

   
    private final EmployeeService employeeService;

    // Ajouter un employé
    @PostMapping("/ajouter")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        // Appel au service pour ajouter l'employé
        Employee savedEmployee = employeeService.addEmployee(employee);
        return ResponseEntity.ok(savedEmployee);
    }

    // Obtenir tous les employés
    @GetMapping
    public List<Employee> getAllEmployees() {
        // Appel au service pour récupérer tous les employés
        return employeeService.getAllEmployees();
    }

    // Obtenir un employé par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        // Appel au service pour récupérer l'employé par ID
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Mettre à jour un employé
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        // Appel au service pour mettre à jour l'employé
        Employee updatedEmployee = employeeService.updateEmployee(id, employeeDetails);
        return ResponseEntity.ok(updatedEmployee);
    }

    // Supprimer un employé
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        // Appel au service pour supprimer l'employé
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
