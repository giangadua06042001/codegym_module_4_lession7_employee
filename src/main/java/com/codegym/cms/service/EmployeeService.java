package com.codegym.cms.service;

import com.codegym.cms.model.Employee;
import com.codegym.cms.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeService implements IEmployeeService{
    @Autowired
    private IEmployeeRepository employeeRepository;
    @Override
    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void remove(Employee employee) {
        employeeRepository.delete(employee);
    }
    public Page<Employee> fillAndName(String name, String address, Pageable pageable){
      return employeeRepository.findEmployeesByNameAndAddress(name,address,pageable);
    }
    public Optional<Employee> fillName(String name){
        return employeeRepository.findByName(name);
    }

}
