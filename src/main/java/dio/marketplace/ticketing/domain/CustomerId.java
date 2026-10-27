package dio.marketplace.ticketing.domain;

import org.springframework.util.Assert;

import java.util.UUID;

public record CustomerId(UUID id) {
    public CustomerId {
        Assert.notNull(id, "ID must not be null!");
    }

    public CustomerId(String id) {
        this(UUID.fromString(id));
    }
}
