package by.itacademy.jd2.feignClient;

import by.itacademy.jd2.dto.CityDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "simple-feign", url = "http://localhost:8080")
public interface SimpleClient {
    @GetMapping("/cities-rest")
    List<CityDto> getCities();
}
