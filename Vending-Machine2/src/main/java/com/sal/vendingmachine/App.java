package com.sal.vendingmachine;

import com.sal.vendingmachine.controller.VendingMachineController;
import com.sal.vendingmachine.dao.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Elizabeth Yim
 *
 * */
public class App {
    //Spring DI
    public static void main(String[] args) throws VendingMachineException {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.scan("com.sal.vendingmachine");
        appContext.refresh();
        VendingMachineController controller = appContext.getBean("vendingMachineController", VendingMachineController.class);
        controller.run();
    }
}