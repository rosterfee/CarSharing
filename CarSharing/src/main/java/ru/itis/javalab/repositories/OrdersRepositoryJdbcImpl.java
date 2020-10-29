package ru.itis.javalab.repositories;

import ru.itis.javalab.models.Order;
import ru.itis.javalab.utils.MyDataSource;

import java.util.List;
import java.util.Optional;

public class OrdersRepositoryJdbcImpl implements OrdersRepository {

    SimpleJdbcTemplate template;

    private RowMapper<Order> orderRowMapper = resultSet -> Order.builder()
            .id(resultSet.getLong("id"))
            .userId(resultSet.getLong("user_id"))
            .carId(resultSet.getLong("car_id"))
            .date(resultSet.getString("order_date"))
            .active(resultSet.getString("active"))
                .build();

    //language=sql
    private static final String SQL_SAVE_ORDER = "insert into orders (account_id, car_id, active, order_date) " +
            "values (?, ?, ?, ?)";

    public OrdersRepositoryJdbcImpl(MyDataSource dataSource) {
        template = new SimpleJdbcTemplate(dataSource);
    }

    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public Optional<Order> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Order entity) {
        template.update(SQL_SAVE_ORDER, entity.getUserId(), entity.getCarId(), entity.getActive(),
                 entity.getDate());
    }

    @Override
    public void update(Order entity) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void delete(Order entity) {

    }
}
