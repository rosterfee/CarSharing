package ru.itis.javalab.repositories;

import ru.itis.javalab.models.Car;
import ru.itis.javalab.services.CarImagesService;
import ru.itis.javalab.utils.MyDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CarsRepositoryJdbcImpl implements CarsRepository {

    SimpleJdbcTemplate template;
    CarImagesService carImagesService;

    //language=sql
    private static final String SQL_SAVE_CAR = "insert into car (mark, model, price, powers, engine, " +
            "transmission, max_speed, racing, description) values (?, ?, ?, ?, ?, ?, ? ,?, ?)";

    //language=sql
    private static final String SQL_SELECT_ALL_CARS = "select * from car";

    //language=sql
    private static final String SQL_SELECT_CAR_ID_BY_NAME = "select * from car where concat(mark, ' ', model) = ?";

    //language=sql
    private static final String SQL_SELECT_CAR_BY_ID = "select * from car where id = ?";

    //language=sql
    private static final String SQL_SELECT_ALL_BY_LS_FROM_TO = "select * from car where powers >= ? and powers < ?";

    //language=sql
    private static final String SQL_SELECT_ALL_BY_LS_FROM = "select * from car where powers >= ?";

    //language=sql
    private static final String SQL_SELECT_ALL_BY_PRICE_FROM_TO = "select  * from car where price >= ? and price < ?";

    //language=sql
    private static final String SQL_SELECT_ALL_BY_PRICE_FROM = "select  * from car where price >= ?";

    //language=sql
    private static final String SQL_SELECT_ALL_BY_MARK = "select * from car where mark = ?";

    //language=sql
    private static final String SQL_SELECT_ALL_BY_EXCEPT_MARK = "select * from car where mark != (? or ? or ?)";

    //language=sql
    private static final String SQL_SELECT_ALL_BY_ENGINE_FROM_TO = "select * from car where engine >= ? and engine < ?";

    //language=sql
    private static final String SQL_SELECT_ALL_BY_ENGINE_FROM = "select * from car where engine >= ?";

    //language=sql
    private static final String SQL_SELECT_ALL_BY_BOX = "select * from car where transmission = ?";

    //language=sql
    private static final String SQL_GET_CAR_ID = "select * from car where mark = ? and model = ? and price = ? and " +
            "powers = ? and engine = ? and transmission = ? and max_speed = ? and description = ? and racing = ?";

    public CarsRepositoryJdbcImpl(MyDataSource dataSource, CarImagesService carImagesService) {
        template = new SimpleJdbcTemplate(dataSource);
        this.carImagesService = carImagesService;
    }

    private RowMapper<Car> carRowMapper = resultSet -> Car.builder()
            .id(resultSet.getLong("id"))
            .mark(resultSet.getString("mark"))
            .model(resultSet.getString("model"))
            .price(resultSet.getInt("price"))
            .powers(resultSet.getInt("powers"))
            .engine(resultSet.getDouble("engine"))
            .transmission(resultSet.getString("transmission"))
            .maxSpeed(resultSet.getInt("max_speed"))
            .racing(resultSet.getDouble("racing"))
            .description(resultSet.getString("description"))
            .photos(carImagesService.getAllByCarId(resultSet.getLong("id")))
                .build();

    @Override
    public List<Car> findAll() {
        return template.selectQuery(SQL_SELECT_ALL_CARS, carRowMapper);
    }

    @Override
    public Optional<Car> findById(Long id) {
        Car car = template.queryForObject(SQL_SELECT_CAR_BY_ID, carRowMapper, id);
        return Optional.ofNullable(car);
    }

    @Override
    public void save(Car entity) {
        template.update(SQL_SAVE_CAR, entity.getMark(), entity.getModel(), entity.getPrice(), entity.getPowers(),
                entity.getEngine(), entity.getTransmission(), entity.getMaxSpeed(), entity.getRacing(),
                entity.getDescription());
    }

    @Override
    public void update(Car entity) {

    }

    @Override
    public void delete(Car entity) {

    }

    @Override
    public Optional<Car> findCarByName(String carName) {
        Car car = template.queryForObject(SQL_SELECT_CAR_ID_BY_NAME, carRowMapper, carName);
        return Optional.ofNullable(car);
    }

    @Override
    public List<Car> findByLs(int from, int to) {
        return template.selectQuery(SQL_SELECT_ALL_BY_LS_FROM_TO, carRowMapper, from, to);
    }

    @Override
    public List<Car> findByLs(int from) {
        return template.selectQuery(SQL_SELECT_ALL_BY_LS_FROM, carRowMapper, from);
    }

    @Override
    public List<Car> findByPrice(int from, int to) {
        return template.selectQuery(SQL_SELECT_ALL_BY_PRICE_FROM_TO, carRowMapper, from, to);
    }

    @Override
    public List<Car> findByPrice(int from) {
        return template.selectQuery(SQL_SELECT_ALL_BY_PRICE_FROM, carRowMapper, from);
    }

    @Override
    public List<Car> findByMark(String mark) {
        return template.selectQuery(SQL_SELECT_ALL_BY_MARK, carRowMapper, mark);
    }

    @Override
    public List<Car> findByExceptMarks(String mark1, String mark2, String mark3) {
        return template.selectQuery(SQL_SELECT_ALL_BY_EXCEPT_MARK, carRowMapper, mark1, mark2, mark3);
    }

    @Override
    public List<Car> findByEngine(double from, double to) {
        return template.selectQuery(SQL_SELECT_ALL_BY_ENGINE_FROM_TO, carRowMapper, from, to);
    }

    @Override
    public List<Car> findByEngine(double from) {
        return template.selectQuery(SQL_SELECT_ALL_BY_ENGINE_FROM, carRowMapper, from);
    }

    @Override
    public List<Car> findByBox(String box) {
        return template.selectQuery(SQL_SELECT_ALL_BY_BOX, carRowMapper, box);
    }

    @Override
    public Optional<Car> findSuchCar(Car car) {
         Car dbCar = template.queryForObject(SQL_GET_CAR_ID, carRowMapper, car.getMark(), car.getModel(), car.getPrice(),
                car.getPowers(), car.getEngine(), car.getTransmission(), car.getMaxSpeed(), car.getDescription(),
                car.getRacing());
         return Optional.ofNullable(dbCar);
    }
}
