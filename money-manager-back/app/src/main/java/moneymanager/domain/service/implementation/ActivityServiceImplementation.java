package moneymanager.domain.service.implementation;

import moneymanager.domain.gateway.ActivityGateway;
import moneymanager.domain.service.ActivityService;
import moneymanager.domain.service.dto.InsertActivityInputDTO;
import moneymanager.domain.service.dto.InsertActivityOutputDTO;
import moneymanager.domain.service.dto.ListActivitiesOutputDTO;
import moneymanager.domain.service.dto.mapper.ActivityToInsertActivityOutputMapper;
import moneymanager.domain.service.dto.mapper.InsertActivityInputToActivityMapper;

import java.util.List;

public class ActivityServiceImplementation implements ActivityService {

    private ActivityGateway activityGateway;

    private ActivityServiceImplementation(final ActivityGateway aGateway){
        this.activityGateway = aGateway;
    }

    public static ActivityServiceImplementation build(final ActivityGateway aGateway){
        return new ActivityServiceImplementation(aGateway) ;
    }

    @Override
    public InsertActivityOutputDTO insertActivity(InsertActivityInputDTO anInput) {
        final var anActivity = InsertActivityInputToActivityMapper.build().apply(anInput);

        this.activityGateway.create(anActivity);

        return ActivityToInsertActivityOutputMapper.build().apply(anActivity);
    }

    @Override
    public void removeActivity(String anId) {
        super.removeActivity(anId);
    }

    @Override
    public List<ListActivitiesOutputDTO> listActivities() {
        return super.listActivities();
    }

    @Override
    public float calculateBalance() {
        return super.calculateBalance();
    }
}
