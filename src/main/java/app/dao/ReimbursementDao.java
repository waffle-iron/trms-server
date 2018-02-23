package app.dao;

import app.models.Reimbursement;
import app.utilities.DateConverter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReimbursementDao extends Crud<Reimbursement> {

    @Override
    public Reimbursement fetch(int id) {
        Reimbursement reimbursement = new Reimbursement();
        try (Connection c = connection()) {
            String query = "SELECT * FROM reimbursements WHERE id = ?";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                reimbursement.setId(rs.getInt("id"));
                reimbursement.setEmployeeId(rs.getInt("employee_id"));
                reimbursement.setEventId(rs.getInt("event_id"));
                reimbursement.setDirectSupervisorApprovedOn(DateConverter.dateToLocalDateTime(rs.getTimestamp("direct_supervisor_approved_on")));
                reimbursement.setDirectSupervisorAutoApproved(rs.getBoolean("direct_supervisor_auto_approved"));
                reimbursement.setDepartmentHeadApprovedOn(DateConverter.dateToLocalDateTime(rs.getTimestamp("department_head_approved_on")));
                reimbursement.setDepartmentHeadAutoApproved(rs.getBoolean("department_head_auto_approved"));
                reimbursement.setBenCoApprovedOn(DateConverter.dateToLocalDateTime(rs.getTimestamp("benco_approved_on")));
                reimbursement.setDeniedOn(DateConverter.dateToLocalDateTime(rs.getTimestamp("denied_on")));
                reimbursement.setDeniedReason(rs.getString("denied_reason"));
                reimbursement.setDateCreated(DateConverter.dateToLocalDateTime(rs.getTimestamp("created_on")));
                reimbursement.setLastUpdated(DateConverter.dateToLocalDateTime(rs.getTimestamp("updated_on")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Reimbursement> fetchAll(int limit, int offset) {
        List<Reimbursement> reimbursements = new ArrayList<>();
        try (Connection c = connection()) {
            String query = "SELECT * FROM reimbursements LIMIT ? OFFSET ?";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, limit);
            ps.setInt(2, offset);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Reimbursement reimbursement = new Reimbursement();
                reimbursement.setId(rs.getInt("id"));
                reimbursement.setEmployeeId(rs.getInt("employee_id"));
                reimbursement.setEventId(rs.getInt("event_id"));
                reimbursement.setDirectSupervisorApprovedOn(DateConverter.dateToLocalDateTime(rs.getTimestamp("direct_supervisor_approved_on")));
                reimbursement.setDirectSupervisorAutoApproved(rs.getBoolean("direct_supervisor_auto_approved"));
                reimbursement.setDepartmentHeadApprovedOn(DateConverter.dateToLocalDateTime(rs.getTimestamp("department_head_approved_on")));
                reimbursement.setDepartmentHeadAutoApproved(rs.getBoolean("department_head_auto_approved"));
                reimbursement.setBenCoApprovedOn(DateConverter.dateToLocalDateTime(rs.getTimestamp("benco_approved_on")));
                reimbursement.setDeniedOn(DateConverter.dateToLocalDateTime(rs.getTimestamp("denied_on")));
                reimbursement.setDeniedReason(rs.getString("denied_reason"));
                reimbursement.setDateCreated(DateConverter.dateToLocalDateTime(rs.getTimestamp("created_on")));
                reimbursement.setLastUpdated(DateConverter.dateToLocalDateTime(rs.getTimestamp("updated_on")));
                reimbursements.add(reimbursement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reimbursements;
    }

    @Override
    public Reimbursement create(Reimbursement reimbursement) {
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
            ps.setInt(1, reimbursement.getEmployeeId());
            ps.setInt(2, reimbursement.getEventId());
            ps.setTimestamp(3, DateConverter.dateToSQL(reimbursement.getDirectSupervisorApprovedOn()));
            ps.setBoolean(4, reimbursement.isDirectSupervisorAutoApproved());
            ps.setTimestamp(5, DateConverter.dateToSQL(reimbursement.getDepartmentHeadApprovedOn()));
            ps.setBoolean(6, reimbursement.isDepartmentHeadAutoApproved());
            ps.setTimestamp(7, DateConverter.dateToSQL(reimbursement.getBenCoApprovedOn()));
            ps.setTimestamp(8, DateConverter.dateToSQL(reimbursement.getDeniedOn()));
            ps.setString(9, reimbursement.getDeniedReason());
            ps.setTimestamp(10, DateConverter.dateToSQL(reimbursement.getDateCreated()));
            ps.setTimestamp(11, DateConverter.dateToSQL(reimbursement.getLastUpdated()));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                reimbursement.setId(rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reimbursement;
    }

    @Override
    public boolean update(Reimbursement reimbursement) {
        reimbursement.updateTimeStamps();
        try (Connection c = connection()) {
            String query = "UPDATE reimbursements " +
                    "SET employee_id = ?, " +
                    "event_id = ?, " +
                    "direct_supervisor_approved_on = ?, " +
                    "direct_supervisor_auto_approved = ?, " +
                    "department_head_approved_on = ?, " +
                    "department_head_auto_approved = ?, " +
                    "benco_approved_on = ?, " +
                    "denied_on = ?, " +
                    "denied_reason = ?, " +
                    "updated_on = ? WHERE id = ?";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, reimbursement.getEmployeeId());
            ps.setInt(2, reimbursement.getEventId());
            ps.setTimestamp(3, DateConverter.dateToSQL(reimbursement.getDirectSupervisorApprovedOn()));
            ps.setBoolean(4, reimbursement.isDirectSupervisorAutoApproved());
            ps.setTimestamp(5, DateConverter.dateToSQL(reimbursement.getDepartmentHeadApprovedOn()));
            ps.setBoolean(6, reimbursement.isDepartmentHeadAutoApproved());
            ps.setTimestamp(7, DateConverter.dateToSQL(reimbursement.getBenCoApprovedOn()));
            ps.setTimestamp(8, DateConverter.dateToSQL(reimbursement.getDeniedOn()));
            ps.setString(9, reimbursement.getDeniedReason());
            ps.setTimestamp(10, DateConverter.dateToSQL(reimbursement.getLastUpdated()));
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Reimbursement reimbursement) {
        try (Connection c = connection()) {
            String query = "DELETE FROM reimbursements WHERE id = ?";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, reimbursement.getId());
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
