package dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import metier.entities.Genre;
import util.JPAutil;
public class GenreDaoImpl implements IGenreDao {
// TP6_JEE à replacer par votre persistence unit, consultez votre
//fichier persistence.xml <persistence-unit name="TP6_JEE">
private EntityManager entityManager=JPAutil.getEntityManager("TP5_MONTRES");
@Override
public Genre save(Genre gen ) {
EntityTransaction tx = entityManager.getTransaction();
tx.begin();
entityManager.persist(gen);
tx.commit();


return gen;
}
@Override
public Genre getGenre(Long id) {
return entityManager.find(Genre.class, id);
}
@Override
public Genre updateGenre(Genre gen) {
EntityTransaction tx = entityManager.getTransaction();
tx.begin();
entityManager.merge(gen);
tx.commit();
return gen;
}
@Override
public void deleteGenre(Long id) {
Genre genre = entityManager.find(Genre.class, id);
entityManager.getTransaction().begin();
entityManager.remove(genre);
entityManager.getTransaction().commit();
}
@Override
public List<Genre> getAllGenres() {
List<Genre> gens =

entityManager.createQuery("select g from Genre g").getResultList();

return gens;
}
}