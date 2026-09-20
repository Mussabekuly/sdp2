package media;

public class TelegramFactory implements MediaFactory {
    @Override
    public MatchAnnouncement createAnnouncement() {
        return new TelegramAnnouncement();
    }

    @Override
    public ResultPost createResultPost() {
        return new TelegramResultPost();
    }
}
