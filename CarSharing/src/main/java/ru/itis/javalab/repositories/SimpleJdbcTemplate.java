package ru.itis.javalab.repositories;

import org.apache.commons.io.IOUtils;
import ru.itis.javalab.utils.MyDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class SimpleJdbcTemplate {

    private MyDataSource dataSource;

    public SimpleJdbcTemplate(MyDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public ResultSet query(String sql, Object ... args) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            if (args != null) {
                for (int i = 0; i < args.length; i++) {
                    preparedStatement.setObject(i + 1, args[i]);
                }
            }

            return preparedStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ignore) { }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ignore) { }
            }
        }
        return null;
    }

    public <T> List<T> selectQuery(String sql, RowMapper<T> rowMapper, Object ... args) {

        ResultSet resultSet = null;

        try {
            resultSet = query(sql, args);
            List<T> resultList = new ArrayList<>();
            while (resultSet.next()) {
                resultList.add(rowMapper.mapRow(resultSet));
            }

            return resultList;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ignore) { }
            }
        }

        return null;
    }

    public <T> T queryForObject(String sql, RowMapper<T> rowMapper, Object ... args) {

        List<T> list = selectQuery(sql, rowMapper, args);

        if (list.size() == 1) {
            return list.get(0);
        }
        else if (list.size() == 0) {
            return null;
        }
        else throw new IllegalStateException();
    }

    public void update(String sql, Object ... args) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            if (args != null) {
                for (int i = 0; i < args.length; i++) {
                    preparedStatement.setObject(i + 1, args[i]);
                }
            }

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ignore) { }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ignore) { }
            }
        }
    }

    public void uploadImage(InputStream inputStream, String sql, Object ... args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setObject(1, "data:image/png;base64," +
                    Base64.getEncoder().encodeToString(IOUtils.toByteArray(inputStream)));
            preparedStatement.setObject(2, args[0]);

            preparedStatement.executeUpdate();

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ignore) { }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ignore) { }
            }
        }
    }
}
