package manager;

import domain.ShowMovies;

public class MovieManager {
    private ShowMovies[] movies = new ShowMovies[0];
    public void addMovie(ShowMovies movie) {
        int resultLength = movies.length + 1;
        ShowMovies[] tmp = new ShowMovies[resultLength];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public ShowMovies[] showLatest() {
        int maxLength = 10;
        int resultLength;
        if (movies.length > maxLength) {
            resultLength = maxLength;
        } else
            resultLength = movies.length;
        ShowMovies[] result = new ShowMovies[movies.length];
        for (int i = 0; i < resultLength; i++) {
            int index = resultLength - i - 1;
            result[i] = movies[index];
        }
        return result;
    }
}