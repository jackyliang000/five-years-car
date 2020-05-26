package com.jack.fiveyearcar.service.impl;

import com.jack.fiveyearcar.bean.Car;
import com.jack.fiveyearcar.bean.Dimension;
import com.jack.fiveyearcar.service.CarService;
import com.jack.fiveyearcar.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CarServiceImpl implements CarService {

    @Override
    public String move(String command,Car car,Dimension dimension) {
        int xPosition;
        int yPosition;
        Map<String,Object> dataMap=new HashMap<>();
        dataMap.put("xBorder",dimension.getxBorder());
        dataMap.put("yBorder",dimension.getyBorder());
        if(command.equals("forward")){
            switch (car.getOrientation()){
                case "east":
                    xPosition=car.getxPosition()+1;
                    yPosition=car.getyPosition();
                    break;
                case "south":
                    xPosition=car.getxPosition();
                    yPosition=car.getyPosition()-1;
                    break;
                case "west":
                    xPosition=car.getxPosition();
                    yPosition=car.getyPosition()-1;
                    break;
                case "north":
                    xPosition=car.getxPosition();
                    yPosition=car.getyPosition()+1;
                    break;
                default:
                    xPosition=car.getxPosition();
                    yPosition=car.getyPosition();
                    break;
            }
            if(xPosition>dimension.getxBorder()||yPosition>dimension.getyBorder()||
                 xPosition<0||yPosition<0){
                System.out.println("error");
                dataMap.put("car",car);
                return ResultUtil.success("203","error! OutOfBoundsException ! you cannot go forward",dataMap);
            }else {
                car.setxPosition(xPosition);
                car.setyPosition(yPosition);
                System.out.println(car.toString());
                dataMap.put("car",car);
                return ResultUtil.success("201","go forward success!",dataMap);
            }
        }else if(command.equals("turnClockwise")){
            switch (car.getOrientation()){
                case "east":
                    car.setOrientation("south");
                    break;
                case "south":
                    car.setOrientation("west");
                    break;
                case "west":
                    car.setOrientation("north");
                    break;
                case "north":
                    car.setOrientation("east");
                    break;
                default:
                    break;
            }
            System.out.println(car.toString());
            dataMap.put("car",car);
            return ResultUtil.success("202","turn clockwise success",dataMap);
        }else{
            System.out.println("wrong command!!");
            dataMap.put("car",car);
            return ResultUtil.success("204","wrong command!!",dataMap);
        }
    }


}
