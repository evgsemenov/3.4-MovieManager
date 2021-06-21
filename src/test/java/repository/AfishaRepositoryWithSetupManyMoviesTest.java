package repository;

import domain.ShowMoviesInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class AfishaRepositoryWithSetupManyMoviesTest {
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
    public void setupManyMovies() {
        repository.save(movie1);
        repository.save(movie2);
        repository.save(movie3);
        repository.save(movie4);
        repository.save(movie5);
        repository.save(movie6);
        repository.save(movie7);
        repository.save(movie8);
        repository.save(movie9);
        repository.save(movie10);
    }

    @Test
    public void shouldAddMovieIfManyMovies() {
        repository.save(movie11);
        ShowMoviesInfo[] actual = repository.getMovies();
        ShowMoviesInfo[] expected = new ShowMoviesInfo[]{movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8, movie9, movie10, movie11};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdIfManyMovies() {
        repository.removeById(6);
        ShowMoviesInfo[] actual = repository.getMovies();
        ShowMoviesInfo[] expected = new ShowMoviesInfo[]{movie1, movie2, movie3, movie4, movie5, movie7, movie8, movie9, movie10};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAllMoviesIfManyMovies() {
        ShowMoviesInfo[] actual = repository.findAll();
        ShowMoviesInfo[] expected = new ShowMoviesInfo[]{movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8, movie9, movie10};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveAllIfManyMovies() {
        repository.removeAll();
        ShowMoviesInfo[] actual = repository.getMovies();
        ShowMoviesInfo[] expected = new ShowMoviesInfo[]{};
        assertArrayEquals(expected, actual);
    }

//    @Test
//    shouldFindNoExistByIdIfManyMovies() {
//        ShowMoviesInfo actual = repository.findById(5);
//        ShowMoviesInfo expected = movie5;
//        assertEquals(expected, actual);
//    }

}


