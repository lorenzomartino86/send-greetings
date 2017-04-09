import com.lmartino.samples.sendgreetings.adapter.FileEmployeeRepository;
import com.lmartino.samples.sendgreetings.adapter.SmtpSender;
import com.lmartino.samples.sendgreetings.domain.GreetingService;
import org.junit.Test;

import java.time.LocalDate;

import static java.time.LocalDate.of;

public class AcceptanceTest {

    private GreetingService greetingService;
    private final LocalDate testDate = of(2017, 4, 9);

    @Test
    public void sendNoGreetings() throws Exception {
        final FileEmployeeRepository employeeRepository = new FileEmployeeRepository();
        final SmtpSender messageSender = new SmtpSender();
        greetingService = new GreetingService(employeeRepository, messageSender, testDate);

        greetingService.send();
    }
}
