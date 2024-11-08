package moneymanager.service.dto.mapper;

import moneymanager.domain.activity.Activity;
import moneymanager.domain.activity.type.Type;
import moneymanager.service.dto.InsertActivityInputDTO;
import moneymanager.service.exception.ServiceException;

import java.util.function.Function;

public class InsertActivityInputToActivityMapper implements Function<InsertActivityInputDTO, Activity> {

    public static InsertActivityInputToActivityMapper build() {
        return new InsertActivityInputToActivityMapper();
    }

    @Override
    public Activity apply(final InsertActivityInputDTO input) {

        if (Type.ActivityType.REVENUE.equals(Type.ActivityType.valueOf(input.type()))) {
            return Activity.newActivity(input.date(),
                    input.description(),
                    input.value(),
                    Type.ActivityType.REVENUE);
        }

        if (Type.ActivityType.EXPENSE.equals(Type.ActivityType.valueOf(input.type()))) {
            return Activity.newActivity(input.date(),
                    input.description(),
                    input.value(),
                    Type.ActivityType.EXPENSE);
        }

        throw new ServiceException("Invalid activity type");
    }
}
