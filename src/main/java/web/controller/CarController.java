package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web.model.Car;
import web.service.CarServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CarController {

    private final CarServiceImpl carService = new CarServiceImpl();

    @GetMapping(value = "/cars")
    public String cars(HttpServletRequest request, Model model) {
        List<Car> cars;
        try {
            int count = Integer.parseInt(request.getParameter("count"));
            cars = carService.getCars(count);

            model.addAttribute("cars", cars);
            return "cars";
        } catch (Exception e) {
            cars = carService.getCars(0);
            model.addAttribute("cars", cars);
            return "cars";
        }

    }
}
