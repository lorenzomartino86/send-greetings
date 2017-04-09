import com.lmartino.samples.sendgreetings.domain.*;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import java.util.Arrays;

public class GreetingServiceTest {

    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    private final EmployeeRepository employeeRepository = context.mock(EmployeeRepository.class);
    private final MessageSender messageSender = context.mock(MessageSender.class);

    private GreetingService greetingService = new GreetingService(employeeRepository, messageSender);

    @Test
    public void sendOneGreeting() throws Exception {
        final Message message = new Message();
        final Employee employee = new Employee();
        context.checking(new Expectations() {{
            oneOf(employeeRepository).getAllEmployees();
            will(returnValue(Arrays.asList(employee)));
            oneOf(messageSender).sendMessage(message);
        }});

        greetingService.send();
    }

    @Test
    public void sendMoreGreetings() throws Exception {
        context.checking(new Expectations() {{
            oneOf(employeeRepository).getAllEmployees();
            will(returnValue(Arrays.asList(new Employee(), new Employee())));
            allowing(messageSender).sendMessage(new Message());
        }});

        greetingService.send();
    }



}
