package story;

import java.util.List;
import java.util.UUID;

public class StoryService {

    private final StoryRepository repository;

    public StoryService(StoryRepository repository) {
        this.repository = repository;
    }

    public Story createStory(String userId, String content) {
        Story newStory = new Story(
          UUID.randomUUID().toString(),
          userId,
          content
        );

        repository.save(newStory);

        return newStory;
    }

    public List<Story> getUserStories(String userId) {
        return repository.getActiveStories(userId);
    }
}