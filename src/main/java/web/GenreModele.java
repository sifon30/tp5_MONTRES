package web;
import java.util.ArrayList;
import java.util.List;
import metier.entities.Genre;
public class GenreModele {
List<Genre> genres = new ArrayList<>();
public List<Genre> getGenres() {
return genres;
}
public void setGenres(List<Genre> Genres) {
this.genres = genres;
}
}