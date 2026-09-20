package media;

import java.util.List;

/** Client: knows only MediaFactory and the product interfaces. */
public class PublicationService {
    private final MatchAnnouncement announcement;
    private final ResultPost resultPost;

    public PublicationService(MediaFactory factory) {
        this.announcement = factory.createAnnouncement();
        this.resultPost = factory.createResultPost();
    }

    public List<String> publishBefore(String home, String away, String date) {
        return List.of(announcement.render(home, away, date));
    }

    public List<String> publishAfter(String home, String away, int homeScore, int awayScore) {
        if (homeScore < 0 || awayScore < 0) {
            throw new IllegalArgumentException("Score must not be negative");
        }
        return List.of(resultPost.render(home, away, homeScore, awayScore));
    }
}
