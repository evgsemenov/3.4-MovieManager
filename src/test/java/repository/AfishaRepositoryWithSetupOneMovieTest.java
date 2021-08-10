package repository;

import domain.ShowMoviesInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AfishaRepositoryWithSetupOneMovieTest {
    private AfishaRepository repository = new AfishaRepository();
    private ShowMoviesInfo movie1 = new ShowMoviesInfo(1, 100500, "Бладшот", "боевик", "poster100500.jpg", false);
    private ShowMoviesInfo movie2 = new ShowMoviesInfo(2, 35584, "Вперед", "мультфильм", "poster35584.jpg", false);
    private ShowMoviesInfo movie3 = new ShowMoviesInfo(3, 158975, "Отель «Белград»", "комедия", "Poster158975", false);
    private ShowMoviesInfo movie4 = new ShowMoviesInfo(4, 2556545, "Джентльмены", "боевик", "poster2556545", false);
    private ShowMoviesInfo movie5 = new ShowMoviesInfo(5, 25485, "Человек-невидимка", "ужасы", "Poster25485", false);
    private ShowMoviesInfo movie6 = new ShowMoviesInfo(6, 84525, "Тролли. Мировой тур", "мультфильм", "Poster84525", true);
    private ShowMoviesInfo movie7 = new ShowMoviesInfo(7, 450867, "Номер один", "комедия", "Poster450867", true);
    private ShowMoviesInfo movie8 = new ShowMoviesInfo(8, 564853, "Отец", "драма", "Poster564853", false);
    private ShowMoviesInfo movie9 = new ShowMoviesInfo(9, 254187, "Форсаж-9", "боевик", "Poster254187", true);
    private ShowMoviesInfo movie10 = new ShowMoviesInfo(10, 45561, "Тихое место-2", "ужасы", "Poster45561", true);
    private ShowMoviesInfo movie11 = new ShowMoviesInfo(11, 24852, "Гнев человеческий", "боевик", "Poster24852", true);

    @BeforeEach
    public void setupOneMovie() {
        repository.save(movie5);
    }

    @Test
    public void shouldAddMovieIfOneMovie() {
        repository.save(movie10);
        ShowMoviesInfo[] actual = repository.getMovies();
        ShowMoviesInfo[] expected = new ShowMoviesInfo[]{movie5, movie10};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveExistMovieIfOneMovie(){
        repository.removeById(5);
        ShowMoviesInfo[] actual = repository.getMovies();
        ShowMoviesInfo[] expected = new ShowMoviesInfo[0];
        assertArrayEquals(expected, actual);
    }
//    @Test
//    public void shouldRemoveNotExistMovieIfOneMovie(){
//        repository.removeById(6);
//        ShowMoviesInfo[] actual = repository.getMovies();
//        ShowMoviesInfo[] expected = new ShowMoviesInfo[]{movie5};
//        assertArrayEquals(expected, actual);
//
//    }

    @Test
    void  shouldFindAllMoviesIfOneMovie() {
        ShowMoviesInfo[] actual = repository.findAll();
        ShowMoviesInfo[] expected = new ShowMoviesInfo[]{movie5};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveAllIfOneMovie() {
        repository.removeAll();
        ShowMoviesInfo[] actual = repository.getMovies();
        ShowMoviesInfo[] expected = new ShowMoviesInfo[]{};
        assertArrayEquals(expected, actual);
    }
}

