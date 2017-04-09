import com.lmartino.samples.sendgreetings.domain.*;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;

import static java.time.LocalDate.*;

public class GreetingServiceTest {

    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    private final EmployeeRepository employeeRepository = context.mock(EmployeeRepository.class);
    private final MessageSender messageSender = context.mock(MessageSender.class);

    private final LocalDate testDate = of(2017, 4, 9);

    private GreetingService greetingService = new GreetingService(employeeRepository, messageSender, testDate);
    @Test
    public void sendNoGreeting() throws Exception {
        final Message message = new Message(null, null);
        final Employee employee = generateEmployee(of(2017, 4, 8));
        context.checking(new Expectations() {{
            oneOf(employeeRepository).getAllEmployees();
            will(returnValue(Arrays.asList(employee)));
        }});

        greetingService.send();
}

    @Test
    public void sendOneGreeting() throws Exception {
        final Message message = new Message(null, null);
        final Employee employee = generateEmployee(this.testDate);
        context.checking(new Expectations() {{
            oneOf(employeeRepository).getAllEmployees();
            will(returnValue(Arrays.asList(employee)));
            oneOf(messageSender).sendMessage(message);
        }});

        greetingService.send();
    }

    @Test
    public void sendMoreGreetings() throws Exception {
        final Employee employee = generateEmployee(testDate);
        final Message message = new Message(null, null);
        context.checking(new Expectations() {{
            oneOf(employeeRepository).getAllEmployees();
            will(returnValue(Arrays.asList(employee, employee)));

            allowing(messageSender).sendMessage(message);
        }});

        greetingService.send();
    }

    private Employee generateEmployee(LocalDate testDate) {
        return new Employee(testDate);
    }



}
