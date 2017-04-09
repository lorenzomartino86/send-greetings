import com.lmartino.samples.sendgreetings.adapter.FileEmployeeRepository;
import com.lmartino.samples.sendgreetings.adapter.SmtpSender;
import com.lmartino.samples.sendgreetings.domain.GreetingService;
import com.lmartino.samples.sendgreetings.domain.Message;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static java.time.LocalDate.of;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FileAcceptanceTest {

    private GreetingService greetingService;
    private final LocalDate testDate = of(2017, 4, 9);
    private final String no_birthday = "employee_data.txt";
    private final String one_birthday = "employee_data_with_birthday.txt";

    @Test
    public void sendNoGreetings() throws Exception {
        final FileEmployeeRepository employeeRepository = new FileEmployeeRepository(no_birthday);
        final SmtpSender messageSender = new SmtpSender("host", 25, "test@test.com");
        greetingService = new GreetingService(employeeRepository, messageSender, testDate);

        greetingService.send();

        final List<Message> sentMessages = greetingService.getSentMessages();

        assertThat(sentMessages.size(), is(0));
    }

    @Test
    public void sendOneGreeting() throws Exception {
        final FileEmployeeRepository employeeRepository = new FileEmployeeRepository(one_birthday);
        final SmtpSender messageSender = new SmtpSender("host", 25, "test@test.com");
        greetingService = new GreetingService(employeeRepository, messageSender, testDate);

        greetingService.send();

        final List<Message> sentMessages = greetingService.getSentMessages();

        assertThat(sentMessages.size(), is(1));
    }
}