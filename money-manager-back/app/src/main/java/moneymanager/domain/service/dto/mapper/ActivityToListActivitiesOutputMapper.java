package moneymanager.domain.service.dto.mapper;

import moneymanager.domain.activity.Activity;
import moneymanager.domain.service.dto.ListActivitiesOutputDTO;

import java.util.function.Function;

public class ActivityToListActivitiesOutputMapper implements Function<Activity, ListActivitiesOutputDTO> {

    public static ActivityToListActivitiesOutputMapper build() {
        return new ActivityToListActivitiesOutputMapper();
    }

    @Override
    public ListActivitiesOutputDTO apply(final Activity input) {
        return new ListActivitiesOutputDTO(
                input.getId(),
                input.getDate(),
                input.getDescription(),
                input.getValue(),
                input.getType().getValue(),
                input.getCreatedAt(),
                input.getUpdatedAt());
    }
}
