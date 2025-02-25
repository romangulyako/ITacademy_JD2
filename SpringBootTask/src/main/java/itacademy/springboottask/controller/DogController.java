package itacademy.springboottask.controller;

import itacademy.springboottask.dto.DogDTO;
import itacademy.springboottask.dto.FilterData;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import itacademy.springboottask.service.DogService;

@Controller
@RequiredArgsConstructor
public class DogController {
    private final DogService dogService;

    @GetMapping("/dogs")
    public String getDogs(/*@RequestParam(defaultValue = "0") int page,
                          @RequestParam(defaultValue = "3") int size,*/
                          @ModelAttribute("filter") FilterData filter,
                          Model model) {
        Page<DogDTO> dogsPage = dogService.findAll(filter);
        model.addAttribute("dogs", dogsPage.getContent());
        model.addAttribute("page", filter.getPage());
        model.addAttribute("size", filter.getSize());
        model.addAttribute("totalPages", dogsPage.getTotalPages());
        model.addAttribute("filter", filter);
        return "dogs";
    }

    @GetMapping("/dogs/add")
    public String addDogPage(Model model) {
        model.addAttribute("dog", new DogDTO());
        return "save";
    }

    @GetMapping("/dogs/edit/{id}")
    public String editDogPage(@PathVariable Long id, Model model) {
        DogDTO dog = dogService.findById(id);
        model.addAttribute("dog", dog);
        return "save";
    }

    @PostMapping("/dogs/save")
    public String saveDog(@ModelAttribute("dog") DogDTO dogDTO) {
        dogService.saveOrUpdate(dogDTO);
        return "redirect:/dogs";
    }

    @PostMapping("/dogs/delete/{id}")
    public String deleteDog(@PathVariable Long id) {
        dogService.delete(id);
        return "redirect:/dogs";
    }
}
