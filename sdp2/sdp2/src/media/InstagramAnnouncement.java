package media;

public class InstagramAnnouncement implements MatchAnnouncement {
    private static final String HASHTAGS = "#MediaBasket #Qazaqstan";

    @Override
    public String render(String home, String away, String date) {
        return "🏀 " + home + " vs " + away + " — " + date + "\n" + HASHTAGS;
    }
}
