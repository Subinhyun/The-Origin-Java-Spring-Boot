package com.company;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
//        LinkedList<CarInterface> linkedList = new LinkedList();
//        Road route88 = new Road(linkedList);

        Driver unlicensed = new Driver("unlicensed", 0);
        Driver me = new Driver("me", 1);
        CarInterface car = new GoCart();
        car.setDriver(unlicensed);
        car.setDriver(me);

        car = new SmallCar();
        car.setDriver(me);
//        car.setDriver(unlicensed);
    }
}
