package story;

import java.time.Instant;

public class Story {
    private final String id;
    private final String userId;
    private final String content;
    private final Instant createdAt;
    private final Instant expireAt;

    public Story(String id, String userId, String content) {
        this.id = id;
        this.userId = userId;
        this.content = content;
        this.createdAt = Instant.now();
        this.expireAt = this.createdAt.plusSeconds(5);
    }

    public String getId() {
        return this.id;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getContent() {
        return this.content;
    }

    public Instant getExpiredAt() {
        return this.expireAt;
    }

    public boolean isExpired() {
        return Instant.now().isAfter(this.expireAt);
    }
}