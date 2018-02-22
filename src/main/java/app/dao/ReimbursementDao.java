package app.dao;

import app.models.Reimbursement;

import java.util.List;

public class ReimbursementDao extends Crud<Reimbursement> {

    @Override
    Reimbursement fetch(int id) {
        return null;
    }

    @Override
    List<Reimbursement> fetchAll(int limit, int offset) {
        return null;
    }

    @Override
    boolean create(Reimbursement reimbursement) {
        return false;
    }

    @Override
    boolean update(Reimbursement reimbursement) {
        return false;
    }

    @Override
    boolean delete(Reimbursement reimbursement) {
        return false;
    }

}
