/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author student
 */
public class reg extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String n = req.getParameter("nm");
        String p = req.getParameter("pas");
        String e = req.getParameter("em");
        String c = req.getParameter("cor");
        String ch = req.getParameter("check");
        
        Connection con=null;
        String url = "jdbc:mysql://localhost:3306/istar";
        String driver = "com.mysql.jdbc.Driver";
        String user = "root";
        String pass="root";
        
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        if (ch != null) {
            if (ch.equals("check")) {
              
                try{
                     Class.forName(driver);
                     con=DriverManager.getConnection(url,user,pass);
                     PreparedStatement st=con.prepareStatement("insert into details values(?,?,?,?,?)");
                     st.setString(1, n);
                     st.setString(2, p);
                     st.setString(3, e);
                     st.setString(4, c);
                     st.setString(5, ch);
                     int i=st.executeUpdate();
                     if(i>0)
                        out.println("<html><body><h1>Recored Inserted...</h1><a href='index.html'>OK</a></body></html>");  
                    
                     
                    
                }catch(Exception ae)
                {
                    ae.printStackTrace();
                }
 
                
            } else {
                out.println("CHECK ");
            }
        } else {
            out.println("Please Check..");
        }
    }

    
}
