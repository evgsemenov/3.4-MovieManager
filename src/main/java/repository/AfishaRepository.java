package repository;

import domain.ShowMoviesInfo;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor

public class AfishaRepository {
    private ShowMoviesInfo[] movies = new ShowMoviesInfo[0];

    public void save(ShowMoviesInfo movie) {
        int resultLength = movies.length + 1;
        ShowMoviesInfo[] tmp = new ShowMoviesInfo[resultLength];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public ShowMoviesInfo[] findAll() {
        return movies;
    }

    public void removeById(int id) {
        int length = movies.length - 1;
        ShowMoviesInfo[] tmp = new ShowMoviesInfo[length];
        int index = 0;
        for (ShowMoviesInfo movie : movies) {
            if (movie.getId() != id) {
                tmp[index] = movie;
                index++;
            }
            movies = tmp;
        }
    }

//    public ShowMoviesInfo[] findById(int id) {
//        for (ShowMoviesInfo movie : movies) {
//            if (movie.getId() == id) {
//                return movie;
//            }
//        }
//        return null;
//    }

    public void removeAll() {
        movies = new ShowMoviesInfo[0];
    }
}



