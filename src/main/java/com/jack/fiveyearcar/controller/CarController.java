package com.jack.fiveyearcar.controller;

import com.jack.fiveyearcar.bean.Car;
import com.jack.fiveyearcar.bean.Dimension;
import com.jack.fiveyearcar.service.CarService;
import com.jack.fiveyearcar.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CarController {

    private static Logger logger= LoggerFactory.getLogger(CarController.class);

    @Autowired
    private CarService carService;

    @Autowired
    private Car car;

    @Autowired
    private Dimension dimension;

    @RequestMapping("/dimension")
    public ModelAndView toDimension(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("Dimension");
        return modelAndView;
    }

    @PostMapping("/car")
    public ModelAndView toCar(int xBorder,int yBorder){
        ModelAndView modelAndView=new ModelAndView();
        dimension.setxBorder(xBorder);
        dimension.setyBorder(yBorder);
        car.setxPosition(1);
        car.setyPosition(1);
        car.setOrientation("north");
        System.out.println(dimension.toString());
        modelAndView.setViewName("car");
        return modelAndView;
    }

    @GetMapping("/car/{command}")
    @ResponseBody
    public String getCar(@PathVariable("command") String command){
        String result=carService.move(command,car,dimension);
        logger.info(result);
        return result;
    }
}
