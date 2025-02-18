package by.itacademy.jd2.service;

import by.itacademy.jd2.dto.CityDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CityService {
    CityDto saveOrUpdate(CityDto cityDto);
    void deleteCity(Integer id);
    CityDto getCity(Integer id);
    List<CityDto> getCities();
    Page<CityDto> getPageCities(Pageable pageable);
    Page<CityDto> findAll(int pageNumber, int pageSize);
}
