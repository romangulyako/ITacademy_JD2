package by.itacademy.jd2.service;

import by.itacademy.jd2.dto.CityDto;
import by.itacademy.jd2.entity.CityEntity;
import by.itacademy.jd2.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;

    public void addCity(CityDto cityDto) {
        CityEntity cityEntity = CityEntity.builder()
                .name(cityDto.getName())
                .location(cityDto.getLocation())
                .build();
        cityRepository.save(cityEntity);
    }

    public void editCity(CityDto cityDto) {
        CityEntity cityEntity = cityRepository.findById(cityDto.getId()).orElse(null);
        if (cityEntity != null) {
            cityEntity.setName(cityDto.getName());
            cityEntity.setLocation(cityDto.getLocation());
            cityRepository.save(cityEntity);
        }
    }

    public void deleteCity(Integer id) {
        cityRepository.deleteById(id);
    }

    public CityDto getCity(Integer id) {
        CityEntity cityEntity = cityRepository.findById(id).orElse(null);
        if (cityEntity != null) {
            return CityDto.builder()
                    .id(cityEntity.getId())
                    .name(cityEntity.getName())
                    .location(cityEntity.getLocation())
                    .build();
        }

        return null;
    }

    public List<CityDto> getAllCities() {
        List<CityEntity> cities = cityRepository.findAll();
        return cities.stream().map(entity ->
                        CityDto.builder()
                                .id(entity.getId())
                                .name(entity.getName())
                                .location(entity.getLocation())
                                .build())
                .collect(Collectors.toList());
    }

    @Override
    public Page<CityDto> getPageCities(Pageable pageable) {
        return cityRepository.findAll(pageable).map(entity ->
                CityDto.builder()
                        .id(entity.getId())
                        .name(entity.getName())
                        .location(entity.getLocation())
                        .build());
    }
}
