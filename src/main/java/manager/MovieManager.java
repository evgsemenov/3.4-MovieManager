package manager;

import domain.ShowMovies;
import lombok.Data;

@Data

public class MovieManager {
    int maxLength = 10;

    private ShowMovies[] movies = new ShowMovies[0];

    public void addMovie(ShowMovies movie) {
        int resultLength = movies.length + 1;
        ShowMovies[] tmp = new ShowMovies[resultLength];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public int setMaxLength(int newMaxLength) {
        if (newMaxLength < 0) {
            return maxLength;
        }
        maxLength = newMaxLength;
        return maxLength;
    }

    public ShowMovies[] showLatest() {
        maxLength = setMaxLength(10);
        int resultLength;
        if (movies.length > maxLength) {
            resultLength = maxLength;
        } else
            resultLength = movies.length;
        ShowMovies[] result = new ShowMovies[resultLength];
        for (int i = 0; i < resultLength; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }
}