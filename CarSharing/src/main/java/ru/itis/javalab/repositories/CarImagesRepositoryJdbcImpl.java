package ru.itis.javalab.repositories;

import ru.itis.javalab.models.CarImage;
import ru.itis.javalab.utils.MyDataSource;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

public class CarImagesRepositoryJdbcImpl implements CarImagesRepository {

    SimpleJdbcTemplate template;

    private RowMapper<CarImage> carImageRowMapper = resultSet -> CarImage.builder()
            .id(resultSet.getLong("id"))
            .image(resultSet.getString("image"))
            .car_id(resultSet.getLong("car_id"))
                .build();

    //language=sql
    private static final String SQL_SELECT_ALL_IMAGES_BY_CAR_ID = "select * from car_image where car_id = ?";

    //language=sql
    private static final String SQL_SAVE_CAR_IMAGE = "insert into car_image (image, car_id) values (?, ?)";

    public CarImagesRepositoryJdbcImpl(MyDataSource dataSource) {
        this.template = new SimpleJdbcTemplate(dataSource);
    }

    @Override
    public List<CarImage> findAll() {
        return null;
    }

    @Override
    public Optional<CarImage> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(CarImage entity) {

    }

    @Override
    public void save(InputStream inputStream, long car_id) {
        template.uploadImage(inputStream, SQL_SAVE_CAR_IMAGE, car_id);
    }

    @Override
    public void update(CarImage entity) {

    }

    @Override
    public void delete(CarImage entity) {

    }

    @Override
    public List<CarImage> findAllByCarId(long carId) {
        return template.selectQuery(SQL_SELECT_ALL_IMAGES_BY_CAR_ID, carImageRowMapper, carId);
    }
}
