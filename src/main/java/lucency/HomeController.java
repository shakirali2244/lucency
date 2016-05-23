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
    
    @RequestMapping("/callback")
   	public ModelAndView handleinstaAuthCode(){
   		/*FileInputStream in = null;
   		try {
   			in = new FileInputStream("application.properties");
   		} catch (FileNotFoundException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
   		Properties props = new Properties();
   		try {
   			props.load(in);
   		} catch (IOException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
   		try {
   			in.close();
   		} catch (IOException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}

   		FileOutputStream out = null;
   		try {
   			out = new FileOutputStream("application.properties");
   		} catch (FileNotFoundException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
   		props.setProperty("ig1", "america");
   		try {
   			props.store(out, null);
   		} catch (IOException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
   		try {
   			out.close();
   		} catch (IOException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}*/
   		ModelAndView ret = new ModelAndView("console");
   	     ret.addObject("page", "auth");
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