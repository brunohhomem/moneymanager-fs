package moneymanager.service.dto;

import java.time.Instant;

public record InsertActivityInputDTO(Instant date, String description, float value, String type) {
}
