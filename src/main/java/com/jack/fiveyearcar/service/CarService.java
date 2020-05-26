package com.jack.fiveyearcar.service;

import com.jack.fiveyearcar.bean.Car;
import com.jack.fiveyearcar.bean.Dimension;

public interface CarService {

    String move(String command,Car car,Dimension dimension);

}
