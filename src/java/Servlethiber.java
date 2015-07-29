/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.springmvc.loc;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author EDU-Stud
 */
public class Servlethiber extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlethiber</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Servlethiber at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
//             String id = request.getParameter("value");
        Session session=null;
        try (PrintWriter out = response.getWriter())
        {
            SessionFactory sessionfactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
            session = sessionfactory.openSession();
            session.beginTransaction();
//            String resp ="Not used";
            String HQL_QUERY= "from loc location";
            org.hibernate.Query query = session.createQuery(HQL_QUERY);
            
//            query.setParameter("id",id);
//            Iterator it= query.iterate();
//            if(it.hasNext())
//            {
//                 resp = "Used";
//            }
//            query.setParameter("id",id);
            System.out.println("Reading Values");
            for(Iterator it = query.iterate();it.hasNext();){
                loc l = (loc) it.next();
               out.println("<h1> Reading The database!</h1>");
              out.println("<h2>"+l.getID()+". "+l.getName()+"</h2>");
                out.println("</br>");
            }
           
//            out.println("<label>"+resp+"</label>");
            session.getTransaction().commit();
//            System.out.println("Done");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
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
          response.setContentType("text/html;charset=UTF-8");
          
             Session session=null;
        try (PrintWriter out = response.getWriter())
        {
            SessionFactory sessionfactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
            session = sessionfactory.openSession();
            session.beginTransaction();
            
           // String l = request.getParameter("location");
            out.println("<h1> Save  to the database</h1>");
            loc loc = new loc();
            loc.setName("ST Lucia");
            
            String r = session.save(loc).toString();
            session.getTransaction().commit();
            
           out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlethiber</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Result"+ r + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
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
