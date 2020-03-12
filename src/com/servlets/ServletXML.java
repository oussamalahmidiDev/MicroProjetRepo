package com.servlets;


import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.*;

@WebServlet(name = "ServletXML")
public class ServletXML extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletOutputStream stream = null;
        BufferedInputStream buf = null;
        try{

            stream = response.getOutputStream();
            File xml = new File("/Users/oussamalahmidi/Downloads/MicroProjet/web/doc.xml");

            response.setContentType("text/xml");
            response.setContentLength( (int) xml.length() );

            FileInputStream input = new FileInputStream(xml);
            buf = new BufferedInputStream(input);
            int readBytes = 0;

            //read from the file; write to the ServletOutputStream
            while((readBytes = buf.read()) != -1)
                stream.write(readBytes);

        } catch (IOException ioe){

            throw new ServletException(ioe.getMessage());

        } finally {

            if(stream != null)
                stream.close();
            if(buf != null)
                buf.close();
        }

    }
}
