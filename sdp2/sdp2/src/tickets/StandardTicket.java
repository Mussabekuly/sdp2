package tickets;

public class StandardTicket implements Ticket {
    private static final int PRICE_TENGE = 3_000;

    private final String match;
    private final int seat;

    public StandardTicket(String match, int seat) {
        this.match = match;
        this.seat = seat;
    }

    @Override
    public String describe() {
        return "Standard | " + match + " | seat " + seat;
    }

    @Override
    public int priceTenge() {
        return PRICE_TENGE;
    }
}
