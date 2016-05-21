package lucency;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
@Controller
public class HomeController {
	
    protected final Log logger = LogFactory.getLog(getClass());
    @RequestMapping("/")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        logger.info("Returning Home view");
        ModelAndView ret = new ModelAndView("index");
        return ret;
    }
    
    @RequestMapping("/login")
    public ModelAndView handleloginRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        logger.info("Returning Login view");
        ModelAndView ret = new ModelAndView("login");
        return ret;
    }
    
    @RequestMapping(path = "/contact", method = RequestMethod.GET)
    public ModelAndView handleContactRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        logger.info("Returning Contact view");
        ModelAndView ret = new ModelAndView("contact");
        return ret;
    }
    
    @RequestMapping(path = "/contact", method = RequestMethod.POST)
    public ModelAndView handleFormRequest(@RequestParam(value = "name") String name,
    		@RequestParam(value = "email") String email,
    		@RequestParam(value = "subject") String subject,
    		@RequestParam(value = "message") String message)
            throws ServletException, IOException {
        logger.info(name);
        logger.info(email);
        logger.info(subject);
        logger.info(message);
        
        ModelAndView ret = new ModelAndView("index");
        return ret;
    }

}