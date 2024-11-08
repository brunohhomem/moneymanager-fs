package moneymanager.service.dto;

import java.time.Instant;

public record InsertActivityOutputDTO(String id,
          Instant date,
          String description,
          float value,
          String type,
          Instant createdAt,
          Instant updatedAt) {
}