package by.itacademy.jd2.service;

import by.itacademy.jd2.dto.CityDto;
import by.itacademy.jd2.entity.CityEntity;
import by.itacademy.jd2.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    @Override
    public CityDto saveOrUpdate(CityDto cityDto) {
        CityEntity cityEntity = CityEntity.builder()
                .name(cityDto.getName())
                .location(cityDto.getLocation())
                .build();
        cityRepository.save(cityEntity);

        return CityDto.builder()
                .id(cityEntity.getId())
                .name(cityEntity.getName())
                .location(cityEntity.getLocation())
                .build();
    }

    @Override
    public void deleteCity(Integer id) {
        cityRepository.deleteById(id);
    }

    @Override
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

    @Override
    public List<CityDto> getCities() {
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

    @Override
    public Page<CityDto> findAll(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        return cityRepository.findAll(pageRequest)
                .map(entity -> CityDto.builder()
                        .id(entity.getId())
                        .name(entity.getName())
                        .location(entity.getLocation())
                        .build());
    }
}
