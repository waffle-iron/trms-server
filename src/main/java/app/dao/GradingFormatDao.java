package app.dao;

import app.models.GradingFormat;

import java.sql.ResultSet;
import java.util.List;

public class GradingFormatDao extends Crud<GradingFormat> {

    @Override
    GradingFormat fetch(int id) {
        return null;
    }

    @Override
    List<GradingFormat> fetchAll(int limit, int offset) {
        return null;
    }

    @Override
    boolean create(GradingFormat gradingFormat) {
        return false;
    }

    @Override
    boolean update(GradingFormat gradingFormat) {
        return false;
    }

    @Override
    boolean delete(GradingFormat gradingFormat) {
        return false;
    }
}
