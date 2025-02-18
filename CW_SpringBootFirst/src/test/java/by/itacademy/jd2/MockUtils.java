package by.itacademy.jd2;

import by.itacademy.jd2.dto.CityDto;

import java.util.ArrayList;
import java.util.List;

import static by.itacademy.jd2.MockConstant.*;

public class MockUtils {
    public static List<CityDto> createCities() {
        List<CityDto> cities = new ArrayList<>();
        cities.add(createCity(CITY_NAME_1));
        cities.add(createCity(CITY_NAME_2));
        return cities;
    }

    private static CityDto createCity(String name) {
        return CityDto.builder().name(name).build();
    }
}
