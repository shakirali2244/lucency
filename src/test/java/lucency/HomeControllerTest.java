package lucency;


import org.springframework.web.servlet.ModelAndView;

import lucency.HomeController;

import junit.framework.TestCase;

public class HomeControllerTest extends TestCase {

    public void testHandleRequestView() throws Exception{		
    	HomeController controller = new HomeController();
        ModelAndView modelAndView = controller.handleRequest(null, null);		
        assertEquals("index", modelAndView.getViewName());
    }
}