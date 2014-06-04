package es.unileon.springapp.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SetProfitability {
	
	/** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
    
    private String id;
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private String newprofitability;

    public void setNewdate(String i) {
        this.newprofitability = i;
        logger.info("comision set to " + i);
    }

    public String getNewProfitability() {
        return this.newprofitability;
    }

}
