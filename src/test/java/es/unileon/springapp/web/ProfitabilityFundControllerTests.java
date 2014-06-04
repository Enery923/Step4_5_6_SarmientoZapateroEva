package es.unileon.springapp.web;

import java.util.ArrayList;
import java.util.Map;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import es.unileon.springapp.domain.InvestmentFund;
import es.unileon.springapp.repository.InMemoryInvestmentFundDao;
import es.unileon.springapp.service.SimpleProfitabilityFundManager;



public class ProfitabilityFundControllerTests {

    @Test
    public void testHandleRequestView() throws Exception{		
        ProfitabilityFundController controller = new ProfitabilityFundController();
        SimpleProfitabilityFundManager spm = new SimpleProfitabilityFundManager();
        spm.setInvestmentFundDao(new InMemoryInvestmentFundDao(new ArrayList<InvestmentFund>()));
        controller.setProfitabilityFundManager(spm);
        //controller.setProductManager(new SimpleProductManager());
        ModelAndView modelAndView = controller.handleRequest(null, null);		
        assertEquals("hello", modelAndView.getViewName());
        assertNotNull(modelAndView.getModel());
        Map modelMap = (Map) modelAndView.getModel().get("model");
//        String nowValue = (String) modelMap.get("now");
//        assertNotNull(nowValue);
    }
}