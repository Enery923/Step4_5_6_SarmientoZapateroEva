package com.companyname.springapp.web;

import java.util.ArrayList;
import java.util.Map;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import es.unileon.springapp.domain.Product;
import es.unileon.springapp.repository.InMemoryInvestmentFundDao;
import es.unileon.springapp.service.SimpleProductManager;
import es.unileon.springapp.web.InventoryController;


public class InventoryControllerTests {

    @Test
    public void testHandleRequestView() throws Exception{		
        InventoryController controller = new InventoryController();
        SimpleProductManager spm = new SimpleProductManager();
        spm.setProductDao(new InMemoryInvestmentFundDao(new ArrayList<Product>()));
        controller.setProductManager(spm);
        //controller.setProductManager(new SimpleProductManager());
        ModelAndView modelAndView = controller.handleRequest(null, null);		
        assertEquals("hello", modelAndView.getViewName());
        assertNotNull(modelAndView.getModel());
        Map modelMap = (Map) modelAndView.getModel().get("model");
        String nowValue = (String) modelMap.get("now");
        assertNotNull(nowValue);
    }
}