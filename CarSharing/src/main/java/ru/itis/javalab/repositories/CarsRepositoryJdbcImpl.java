package ru.itis.javalab.repositories;

import ru.itis.javalab.models.Car;
import ru.itis.javalab.services.CarImagesService;
import ru.itis.javalab.utils.MyDataSource;

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
    public void deleteById(Long id) {

    }

    @Override
    public void delete(Car entity) {

    }

    @Override
    public Optional<Car> findCarByName(String carName) {
        Car car = template.queryForObject(SQL_SELECT_CAR_ID_BY_NAME, carRowMapper, carName);
        return Optional.ofNullable(car);
    }
}
