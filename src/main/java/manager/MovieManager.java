package manager;

import domain.ShowMoviesInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class MovieManager {
    int maxLength = 10;

    private ShowMoviesInfo[] movies = new ShowMoviesInfo[0];

    public void addMovie(ShowMoviesInfo movie) {
        int resultLength = movies.length + 1;
        ShowMoviesInfo[] tmp = new ShowMoviesInfo[resultLength];
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

    public ShowMoviesInfo[] showLatest() {
        int resultLength;
        if (movies.length > maxLength) {
            resultLength = maxLength;
        } else
            resultLength = movies.length;
        ShowMoviesInfo[] result = new ShowMoviesInfo[resultLength];
        for (int i = 0; i < resultLength; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }

    public MovieManager(int maxLength) {
        this.maxLength = maxLength;
    }
}