package moneymanager.domain.service.implementation;

import moneymanager.domain.activity.type.Type;
import moneymanager.domain.gateway.ActivityGateway;
import moneymanager.domain.service.ActivityService;
import moneymanager.domain.service.dto.InsertActivityInputDTO;
import moneymanager.domain.service.dto.InsertActivityOutputDTO;
import moneymanager.domain.service.dto.ListActivitiesOutputDTO;
import moneymanager.domain.service.dto.mapper.ActivityToInsertActivityOutputMapper;
import moneymanager.domain.service.dto.mapper.ActivityToListActivitiesOutputMapper;
import moneymanager.domain.service.dto.mapper.InsertActivityInputToActivityMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ActivityServiceImplementation implements ActivityService {

    private ActivityGateway activityGateway;

    private ActivityServiceImplementation(final ActivityGateway aGateway) {
        this.activityGateway = aGateway;
    }

    public static ActivityServiceImplementation build(final ActivityGateway aGateway) {
        return new ActivityServiceImplementation(aGateway);
    }

    @Override
    public InsertActivityOutputDTO insertActivity(final InsertActivityInputDTO anInput) {
        final var anActivity = InsertActivityInputToActivityMapper.build().apply(anInput);

        this.activityGateway.create(anActivity);

        return ActivityToInsertActivityOutputMapper.build().apply(anActivity);
    }

    @Override
    public void removeActivity(String anId) {
        this.activityGateway.delete(anId);
    }

    @Override
    public List<ListActivitiesOutputDTO> listActivities() {
        final var aList = this.activityGateway.findAll();

        return aList.stream()
                .map(a -> ActivityToListActivitiesOutputMapper.build().apply(a))
                .collect(Collectors.toList());
    }

    @Override
    public float calculateBalance() {
        final var aList = this.activityGateway.findAll();

        if (aList == null || aList.isEmpty()) {
            return 0;
        }

        return (float) aList.stream()
                .mapToDouble(a -> a.getType() == Type.ActivityType.REVENUE ? a.getValue() : -a.getValue())
                .sum();
    }
}
