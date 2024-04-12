package web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import dao.GenreDaoImpl;
import dao.IGenreDao;
import dao.IMontreDao;
import dao.MontreDaoImpl;
import metier.entities.Genre;
import metier.entities.Montre;
@WebServlet (name="cs",urlPatterns= {"/controleur","*.do"})
public class ControleurServlet extends HttpServlet {
IMontreDao metier;
IGenreDao metierGen;
@Override
public void init() throws ServletException {
metier = new MontreDaoImpl();
metierGen = new GenreDaoImpl();
}
@Override
protected void doGet(HttpServletRequest request,
 HttpServletResponse response)
 throws ServletException, IOException {
String path=request.getServletPath();
if (path.equals("/index.do"))
{
request.getRequestDispatcher("montres.jsp").forward(request,response);
}
else if (path.equals("/chercher.do"))
{
String motCle=request.getParameter("motCle");
MontreModele model= new MontreModele();
model.setMotCle(motCle);
List<Montre> mons = metier.montresParMC(motCle);
model.setmontres(mons);
request.setAttribute("model", model);
request.getRequestDispatcher("montres.jsp").forward(request,response);
}

else if (path.equals("/saisie.do") )
{
	List<Genre> gens = metierGen.getAllGenres();
	GenreModele model= new GenreModele();
	model.setGenres(gens);
	request.setAttribute("catModel", model);
request.getRequestDispatcher("saisieMontre.jsp").forward(request,response);
}
else if (path.equals("/save.do") && request.getMethod().equals("POST"))
{
	String nom=request.getParameter("nom");
	Long genreId=Long.parseLong(request.getParameter("genre"));
	double prix = Double.parseDouble(request.getParameter("prix"));
	Genre gen = metierGen.getGenre(genreId);
	Montre m = metier.save(new Montre(nom,prix,gen));
	request.setAttribute("montre", m);
	response.sendRedirect("chercher.do?motCle=");
}
else if (path.equals("/supprimer.do"))
{
 Long id= Long.parseLong(request.getParameter("id"));
 metier.deleteMontre(id);
 response.sendRedirect("chercher.do?motCle=");
}

else if (path.equals("/editer.do") )
{
	Long id= Long.parseLong(request.getParameter("id"));
	Montre m = metier.getMontre(id);
	request.setAttribute("montre", m);
	List<Genre> gens = metierGen.getAllGenres();
	GenreModele model= new GenreModele();
	model.setGenres(gens);
	request.setAttribute("genModel", model);
request.getRequestDispatcher("editerMontre.jsp").forward(request,response);
}
else if (path.equals("/update.do") )
{
	Long id = Long.parseLong(request.getParameter("id"));
	String nom=request.getParameter("nom");
	double prix = Double.parseDouble(request.getParameter("prix"));
	Long genreId=Long.parseLong(request.getParameter("genre"));
	Montre m = new Montre();
	m.setIdMontre(id);
	m.setNomMontre(nom);


	m.setPrix(prix);
	Genre gen = metierGen.getGenre(genreId);
	m.setGenre(gen);
	metier.updateMontre(m);
	response.sendRedirect("chercher.do?motCle=");
}
else
{
response.sendError(Response.SC_NOT_FOUND);
}
}
@Override
protected void doPost(HttpServletRequest request, 
 HttpServletResponse response) throws 
ServletException, IOException {
doGet(request,response);
}

}

