package by.itacademy.jd2.service;

import by.itacademy.jd2.dto.CityDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CityService {
    void addCity(CityDto cityDto);
    void editCity(CityDto cityDto);
    void deleteCity(Integer id);
    CityDto getCity(Integer id);
    List<CityDto> getAllCities();
    Page<CityDto> getPageCities(Pageable pageable);
}
