package com.lmartino.samples.sendgreetings.domain;

import java.util.List;

public class GreetingService {
    private final EmployeeRepository employeeRepository;
    private final MessageSender messageSender;

    public GreetingService(EmployeeRepository employeeRepository, MessageSender messageSender) {
        this.employeeRepository = employeeRepository;
        this.messageSender = messageSender;
    }

    public void send() {
        List<Employee> employees = employeeRepository.getAllEmployees();

        for (Employee employee : employees) {
            messageSender.sendMessage(new Message());

        }


    }
}
