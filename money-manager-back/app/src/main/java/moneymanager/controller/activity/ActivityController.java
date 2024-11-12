package moneymanager.controller.activity;

import moneymanager.controller.activity.dto.ListActivitiesResponseDto;
import moneymanager.controller.activity.dto.mapper.ListActivitiesToListActivitiesResponseMapper;
import moneymanager.repository.activity.ActivityJpaGateway;
import moneymanager.repository.activity.jpa.ActivityJpaRepository;
import moneymanager.service.implementation.ActivityServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activities")
public class ActivityController {

    @Autowired
    private ActivityJpaRepository activityRepository;

    @GetMapping
    public ResponseEntity<ListActivitiesResponseDto> listActivities() {
        final var aGateway = ActivityJpaGateway.build(activityRepository);

        final var aService = ActivityServiceImplementation.build(aGateway);

        final var aList = aService.listActivities();

        final var aResponse = ListActivitiesToListActivitiesResponseMapper.build().apply(aList);

        return ResponseEntity.ok().body(aResponse);
    }

}
