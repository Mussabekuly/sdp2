package media;

public class TelegramAnnouncement implements MatchAnnouncement {
    @Override
    public String render(String home, String away, String date) {
        return "<b>" + home + " vs " + away + "</b>\nTip-off: " + date;
    }
}
