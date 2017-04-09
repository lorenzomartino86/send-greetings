package com.lmartino.samples.sendgreetings.adapter;

import com.lmartino.samples.sendgreetings.domain.Employee;
import com.lmartino.samples.sendgreetings.domain.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

public class FileEmployeeRepository implements EmployeeRepository {
    public List<Employee> getAllEmployees() {
        return new ArrayList<>();
    }
}
