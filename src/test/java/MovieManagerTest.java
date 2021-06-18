import domain.ShowMovies;
import manager.MovieManager;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {
    private MovieManager manager = new MovieManager();
//    int addByMovieId = 84525;
    private ShowMovies movie1 = new ShowMovies(1, 100500, "Бладшот", "боевик", "poster100500.jpg", false);
    private ShowMovies movie2 = new ShowMovies(2, 35584, "Вперед", "мультфильм", "poster35584.jpg", false);
    private ShowMovies movie3 = new ShowMovies(3, 158975, "Отель «Белград»", "комедия", "Poster158975", false);
    private ShowMovies movie4 = new ShowMovies(4, 2556545, "Джентльмены", "боевик", "poster2556545", false);
    private ShowMovies movie5 = new ShowMovies(5, 25485, "Человек-невидимка", "ужасы", "Poster25485", false);
    private ShowMovies movie6 = new ShowMovies(6, 84525, "Тролли. Мировой тур", "мультфильм", "Poster84525", true);
    private ShowMovies movie7 = new ShowMovies(7, 450867, "Номер один", "комедия", "Poster450867", true);

    @Test
    void shouldAddMovieIfNoMovies() {
        manager.addMovie(movie5);
        ShowMovies[] actual = manager.showLatest();
        ShowMovies[] expected = new ShowMovies[]{movie5};
        assertArrayEquals(expected, actual);
    }

}