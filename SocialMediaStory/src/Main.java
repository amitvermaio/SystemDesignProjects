import java.util.*;
import story.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Repository
        StoryRepository repository = new InMemoryStoryRepository();
        // Service
        StoryService service = new StoryService(repository);
        // Scheduler
        StoryCleanupScheduler scheduler = new StoryCleanupScheduler(repository);

        scheduler.start();

        Story story1 = service.createStory(
                "userId-1",
                "Hey, Friends this is my first story!!"
        );

        Story story2 = service.createStory(
                "userId-2",
                "Learning Something New!"
        );

        System.out.println("Stories created:\n");
        printStories(service.getUserStories("userId-1"));

        System.out.println("\nStory 1 expires at: "
                + story1.getExpiredAt());

        System.out.println("\nWaiting...");

        Thread.sleep(6000);

        System.out.println("\nActive stories:");
        printStories(service.getUserStories("userId-1"));

        scheduler.stop();
    }

    private static void printStories(List<Story> stories) {

        if (stories.isEmpty()) {
            System.out.println("No active stories");
            return;
        }

        for (Story story : stories) {
            System.out.println(
                    story.getId() + " -> " +
                            story.getContent()
            );
        }
    }
}
