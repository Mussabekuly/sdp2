package tickets;

public class VipTicketDesk extends TicketDesk {
    @Override
    protected Ticket createTicket(String match, int seat) {
        return new VipTicket(match, seat);
    }
}
