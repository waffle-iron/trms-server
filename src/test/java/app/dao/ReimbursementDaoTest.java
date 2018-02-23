package app.dao;

import app.models.Event;
import app.models.Reimbursement;
import app.models.User;
import app.seeds.SeedFactory;
import app.utilities.DaoUtility;
import app.utilities.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ReimbursementDaoTest extends TestCase {

    @Test
    public void fetch() {

    }

    @Test
    public void fetchAll() {
    }

    @Test
    public void create() {
        User u = SeedFactory.createDbUser();
        Reimbursement r = SeedFactory.createReimbursement(u.getId());
        r.setEmployeeId(u.getId());
        Event e = SeedFactory.createEvent();
        r.setEventId(e.getId());
        assertTrue(DaoUtility.getReimbursementDao().create(r) instanceof Reimbursement);

    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }
}