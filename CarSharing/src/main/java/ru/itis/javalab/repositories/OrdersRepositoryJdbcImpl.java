package ru.itis.javalab.repositories;

import ru.itis.javalab.models.Order;
import ru.itis.javalab.services.CarsService;
import ru.itis.javalab.services.UsersService;
import ru.itis.javalab.utils.MyDataSource;

import java.util.List;
import java.util.Optional;

public class OrdersRepositoryJdbcImpl implements OrdersRepository {

    SimpleJdbcTemplate template;
    UsersService usersService;
    CarsService carsService;

    private RowMapper<Order> orderRowMapper = resultSet -> Order.builder()
            .id(resultSet.getLong("id"))
            .user(usersService.getUserById(resultSet.getLong("account_id")).get())
            .car(carsService.getCarById(resultSet.getLong("car_id")).get())
            .date(resultSet.getString("order_date"))
            .active(resultSet.getString("active"))
            .address(resultSet.getString("address"))
            .timeOfOrderTaking(resultSet.getString("time_of_order_taking"))
            .price(resultSet.getInt("price"))
                .build();

    //language=sql
    private static final String SQL_SAVE_ORDER = "insert into orders (account_id, car_id, active) " +
            "values (?, ?, ?)";

    //language=sql
    private static final String SQL_SELECT_ACTIVE_ORDER_BY_USER_ID = "select * from orders where " +
            "account_id = ? and active = 'active'";

    //language=sql
    private static final String SQL_SQL_SELECT_ORDER_BY_ID = "select * from orders where id = ?";

    //language=sql
    private static final String SQL_DELETE_ORDER_BY_ID = "delete from orders where id = ?";

    //language=sql
    private static final String SQL_SET_ORDER_PRICE = "update orders set price = ? where id = ?";

    //language=sql
    private static final String SQL_SET_ORDER_ADDRESS = "update orders set address = ? where id = ?";

    //language=sql
    private static final String SQL_SET_TIME_OF_ORDER_TAKING = "update orders set time_of_order_taking = ? " +
            "where id = ?";

    //language=sql
    private static final String SQL_SET_ORDER_DATE = "update orders set order_date = ? where id = ?";

    //language=sql
    private static final String SQL_SET_ORDER_NON_ACTIVE = "update orders set active = 'non active' where id = ?";

    //language=sql
    private static final String SQL_SELECT_ALL_NON_ACTIVE_BY_USER_ID = "select * from orders where account_id = ? " +
            "and active = 'non active'";

    public OrdersRepositoryJdbcImpl(MyDataSource dataSource, UsersService usersService, CarsService carsService) {
        template = new SimpleJdbcTemplate(dataSource);
        this.usersService = usersService;
        this.carsService = carsService;
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

    }

    @Override
    public void save(long user_id, long car_id) {
        template.update(SQL_SAVE_ORDER, user_id, car_id, "active");
    }

    @Override
    public Optional<Order> findOrderById(long id) {
        Order order = template.queryForObject(SQL_SQL_SELECT_ORDER_BY_ID, orderRowMapper, id);
        return Optional.ofNullable(order);
    }

    @Override
    public void setOrderPrice(int price, long id) {
        template.update(SQL_SET_ORDER_PRICE, price, id);
    }

    @Override
    public void setOrderAddress(String address, long id) {
        template.update(SQL_SET_ORDER_ADDRESS, address, id);
    }

    @Override
    public void setTimeOfOrderTaking(String time, long id) {
        template.update(SQL_SET_TIME_OF_ORDER_TAKING, time, id);
    }

    @Override
    public void setOrderDate(String date, long id) {
        template.update(SQL_SET_ORDER_DATE, date, id);
    }

    @Override
    public void setOrderNonActive(long id) {
        template.update(SQL_SET_ORDER_NON_ACTIVE, id);
    }

    @Override
    public List<Order> finaAllNonActiveByUserId(long id) {
        return template.selectQuery(SQL_SELECT_ALL_NON_ACTIVE_BY_USER_ID, orderRowMapper, id);
    }

    @Override
    public void update(Order entity) {

    }

    @Override
    public void delete(Order entity) {
        template.update(SQL_DELETE_ORDER_BY_ID, entity.getId());
    }

    @Override
    public Optional<Order> findActiveOrderByUserId(long id) {
        Order order = template.queryForObject(SQL_SELECT_ACTIVE_ORDER_BY_USER_ID, orderRowMapper, id);
        return Optional.ofNullable(order);
    }
}
