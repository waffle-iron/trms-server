package app.dao;

import app.models.Event;
import app.models.Reimbursement;
import app.models.User;
import app.seeds.SeedFactory;
import app.utilities.DaoUtility;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReimbursementDaoTest {

    @Test
    public void fetch() {

    }

    @Test
    public void fetchAll() {
    }

    @Test
    public void create() {
        Reimbursement r = SeedFactory.createReimbursement();
        User u = SeedFactory.createUser();
        Event e = SeedFactory.createEvent();
        r.setEmployee(u);
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