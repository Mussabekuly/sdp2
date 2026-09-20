package tickets;

public class StudentTicket implements Ticket {
    private static final int PRICE_TENGE = 1_000;

    private final String match;
    private final int seat;
    private final String studentId;

    public StudentTicket(String match, int seat, String studentId) {
        this.match = match;
        this.seat = seat;
        this.studentId = studentId;
    }

    @Override
    public String describe() {
        return "Student (ID " + studentId + ") | " + match + " | seat " + seat;
    }

    @Override
    public int priceTenge() {
        return PRICE_TENGE;
    }
}
