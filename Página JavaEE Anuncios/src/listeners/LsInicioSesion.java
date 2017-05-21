package listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class LsInicioSesion
 *
 */
@WebListener
public class LsInicioSesion implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public LsInicioSesion() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 

        	int n = (Integer)se.getSession().getAttribute("nSesiones");
         	n++;
         	se.getSession().setAttribute("nSesiones", n);

         
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    }
	
}
