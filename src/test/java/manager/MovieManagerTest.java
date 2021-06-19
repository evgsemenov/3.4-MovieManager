package manager;

import domain.ShowMovies;
import lombok.Data;
import manager.MovieManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class MovieManagerTest {
    private ShowMovies movie1 = new ShowMovies(1, 100500, "Бладшот", "боевик", "poster100500.jpg", false);
    private ShowMovies movie2 = new ShowMovies(2, 35584, "Вперед", "мультфильм", "poster35584.jpg", false);
    private ShowMovies movie3 = new ShowMovies(3, 158975, "Отель «Белград»", "комедия", "Poster158975", false);
    private ShowMovies movie4 = new ShowMovies(4, 2556545, "Джентльмены", "боевик", "poster2556545", false);
    private ShowMovies movie5 = new ShowMovies(5, 25485, "Человек-невидимка", "ужасы", "Poster25485", false);
    private ShowMovies movie6 = new ShowMovies(6, 84525, "Тролли. Мировой тур", "мультфильм", "Poster84525", true);
    private ShowMovies movie7 = new ShowMovies(7, 450867, "Номер один", "комедия", "Poster450867", true);
    private ShowMovies movie8 = new ShowMovies(8, 564853, "Отец", "драма", "Poster564853", false);
    private ShowMovies movie9 = new ShowMovies(9, 254187, "Форсаж-9", "боевик", "Poster254187", true);
    private ShowMovies movie10 = new ShowMovies(10, 45561, "Тихое место-2", "ужасы", "Poster45561", true);
    private ShowMovies movie11 = new ShowMovies(11, 24852, "Гнев человеческий", "боевик", "Poster24852", true);
    @Test
    void shouldAddMovieIfNoMovies() {
        MovieManager manager = new MovieManager();
        manager.addMovie(movie5);
        ShowMovies[] actual = manager.showLatest();
        ShowMovies[] expected = new ShowMovies[]{movie5};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddMovieIfOneMovie() {
        MovieManager manager = new MovieManager();
        manager.addMovie(movie3);    // Можно ли задать начальное состояние MovieManager c сохраненным в нем movie3 ?
        manager.addMovie(movie7);
        ShowMovies[] actual = manager.showLatest();
        ShowMovies[] expected = new ShowMovies[]{movie7, movie3};
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldAddMovieIfManyMovies() {
        MovieManager manager = new MovieManager();
        manager.addMovie(movie4);
        manager.addMovie(movie6);
        manager.addMovie(movie2);
        manager.addMovie(movie3);
        manager.addMovie(movie1);
        ShowMovies[] actual = manager.showLatest();
        ShowMovies[] expected = new ShowMovies[]{movie1, movie3,movie2, movie6, movie4};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSetMoviesLengthToDefault(){
        MovieManager manager = new MovieManager();
        manager.addMovie(movie1);
        manager.addMovie(movie2);
        manager.addMovie(movie3);
        manager.addMovie(movie4);
        manager.addMovie(movie5);
        manager.addMovie(movie6);
        manager.addMovie(movie7);
        manager.addMovie(movie8);
        manager.addMovie(movie9);
        manager.addMovie(movie10);
        manager.addMovie(movie11);
        ShowMovies[] actual = manager.showLatest();
        ShowMovies[] expected = new ShowMovies[]{movie11, movie10,movie9, movie8, movie7, movie6, movie5, movie4, movie3, movie2};
        assertArrayEquals(expected, actual);
    }
}
