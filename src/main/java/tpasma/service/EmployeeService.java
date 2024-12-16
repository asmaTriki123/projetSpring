package tpasma.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tpasma.model.Employee;
import tpasma.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Ajouter un employé
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Obtenir tous les employés
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Obtenir un employé par son ID
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    // Mettre à jour un employé
    public Employee updateEmployee(Long id, Employee employeeDetails) {
        // On suppose que l'employé existe et est présent dans la base de données
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        
        existingEmployee.setNom(employeeDetails.getNom());
        existingEmployee.setPrenom(employeeDetails.getPrenom());
        existingEmployee.setRole(employeeDetails.getRole());
        existingEmployee.setMotDePasse(employeeDetails.getMotDePasse());
        existingEmployee.setEmail(employeeDetails.getEmail());
        existingEmployee.setNumeroTelephone(employeeDetails.getNumeroTelephone());
        existingEmployee.setNumCnss(employeeDetails.getNumCnss());

        return employeeRepository.save(existingEmployee);
    }

    // Supprimer un employé
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
