package lucency;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import to.us.badgerworks.CrawlEng;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
@Controller
@RequestMapping(value = "/console")
public class ConsoleController {

    protected final Log logger = LogFactory.getLog(getClass());
    
    @RequestMapping(value = "/{page}", method = RequestMethod.GET)
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response,@PathVariable String page)
            throws ServletException, IOException {
    	logger.info("Returning Console view");
        ModelAndView ret = new ModelAndView("console");
        ret.addObject("page", page);
        return ret;
    }
    
    @RequestMapping(value = "/url", method = RequestMethod.POST)
    public ModelAndView handlePOSTRequest(@RequestParam(value = "url") String url)
            throws ServletException, IOException {
  
    	URI tmp = null;
    	try {
    		tmp = new URI(url);
    	} catch (URISyntaxException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	CrawlEng a = new CrawlEng(tmp,"postgres");
    	a.crawlStart();
    	a.thread();
       return null;
    }

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		 ModelAndView ret = new ModelAndView("console");
	     ret.addObject("page", "main");
	     return ret;
	}
	
	

	
	

}

	

