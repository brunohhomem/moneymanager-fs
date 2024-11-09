package moneymanager.repository.activity;

import moneymanager.domain.activity.Activity;
import moneymanager.domain.gateway.ActivityGateway;
import moneymanager.repository.activity.jpa.ActivityJpaEntity;
import moneymanager.repository.activity.jpa.ActivityJpaRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ActivityJpaGateway implements ActivityGateway {
    private ActivityJpaRepository activityRepository;

    private ActivityJpaGateway(final ActivityJpaRepository aRepository) {
        this.activityRepository = aRepository;
    }

    public static ActivityJpaGateway build(final ActivityJpaRepository aRepository) {
        return new ActivityJpaGateway(aRepository);
    }

    @Override
    public void create(final Activity anActivity) {
        final var anActivityEntity = ActivityJpaEntity.from(anActivity);

        this.activityRepository.save(anActivityEntity);
    }

    @Override
    public void delete(final String anId) {
        this.activityRepository.deleteById(anId);
    }

    @Override
    public List<Activity> findAll() {
        final var aList = this.activityRepository.findAll();

        return aList.stream().map(ActivityJpaEntity::toModel).collect(Collectors.toList());
    }
}
