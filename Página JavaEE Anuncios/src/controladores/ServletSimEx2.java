package controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAOAnuncio;
import modelos.Anuncio;

/**
 * Servlet implementation class ServletSimEx2
 */
@WebServlet("/ServletSimEx2")
public class ServletSimEx2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSimEx2() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    
   




	@Override
	public void init(ServletConfig config) throws ServletException {
		Integer nSesiones=new Integer(0);
		ServletContext cont=config.getServletContext();
		cont.setAttribute("nSesiones",nSesiones);
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Inicio de sesión
		HttpSession sesion = request.getSession();
		ArrayList<Anuncio> favoritos = (ArrayList<Anuncio>)sesion.getAttribute("favoritos");
		if(favoritos == null){
			favoritos = new ArrayList<Anuncio>();
			sesion.setAttribute("favoritos", favoritos);
		}
		
		
		String vista = null;
		ServletContext contexto = request.getServletContext();
		int nSesiones = (int)contexto.getAttribute("nSesiones");
		sesion.setAttribute("nSesiones", nSesiones);
		
		DAOAnuncio dao = new DAOAnuncio();
		

		ArrayList<Anuncio> anuncios = dao.getTodos();
		request.setAttribute("listado", anuncios);
		
		
		
		vista ="index.jsp";
		request.getServletContext().getRequestDispatcher("/" + vista).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
