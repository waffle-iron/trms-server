package app.dao;

import app.models.Reimbursement;
import app.utilities.DateConverter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        String query = "INSERT INTO reimbursements (" +
                "employee_id, " +
                "event_id, " +
                "direct_supervisor_approved_on, " +
                "direct_supervisor_auto_approved, " +
                "department_head_approved_on, " +
                "department_head_auto_approved, " +
                "benco_approved_on, " +
                "denied_on, " +
                "denied_reason," +
                "created_on, " +
                "updated_on" +
                ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        reimbursement.updateTimeStamps();
        try (Connection c = connection()) {
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, reimbursement.getEmployee().getId());
            ps.setInt(2, reimbursement.getEvent().getId());
            ps.setTimestamp(3, DateConverter.dateToSQL(reimbursement.getDirectSupervisorApprovedOn()));
            ps.setBoolean(4, reimbursement.isDirectSupervisorAutoApproved());
            ps.setTimestamp(5, DateConverter.dateToSQL(reimbursement.getDepartmentHeadApprovedOn()));
            ps.setBoolean(6, reimbursement.isDepartmentHeadAutoApproved());
            ps.setTimestamp(7, DateConverter.dateToSQL(reimbursement.getBenCoApprovedOn()));
            ps.setTimestamp(8, DateConverter.dateToSQL(reimbursement.getDeniedOn()));
            ps.setString(9, reimbursement.getDeniedReason());
            ps.setTimestamp(10, DateConverter.dateToSQL(reimbursement.getDateCreated()));
            ps.setTimestamp(11, DateConverter.dateToSQL(reimbursement.getLastUpdated()));
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
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
