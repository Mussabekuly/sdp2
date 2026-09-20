package tickets;

public class StandardTicketDesk extends TicketDesk {
    @Override
    protected Ticket createTicket(String match, int seat) {
        return new StandardTicket(match, seat);
    }
}
