package media;

public class InstagramFactory implements MediaFactory {
    @Override
    public MatchAnnouncement createAnnouncement() {
        return new InstagramAnnouncement();
    }

    @Override
    public ResultPost createResultPost() {
        return new InstagramResultPost();
    }
}
