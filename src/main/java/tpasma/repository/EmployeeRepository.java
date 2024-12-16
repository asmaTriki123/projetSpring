package tpasma.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tpasma.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Cette interface étend JpaRepository et fournit des méthodes pour les opérations CRUD
}