package ca.sait.lab7.servlets;

import ca.sait.lab7.models.Role;
import ca.sait.lab7.models.User;
import ca.sait.lab7.services.RoleService;
import ca.sait.lab7.services.UserService;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Valued Customer
 */
public class UserServlet extends HttpServlet {
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
        
        
        UserService service = new UserService();
        RoleService ro = new RoleService();
        List<User> users;
        String action = request.getParameter("action");
         User user;

        try {
            users = service.getAll();
            List<Role> roles = ro.getAll();   
            request.setAttribute("users", users);
        
            
        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        if(action != null && action.equals("delete")){
            
            try {
                String email = request.getParameter("email").replace(" ", "+");
                boolean deleted =  service.delete(email);
                
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            } 
            
        }
     
           if(action != null && action.equals("update")){
     
            try {
      
                String email = request.getParameter("email").replace(" ", "+");
                user = service.get("email");
//                users = service.getAll();
//                List<Role> roles = ro.getAll();
                
                request.setAttribute("updateUser", user);
//                request.setAttribute("roles", roles);
//                request.setAttribute("password", request.getParameter("password"));
   
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
    }
           
           
            this.getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
        

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
        
         String action = request.getParameter("action");
         RoleService roleservice = new RoleService();
         UserService userservice = new UserService();
         String pass ="password";
         
         
        if(action != null && action.equals("add")){
          
               List<Role> roles = null;
               Role ro = new Role();
           
            try {
              String email = request.getParameter("newemail");
              String firstName = request.getParameter("newfName");
              String lastName = request.getParameter("newlName");
              boolean active = true;
              int role = Integer.parseInt(request.getParameter("newrole"));
             
              boolean added = userservice.insert(email, active, firstName, lastName, pass, role);
             
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }      
              
        }
        
        if(action != null && action.equals("update")){
            
           
              
            try {
                String email = request.getParameter("updateemail");
                boolean active = true;
                String firstName = request.getParameter("updatefName");
                String lastName = request.getParameter("updatelName");  
                int role = Integer.parseInt(request.getParameter("updaterole"));
                boolean updated = userservice.update(email, active, firstName, lastName, pass, role);
                        } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        try {
            List<User> users = userservice.getAll();
            request.setAttribute("users", users);
            
       
        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
    }
        
    }


