/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.rafifwhy.greppp;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rafif Wahyu
 */
@WebServlet(name = "GrepServlet", urlPatterns = {"/GrepServlet"})
public class GrepServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Result</title>");
            out.println("<link rel="+'"'+"stylesheet"+'"'+"href="+'"'+"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"+'"'+ "integrity="+'"'+"sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"+'"'+ "crossorigin="+'"'+"anonymous"+'"'+">");
            out.println("<script src="+'"'+"https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"+'"'+ "integrity="+'"'+"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"+'"'+ "crossorigin="+'"'+"anonymous"+'"'+'>'+"</script>");
            out.println("<script src="+'"'+"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"+'"'+ "integrity="+'"'+"sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"+'"'+ "crossorigin="+'"'+"anonymous"+'"'+"></script>");
            out.println("</head>");
//            out.println("<style>");
//                out.println("table, th, td {"
//                        + "border: 1px solid black;"
//                        + "border-collapse: collapse;"
//                        + "}"
//                        + "td {"
//                        + "text-align: center;"
//                        + "}"
//                        + "table {"
//                        + "width: 100%"
//                        + "}");
//            out.println("</style>");
            out.println("<body>");
           
            
            String msisdn = request.getParameter("msisdn");
            String date = request.getParameter("date");
            String opt = request.getParameter("type");
            
            String line;
            int lines = 0;
            int matches = 0;

            // Check the command line, prompt user if needed
            
            out.println("<h4><center>");
            out.print  ("Find " + msisdn);
            out.print  (" Type " + opt);
            out.print  (" On " + date +"<br>");
            out.println("</center></h4>");
            // Create a Scanner for the file
            File in = new File("D:\\Unilife\\SEMESTER 6\\Project\\Java\\javaGrep\\newtspoin_server.log.10krows");
            Scanner scan = new Scanner( in );

            // Get a regular expression from the command line
            Pattern pat = Pattern.compile( msisdn );

            // Match lines against the Regular Expression
            while ( scan.hasNextLine() )
            {
                line = scan.nextLine();
                lines++;

                // Check if the current line contains the pattern
                Matcher match = pat.matcher( line );
                if (opt.equals("Inject")){
                    if (match.find())
                    {
                        
                        if (line.contains(date) && line.contains("MKIOSHIT")){
                          
                            String[] arrOfLine = line.split("\\|");
                            out.println("<table class="+'"'+"table table-bordered table-striped"+'"'+">");
                                out.println("<thead>");
                                    out.println("<tr>");
                                        out.println("<td>MSISDN</td>");
                                        out.println("<td>Amount</td>");
                                        out.println("<td>Date</td>");
                                        out.println("<td>Transaction ID</td>");
                                        out.println("<td>Lacci</td>");
                                        out.println("<td>Message ID</td>");
                                        out.println("<td>IP Address</td>");
                                        out.println("<td>Insys Serial</td>");
                                        out.println("<td>DL Name</td>");
                                        out.println("<td>Recharge Date</td>");
                                        out.println("<td>Status Code</td>");
                                        out.println("<td>Recharge Type</td>");
                                    out.println("</tr>");
                                out.println("</thead>");
                                out.println("<tbody>");
                                    out.println("<tr>");
                                        out.println("<td>"+arrOfLine[1]+"</td>");
                                        out.println("<td>"+arrOfLine[2]+"</td>");
                                        out.println("<td>"+arrOfLine[3]+"</td>");
                                        out.println("<td>"+arrOfLine[4]+"</td>");
                                        out.println("<td>"+arrOfLine[5]+"</td>");
                                        out.println("<td>"+arrOfLine[6]+"</td>");
                                        out.println("<td>"+arrOfLine[7]+"</td>");    
                                        out.println("<td>"+arrOfLine[8]+"</td>");    
                                        out.println("<td>"+arrOfLine[9]+"</td>");    
                                        out.println("<td>"+arrOfLine[10]+"</td>");    
                                        out.println("<td>"+arrOfLine[11]+"</td>");    
                                        out.println("<td>"+arrOfLine[12]+"</td>");
                                    out.println("</tr>");
                                out.println("</tbody>");
                            out.println("</table>");
                            matches++;
                        }
                        if (line.contains(date) && line.contains("URPHIT")){
                            
                            String[] arrOfLine = line.split("\\|");
                            out.println("<table>");
                                out.println("<thead>");
                                    out.println("<tr>");
                                        out.println("<td>Header</td>");
                                        out.println("<td>Value</td>");
                                    out.println("</tr>");
                                out.println("</thead>");
                                out.println("<tbody>");
                                    out.println("<tr>");
                                        out.println("<td>MSISDN</td>");
                                        out.println("<td>"+arrOfLine[1]+"</td>");
                                    out.println("</tr>");
                                    out.println("<tr>");
                                        out.println("<td>Amount</td>");
                                        out.println("<td>"+arrOfLine[2]+"</td>");
                                    out.println("</tr>");
                                    out.println("<tr>");
                                        out.println("<td>Date</td>");
                                        out.println("<td>"+arrOfLine[3]+"</td>");
                                    out.println("</tr>");
                                    out.println("<tr>");
                                        out.println("<td>Transaction ID</td>");
                                        out.println("<td>"+arrOfLine[4]+"</td>");
                                    out.println("</tr>");
                                    out.println("<tr>");
                                        out.println("<td>Lacci</td>");
                                        out.println("<td>"+arrOfLine[5]+"</td>");
                                    out.println("</tr>");
                                    out.println("<tr>");
                                        out.println("<td>Message ID</td>");
                                        out.println("<td>"+arrOfLine[6]+"</td>");
                                    out.println("</tr>");
                                    out.println("<tr>");
                                        out.println("<td>IP Address</td>");
                                        out.println("<td>"+arrOfLine[7]+"</td>");
                                    out.println("</tr>");
                                    out.println("<tr>");
                                        out.println("<td>Insys Serial</td>");
                                        out.println("<td>"+arrOfLine[8]+"</td>");
                                    out.println("</tr>");
                                    out.println("<tr>");
                                        out.println("<td>DL Name</td>");
                                        out.println("<td>"+arrOfLine[9]+"</td>");
                                    out.println("</tr>");
                                    out.println("<tr>");
                                        out.println("<td>Recharge Date</td>");
                                        out.println("<td>"+arrOfLine[10]+"</td>");
                                    out.println("</tr>");
                                    out.println("<tr>");
                                        out.println("<td>Status Code</td>");
                                        out.println("<td>"+arrOfLine[11]+"</td>");
                                    out.println("</tr>");
                                    out.println("<tr>");
                                        out.println("<td>Recharge Type</td>");
                                        out.println("<td>"+arrOfLine[12]+"</td>");
                                    out.println("</tr>");
                                out.println("</tbody>");
                            out.println("</table>");
                            matches++;
                        }    
                        
                    }
                }else{
                    date = date.replace("-","");
                    
                    if (match.find()){
                        if (line.contains("com.solusi247.poin.callback.worker.CallbackWorker") && line.contains("LOGPROCESS") && line.contains(date)){
                            out.println (line + "<br>");
                            matches++;
                        }
                    }
                }
            }
            out.println("<br>");
            out.println("<form action=" + '"' + "index.html" + '"' + "method=" + '"' + "GET" + '"' + ">"
                                + "<button class="+'"'+"btn btn-danger"+'"'+" type=" + '"' + "submit" + '"' + ">Search Again</button>"
                            + "</form>");
          
            out.println("</body></html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(GrepServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(GrepServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
