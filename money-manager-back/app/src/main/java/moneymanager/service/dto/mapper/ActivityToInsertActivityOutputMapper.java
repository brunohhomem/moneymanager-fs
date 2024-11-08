package moneymanager.service.dto.mapper;

import moneymanager.domain.activity.Activity;
import moneymanager.service.dto.InsertActivityOutputDTO;

import java.util.function.Function;

public class ActivityToInsertActivityOutputMapper implements Function<Activity, InsertActivityOutputDTO> {

    public static ActivityToInsertActivityOutputMapper build() {
        return new ActivityToInsertActivityOutputMapper();
    }

    @Override
    public InsertActivityOutputDTO apply(final Activity input) {
        return new InsertActivityOutputDTO(input.getId(),
                input.getDate(),
                input.getDescription(),
                input.getValue(),
                input.getType().getValue(),
                input.getCreatedAt(),
                input.getUpdatedAt());
    }
}
