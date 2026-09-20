package media;

public class TelegramResultPost implements ResultPost {
    @Override
    public String render(String home, String away, int homeScore, int awayScore) {
        return "<b>Final:</b> " + home + " " + homeScore + " - " + awayScore + " " + away;
    }
}
