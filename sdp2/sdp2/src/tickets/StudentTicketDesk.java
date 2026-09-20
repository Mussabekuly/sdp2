package tickets;

public class StudentTicketDesk extends TicketDesk {
    private final String studentId;

    public StudentTicketDesk(String studentId) {
        if (studentId == null || studentId.isBlank()) {
            throw new IllegalArgumentException("Student ID is required for a student ticket");
        }
        this.studentId = studentId;
    }

    @Override
    protected Ticket createTicket(String match, int seat) {
        return new StudentTicket(match, seat, studentId);
    }
}
