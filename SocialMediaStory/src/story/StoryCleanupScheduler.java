package story;

import java.util.concurrent.*;

public class StoryCleanupScheduler {
    private final StoryRepository repository;
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    public StoryCleanupScheduler(StoryRepository repository) {
        this.repository = repository;
    }

    public void start() {
        scheduler.scheduleAtFixedRate(
                () -> repository.deleteExpiredStories(),
                1,
                1,
                TimeUnit.MINUTES
        );
    }

    public void stop() {
        scheduler.shutdown();
    }
}