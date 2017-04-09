package com.lmartino.samples.sendgreetings.adapter;

import com.lmartino.samples.sendgreetings.domain.Employee;
import com.lmartino.samples.sendgreetings.domain.EmployeeRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class FileEmployeeRepository implements EmployeeRepository {

    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd").withLocale(Locale.ITALY);
    private final String fileName;

    public FileEmployeeRepository(String fileName){
        this.fileName = fileName;
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<Employee>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            String str = in.readLine(); // skip header
            while ((str = in.readLine()) != null) {
                String[] employeeData = str.split(", ");
                final LocalDate birthday = LocalDate.parse(employeeData[0], dateTimeFormatter);
                final String firstName = employeeData[1];
                final String lastName = employeeData[2];
                final String email = employeeData[3];
                Employee employee = new Employee(birthday, firstName, lastName, email);
                employees.add(employee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employees;
    }
}
