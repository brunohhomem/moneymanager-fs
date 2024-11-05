package moneymanager.domain.service.dto;

import java.time.Instant;

public record ListActivitiesOutputDTO(
        String id, Instant date, String description, float value, String type
) {
}
