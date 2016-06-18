package lucency;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import to.us.badgerworks.CrawlEng;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;
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
    
    @RequestMapping(value = "/instareport", method = RequestMethod.POST)
    public void handleinstaPOSTRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
    	// get absolute path of the application
        ServletContext context = request.getServletContext();
        String appPath = context.getRealPath("");
        System.out.println("appPath = " + appPath);
 
        // construct the complete absolute path of the file
        String fullPath =  appPath + "/WEB-INF/Report.csv";      
        File downloadFile = new File(fullPath);
        FileInputStream inputStream = new FileInputStream(downloadFile);
         
        // get MIME type of the file
        String mimeType = context.getMimeType(fullPath);
        if (mimeType == null) {
            // set to binary type if MIME mapping not found
            mimeType = "application/octet-stream";
        }
        System.out.println("MIME type: " + mimeType);
 
        // set content attributes for the response
        response.setContentType(mimeType);
        response.setContentLength((int) downloadFile.length());
 
        // set headers for the response
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",
                downloadFile.getName());
        response.setHeader(headerKey, headerValue);
 
        // get output stream of the response
        OutputStream outStream = response.getOutputStream();
 
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
 
        // write bytes read from the input stream into the output stream
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }
 
        inputStream.close();
        outStream.close();
    }
    
    @RequestMapping("/instagram/auth")
	public ModelAndView handleinstaAuth(){
    	ModelAndView ret = new ModelAndView("console");
	     ret.addObject("page", "authStart");
	     return ret;
    }
    
   

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		 RestHelper rh = new RestHelper();
		System.out.println(rh.get())
		 ModelAndView ret = new ModelAndView("console");
	     ret.addObject("page", "main");
	     return ret;
	}
	
	

}

	

