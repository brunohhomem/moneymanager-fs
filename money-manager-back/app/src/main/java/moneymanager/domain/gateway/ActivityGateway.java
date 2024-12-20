package moneymanager.domain.gateway;

import moneymanager.domain.activity.Activity;

import java.util.List;

public interface ActivityGateway {

    public void create(final Activity anActivity);

    public void delete(final String anId);

    public List<Activity> findAll();

}
