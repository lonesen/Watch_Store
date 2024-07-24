package com.WS.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.format.DateTimeFormatters;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
public class ParamService {
    @Autowired
    HttpServletRequest request;
 
    @Autowired
    ServletContext app;
    
    public String getString(String name, String defaultValue) {
        String value = request.getParameter(name);
        return value != null ? value : defaultValue;
    }

    public int getInt(String name, int defaultValue) {
        String value = request.getParameter(name);
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public double getDouble(String name, double defaultValue) {
        String value = request.getParameter(name);
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public boolean getBoolean(String name, boolean defaultValue) {
        String value = request.getParameter(name);
        if (value == null) {
            return defaultValue;
        }
        return Boolean.parseBoolean(value);
    }

    public Date getDate(String name, String pattern) {
        String value = request.getParameter(name);
        if (value == null) {
            return null;
        }
        try {
        	
//        	DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        	LocalDate ld = LocalDate.parse(value, dateFormatter);
//        	Date date = Date.from(ld.atStartOfDay(ZoneId.systemDefault()).toInstant());
        	
            return new SimpleDateFormat(pattern).parse(value);
        } catch (ParseException e) {
            throw new RuntimeException("Date format is incorrect", e);
        }
    }

    public File saveFile(MultipartFile file, String folder) {
    	File dir = new File(app.getRealPath(folder)); 
    	if(!dir.exists()) dir.mkdirs();
    	try {
	    	File saveFile = new File(dir, file.getOriginalFilename()); 
	    	System.out.println(dir + "\\" + file.getOriginalFilename());
	    	file.transferTo(saveFile);
	    	return saveFile;
    	} catch (Exception e) {
    		throw new RuntimeException(e);
    	}
    }
}

