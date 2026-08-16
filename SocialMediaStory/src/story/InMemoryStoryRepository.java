package story;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryStoryRepository implements StoryRepository {
    private final Map<String, Story> stories = new ConcurrentHashMap<>();

    @Override
    public void save(Story story) {
        stories.put(story.getId(), story);
    }

    @Override
    public List<Story> getActiveStories(String userId) {
        List<Story> activeStories = new ArrayList<>();

        for (Story story : stories.values()) {
            if (story.getUserId().equals(userId) && !story.isExpired()) {
                activeStories.add(story);
            }
        }

        return activeStories;
    }

    @Override
    public void deleteExpiredStories() {
        for (Story story : stories.values()) {
            if (story.isExpired()) {
                stories.remove(story.getId());
            }
        }
    }
}