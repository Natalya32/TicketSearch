package ru.netology.javaqa.javaqamvn;

public class Ticket implements Comparable<Ticket> {
    protected int id;
    protected int cost;

    public String getFrom() {
        return from;
    }

    protected String from;

    public String getTo() {
        return to;
    }

    protected String to;
    protected int travelTime;

    public int getId() {
        return id;
    }

    public Ticket (int id, int cost, String from, String to, int travelTime) {
        this.id = id;
        this.cost = cost;
        this.from = from;
        this.to = to;
        this.travelTime = travelTime;
    }


    @Override
    public int compareTo(Ticket o) {
        if (this.cost < o.cost) {
            return -1;
        } else if (this.cost > o.cost) {
            return 1;
        } else {
            return 0;
        }
    }
}