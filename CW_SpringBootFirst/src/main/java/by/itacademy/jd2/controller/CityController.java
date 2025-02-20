package by.itacademy.jd2.controller;

import by.itacademy.jd2.feignClient.SimpleClient;
import by.itacademy.jd2.service.CityService;
import by.itacademy.jd2.service.CityServiceImpl;
import jakarta.validation.Valid;
import by.itacademy.jd2.dto.CityDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class CityController {
    private final CityService cityService;
    private final SimpleClient simpleClient;

    /*private List<CityDto> cities = Stream.of(
                    CityDto.builder()
                            .id(1)
                            .name("Minsk")
                            .location("Belarus")
                            .build(),
                    CityDto.builder()
                            .id(2)
                            .name("Moscow")
                            .location("Russia")
                            .build()
            )
            .collect(Collectors.toCollection(ArrayList::new));*/

    @GetMapping({"/", "/cities"})
    public String getCities(Model model) {
        //model.addAttribute("cities", simpleClient.getCities());
        model.addAttribute("cities",cityService.getCities());
        model.addAttribute("addCity", new CityDto());
        return "city";
    }

    @PostMapping("/city/add")
    public String addCity(@Valid @ModelAttribute("addCity") CityDto cityDto,
                          BindingResult bindingResult,
                          Model model) {
        if (!bindingResult.hasErrors()) {
            cityService.saveOrUpdate(cityDto);
            return "redirect:/cities";
        }

        model.addAttribute("cities", cityService.getCities());
        return "city";
    }
}
