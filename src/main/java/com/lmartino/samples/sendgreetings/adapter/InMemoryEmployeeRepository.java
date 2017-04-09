package com.lmartino.samples.sendgreetings.adapter;


import com.lmartino.samples.sendgreetings.domain.Employee;
import com.lmartino.samples.sendgreetings.domain.EmployeeRepository;

import java.util.List;

public class InMemoryEmployeeRepository implements EmployeeRepository{

    private List<Employee> employees;

    public InMemoryEmployeeRepository(List<Employee> employees){
        this.employees = employees;
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }
}
