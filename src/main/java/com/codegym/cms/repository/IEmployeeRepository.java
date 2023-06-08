package com.codegym.cms.repository;

import com.codegym.cms.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IEmployeeRepository  extends PagingAndSortingRepository<Employee,Long> {
    Page<Employee>findEmployeesByNameAndAddress(String name, String address, Pageable pageable);
    @Query(value = "from Employee where name like : name")
    Optional<Employee> findByName(String name);
}
