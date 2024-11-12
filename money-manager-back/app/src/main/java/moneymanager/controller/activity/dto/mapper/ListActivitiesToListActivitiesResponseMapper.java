package moneymanager.controller.activity.dto.mapper;

import moneymanager.controller.activity.dto.ActivityDto;
import moneymanager.controller.activity.dto.ListActivitiesResponseDto;
import moneymanager.service.dto.ListActivitiesOutputDTO;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListActivitiesToListActivitiesResponseMapper implements
        Function<List<ListActivitiesOutputDTO>, ListActivitiesResponseDto> {

    public static ListActivitiesToListActivitiesResponseMapper build() {
        return new ListActivitiesToListActivitiesResponseMapper();
    }

    @Override
    public ListActivitiesResponseDto apply(List<ListActivitiesOutputDTO> input) {
        final var aList = input.stream().map(a -> new ActivityDto(
                a.id(),
                a.date(),
                a.description(),
                a.type(),
                a.value()
        )).collect(Collectors.toList());

        return new ListActivitiesResponseDto(aList);
    }
}
