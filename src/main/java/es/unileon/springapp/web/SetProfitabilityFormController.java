package es.unileon.springapp.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.unileon.springapp.service.DateFundManager;
import es.unileon.springapp.service.ProfitabilityFundManager;
import es.unileon.springapp.service.SetDate;
import es.unileon.springapp.service.SetProfitability;


@Controller
@RequestMapping(value="/setProfitability.htm")
public class SetProfitabilityFormController {
	
	/** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired

	private ProfitabilityFundManager profitabilityFundManager;
    
    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(@Valid SetProfitability setProfitability, BindingResult result)
    {
        if (result.hasErrors()) {
            return "setProfitability";
        }
		
        String newprofitability = setProfitability.getNewProfitability();
        logger.info("Change date by: " + newprofitability);
        
        String id = setProfitability.getId();

        profitabilityFundManager.set(newprofitability, id);

        return "redirect:/hello.htm";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    protected SetProfitability formBackingObject(HttpServletRequest request) throws ServletException {
        SetProfitability setProfitability = new SetProfitability();
        setProfitability.setId(request.getParameter("id"));
        return setProfitability;
    }

	public ProfitabilityFundManager getProfitabilityFundManager() {
		return getProfitabilityFundManager();
	}

	public void setDateFundManager(ProfitabilityFundManager profitabilityFundManager) {
		this.profitabilityFundManager = profitabilityFundManager;
	}
	
}