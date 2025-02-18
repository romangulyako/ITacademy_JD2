package by.itacademy.jd2.rest;

import by.itacademy.jd2.dto.CityDto;
import by.itacademy.jd2.service.CityService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cities-rest")
public class CityRestController {
    private final CityService cityService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CityDto> getCities() {
        return cityService.getCities();
    }

    @GetMapping(value = "/page")
    public Page<CityDto> getCitiesPage(@NotNull @RequestParam int page,
                                       @NotNull @RequestParam int size) {
        return cityService.findAll(page, size);
    }

    @PostMapping
    public CityDto createCity(@RequestBody CityDto cityDto) {
        return cityService.saveOrUpdate(cityDto);
    }
}
