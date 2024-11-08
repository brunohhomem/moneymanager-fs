package moneymanager.service;

import moneymanager.service.dto.InsertActivityInputDTO;
import moneymanager.service.dto.InsertActivityOutputDTO;
import moneymanager.service.dto.ListActivitiesOutputDTO;

import java.util.List;

public interface ActivityService {

    public InsertActivityOutputDTO insertActivity(final InsertActivityInputDTO anInput);

    public void removeActivity(final String anId);

    public List<ListActivitiesOutputDTO> listActivities();

    public float calculateBalance();
}
