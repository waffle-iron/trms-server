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
        Reimbursement r = SeedFactory.createReimbursement();
        r.setEmployee(SeedFactory.createDbUser());
        Event e = SeedFactory.createEvent();
        e.setId(1);
        r.setEvent(e);
        assertTrue(DaoUtility.getReimbursementDao().create(r));

    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }
}