package story;

import java.util.List;

public interface StoryRepository {
    void save(Story story);

    List<Story> getActiveStories(String userId);

    void deleteExpiredStories();
}