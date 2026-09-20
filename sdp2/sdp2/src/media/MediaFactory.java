package media;

/** Abstract Factory: one creation method per product in the family. */
public interface MediaFactory {
    MatchAnnouncement createAnnouncement();
    ResultPost createResultPost();
}
