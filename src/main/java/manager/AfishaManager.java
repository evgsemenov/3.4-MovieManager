package manager;

import domain.ShowMoviesInfo;
import lombok.Data;
import lombok.NoArgsConstructor;
import repository.AfishaRepository;

@Data
@NoArgsConstructor

public class AfishaManager {
    int maxLength = 10;
    private AfishaRepository repository;

    public AfishaManager(AfishaRepository repository) {
        this.repository = repository;
    }

    public AfishaManager(int maxLength) {
        this.maxLength = maxLength;
    }

    public int setMaxLength(int userMaxLength) {
        if (userMaxLength < 0) {
            return maxLength;
        } else {
            maxLength = userMaxLength;
        }
        return maxLength;
    }

    public ShowMoviesInfo[] findAll() {
        ShowMoviesInfo[] movies = repository.findAll();
        int resultLength;
        if (movies.length > maxLength) {
            resultLength = maxLength;
        } else {
            resultLength = movies.length;
        }
        ShowMoviesInfo[] result = new ShowMoviesInfo[resultLength];
        for (int i = 0; i < resultLength; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }

    public void save(ShowMoviesInfo movie) {
        repository.save(movie);
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public void removeAll() {
        repository.removeAll();
    }
}

