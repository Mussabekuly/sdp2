import media.InstagramFactory;
import media.MediaFactory;
import media.PublicationService;
import media.TelegramFactory;
import tickets.StandardTicketDesk;
import tickets.StudentTicketDesk;
import tickets.TicketDesk;
import tickets.VipTicketDesk;

public class Main {
    private static final String MATCH = "Astana Tigers vs Almaty Wolves";

    public static void main(String[] args) {
        System.out.println("=== Part A: Factory Method ===");
        TicketDesk[] desks = {
                new StandardTicketDesk(),
                new VipTicketDesk(),
                new StudentTicketDesk("240101")
        };
        for (TicketDesk desk : desks) {
            System.out.println(desk.sell(MATCH, 12));
        }
        try {
            new StudentTicketDesk(" ");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n=== Part B: Abstract Factory ===");
        MediaFactory[] factories = {new TelegramFactory(), new InstagramFactory()};
        for (MediaFactory factory : factories) {
            PublicationService service = new PublicationService(factory);
            System.out.println("--- " + factory.getClass().getSimpleName() + " ---");
            service.publishBefore("Astana Tigers", "Almaty Wolves", "21.09 19:00").forEach(System.out::println);
            service.publishAfter("Astana Tigers", "Almaty Wolves", 88, 81).forEach(System.out::println);
        }
    }
}
