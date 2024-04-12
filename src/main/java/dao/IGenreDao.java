package dao;
import java.util.List;
import metier.entities.Genre;
public interface IGenreDao {
public Genre save(Genre gen);
public Genre getGenre(Long id);
public Genre updateGenre(Genre gen);
public void deleteGenre(Long id);
public List<Genre> getAllGenres();
}