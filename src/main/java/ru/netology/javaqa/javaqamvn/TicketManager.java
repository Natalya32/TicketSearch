package ru.netology.javaqa.javaqamvn;

import java.util.Arrays;

public class TicketManager {
    private TicketRepository repo;

    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }


    public Ticket[] findBy(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.getTickets()) {
            if (matchesFrom (ticket, from) && matchesTo (ticket, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public boolean matchesFrom(Ticket ticket, String search) {
        if (ticket.getFrom().contains(search)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean matchesTo(Ticket ticket, String search) {
        if (ticket.getTo().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}
