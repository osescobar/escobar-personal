package Controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Ciudad;
import nogocio.CiudadImp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class CiudadServletControler
 */
public class CiudadServletControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Ciudad> listaCiudades=new ArrayList<>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CiudadServletControler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CiudadImp ciudadImp=new CiudadImp();
		this.listaCiudades=ciudadImp.findAll();
		request.setAttribute("ciudades",listaCiudades);
		request.getRequestDispatcher("ciudades/listCiudades.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
