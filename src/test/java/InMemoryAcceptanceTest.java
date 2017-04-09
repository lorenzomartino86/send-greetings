import com.lmartino.samples.sendgreetings.adapter.FileEmployeeRepository;
import com.lmartino.samples.sendgreetings.adapter.InMemoryEmployeeRepository;
import com.lmartino.samples.sendgreetings.adapter.SmtpSender;
import com.lmartino.samples.sendgreetings.domain.Employee;
import com.lmartino.samples.sendgreetings.domain.GreetingService;
import com.lmartino.samples.sendgreetings.domain.Message;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.LocalDate.of;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class InMemoryAcceptanceTest {

    private GreetingService greetingService;
    private final LocalDate testDate = of(2017, 4, 9);

    @Test
    public void sendNoGreetings() throws Exception {
        List<Employee> employees = new ArrayList<Employee>();
        Employee employee1 = generateEmployee(of(1980, 4, 8), "Luigi", "Adel", "ladel@test.com");
        Employee employee2 = generateEmployee(of(1981, 3, 11), "Luigi", "Adel", "ladel@test.com");
        employees.add(employee1);
        employees.add(employee2);

        final InMemoryEmployeeRepository employeeRepository = new InMemoryEmployeeRepository(employees);
        final SmtpSender messageSender = new SmtpSender("host", 25, "test@test.com");
        greetingService = new GreetingService(employeeRepository, messageSender, testDate);

        greetingService.send();

        final List<Message> sentMessages = greetingService.getSentMessages();

        assertThat(sentMessages.size(), is(0));
    }

    private Employee generateEmployee(LocalDate dateOfBirth, String firstName, String lastName, String email) {
        return new Employee(dateOfBirth, firstName, lastName, email);
    }

    @Test
    public void sendOneGreeting() throws Exception {
        List<Employee> employees = new ArrayList<Employee>();
        Employee employee1 = generateEmployee(of(1980, 4, 9), "Luigi", "Adel", "ladel@test.com");
        Employee employee2 = generateEmployee(of(1981, 3, 11), "Luigi", "Adel", "ladel@test.com");
        employees.add(employee1);
        employees.add(employee2);

        final InMemoryEmployeeRepository employeeRepository = new InMemoryEmployeeRepository(employees);
        final SmtpSender messageSender = new SmtpSender("host", 25, "test@test.com");
        greetingService = new GreetingService(employeeRepository, messageSender, testDate);

        greetingService.send();

        final List<Message> sentMessages = greetingService.getSentMessages();

        assertThat(sentMessages.size(), is(1));
    }
}