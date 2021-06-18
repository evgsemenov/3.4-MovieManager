package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ShowMovies {
    private int id;
    private int movieId;
    private String movieName;
    private String genre;
    private String posterUrl;
    private boolean premierIsTomorrow;
}
