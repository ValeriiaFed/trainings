package com.epam.spring.core.movie_theater_manager.app;

import asg.cliche.Command;
import asg.cliche.Shell;
import asg.cliche.ShellDependent;
import asg.cliche.ShellFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class App implements ShellDependent {

    private UserOperations userOperations;
    private EventOperations eventOperations;
    private BookingOperations bookingOperations;

    @Command
    public void userOperations() throws IOException {
        if (userOperations == null) {
            ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
            userOperations = (UserOperations) ctx.getBean("userOperations");
        }
        ShellFactory.createSubshell("userOperations", theShell, "userOperations", userOperations)
                .commandLoop();
    }

    @Command
    public void eventOperations() throws IOException {
        if (eventOperations == null) {
            ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
            eventOperations = (EventOperations) ctx.getBean("eventOperations");
        }
        ShellFactory.createSubshell("eventOperations", theShell, "eventOperations", eventOperations)
                .commandLoop();
    }

    @Command
    public void bookingOperations() throws IOException {
        if (bookingOperations == null) {
            ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
            bookingOperations = (BookingOperations) ctx.getBean("bookingOperations");
        }
        ShellFactory.createSubshell("bookingOperations", theShell, "bookingOperations", bookingOperations)
                .commandLoop();
    }

    public static void main(String[] args) throws IOException {
        ShellFactory.createConsoleShell("movie_manager", "type '?l' to see the list of available commands", new App())
                .commandLoop();
    }

    private Shell theShell;
    public void cliSetShell(Shell theShell) {
        this.theShell = theShell;
    }
}
