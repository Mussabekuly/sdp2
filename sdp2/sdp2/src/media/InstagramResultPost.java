package media;

public class InstagramResultPost implements ResultPost {
    private static final String HASHTAGS = "#MediaBasket #FinalScore";

    @Override
    public String render(String home, String away, int homeScore, int awayScore) {
        return "🔥 " + home + " " + homeScore + ":" + awayScore + " " + away + "\n" + HASHTAGS;
    }
}
