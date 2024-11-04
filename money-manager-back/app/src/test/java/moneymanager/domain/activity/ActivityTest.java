package moneymanager.domain.activity;


import moneymanager.domain.activity.type.Type;
import moneymanager.utils.InstantUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ActivityTest {

    @Test
    public void giverValidParams_whenBuildingNewActivity_thenReturnNewValidActivity() {
        final var aDescription = "A description";
        final var aValue = 3.55f;
        final var aDate = InstantUtils.now();
        final var aType = Type.ActivityType.REVENUE;

        final var anActivity = Activity.newActivity(aDate, aDescription, aValue, aType);

        assertNotNull(anActivity);
        assertNotNull(anActivity.getId());
        assertEquals(36, anActivity.getId().length());
        assertEquals(aDescription, anActivity.getDescription());
        assertEquals(aValue, anActivity.getValue(), 0.001);
        assertEquals(aDate, anActivity.getDate());
        assertEquals(aType, anActivity.getType());
        assertNotNull(anActivity.getCreatedAt());
        assertNotNull(anActivity.getUpdatedAt());

    }
}