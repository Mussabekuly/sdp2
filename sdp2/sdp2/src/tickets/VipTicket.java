package tickets;

public class VipTicket implements Ticket {
    private static final int PRICE_TENGE = 15_000;

    private final String match;
    private final int seat;

    public VipTicket(String match, int seat) {
        this.match = match;
        this.seat = seat;
    }

    @Override
    public String describe() {
        return "VIP (courtside + lounge) | " + match + " | seat " + seat;
    }

    @Override
    public int priceTenge() {
        return PRICE_TENGE;
    }
}
