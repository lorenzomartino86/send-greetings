package com.lmartino.samples.sendgreetings.domain;

import java.time.LocalDate;
import java.util.List;

public class GreetingService {
    private final EmployeeRepository employeeRepository;
    private final MessageSender messageSender;
    private final LocalDate today;

    public GreetingService(EmployeeRepository employeeRepository, MessageSender messageSender, LocalDate today) {
        this.employeeRepository = employeeRepository;
        this.messageSender = messageSender;
        this.today = today;
    }

    public void send() {
        List<Employee> employees = employeeRepository.getAllEmployees();
        for (Employee employee : employees) {
            if (hasBirthday(employee)){
                final Message message = new Message(employee.getFirstName(), employee.getLastName());
                messageSender.sendMessage(message);
            }

        }


    }

    private boolean hasBirthday(Employee employee) {
        return today.equals(employee.getBirthday());
    }
}
