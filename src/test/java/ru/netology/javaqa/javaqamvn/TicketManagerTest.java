package ru.netology.javaqa.javaqamvn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketManagerTest {

    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    Ticket ticket1 = new Ticket(5, 2500, "KUF", "MOW", 90);
    Ticket ticket2 = new Ticket(4, 3000, "MOW", "EGO", 65);
    Ticket ticket3 = new Ticket(8, 1500, "MOW", "EGO", 65);
    Ticket ticket4 = new Ticket(9, 8000, "OGZ", "DME", 300);
    Ticket ticket5 = new Ticket(2, 3500, "LED", "MOW", 120);
    Ticket ticket6 = new Ticket(7, 8000, "LED", "GOJ", 140);


    @Test
    public void shouldFindByAndSort() {
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.add(ticket6);

        Ticket[] actual = manager.findBy("MOW", "EGO");
        Ticket[] expected = {ticket3, ticket2};

        Assertions.assertArrayEquals(actual, expected);

    }

        @Test
        public void shouldFindByOneMatch(){
            repo.add(ticket1);
            repo.add(ticket2);
            repo.add(ticket3);
            repo.add(ticket4);
            repo.add(ticket5);
            repo.add(ticket6);

            Ticket[] actual = manager.findBy("LED", "GOJ");
            Ticket[] expected = {ticket6};

            Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldFindByNotMath() {
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.add(ticket6);

        Ticket[] actual = manager.findBy("LED", "EGO");
        Ticket[] expected = new Ticket[0];

        Assertions.assertArrayEquals(actual, expected);

    }

}
