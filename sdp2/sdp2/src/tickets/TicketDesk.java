package tickets;

/** Creator: declares the factory method and the shared selling flow. */
public abstract class TicketDesk {

    protected abstract Ticket createTicket(String match, int seat);

    public String sell(String match, int seat) {
        validate(match, seat);
        Ticket ticket = createTicket(match, seat);
        return ticket.describe() + " -> " + ticket.priceTenge() + " KZT";
    }

    private void validate(String match, int seat) {
        if (match == null || match.isBlank()) {
            throw new IllegalArgumentException("Match name must not be empty");
        }
        if (seat <= 0) {
            throw new IllegalArgumentException("Seat number must be positive: " + seat);
        }
    }
}
