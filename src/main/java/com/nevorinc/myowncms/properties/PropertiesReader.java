/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nevorinc.myowncms.properties;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Properties;
import java.net.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Admin
 */

public class PropertiesReader {
    private boolean filled = false;   
    String propFileName = "properties/site.properties";     
    private Properties prop = new Properties();
    
    @Autowired
    private ApplicationContext ac;
    
    public PropertiesReader(){
        if (prop != null){
            filled = true;
        }
    }
    
    public final void getPropValues() {
        try{
            filled = false;
            
            ClassPathResource resource = new ClassPathResource(propFileName);                              
            prop.load(resource.getInputStream());                                
            
            filled = true;           
            resource.getInputStream().close();
        }catch(Exception e){
            System.out.println("getPropValues() " + e.getMessage());
        }
    }
    
    public final void modelPropFiller(ModelAndView model){
        if (filled){
            String key, value;
            for (Map.Entry<Object,Object> entry : prop.entrySet()){
                key = entry.getKey().toString();
                value = entry.getValue().toString();
                model.addObject(key, value);
                System.out.println("Key " + key + ", Value " + value);
            }
        }else{
            System.out.println("Objects are not added, cause of Runtime exception");
            File file = new File("zaebal");
            try{
            PrintWriter pw = new PrintWriter(file);
            pw.write("suka");
            pw.close();
            }catch(Exception e){
                System.out.println("SSUUUUUUKAAAA");
            }
        }
    }
    
    public final void propAdd(String key, String value){
        try{
            filled = false;
            
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            URL url = classLoader.getResource(propFileName);
            //PrintWriter propFileWriter = new PrintWriter(resource.getOutputStream());
            prop.setProperty(key, value);
            FileOutputStream fos = new FileOutputStream(new File(url.toURI()));
            prop.store(fos, "");
            
            filled = true;
            fos.close();                     
        }catch(Exception e){
            System.out.println("propAdd() " + e.getMessage());
        }
    }
    
}
