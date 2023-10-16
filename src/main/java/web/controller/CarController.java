package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import web.service.CarService;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping()
    public String showList(Model model) {
        model.addAttribute("mycars", carService.getAllCars());
        return "cars";
    }

    @GetMapping("?count={count}")
    public String showCountList(@PathVariable("count") int count, Model model) {
        model.addAttribute("mycars2", carService.getCountCars(count));
        return "cars2";
    }


}
