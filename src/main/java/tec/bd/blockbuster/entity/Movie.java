package tec.bd.blockbuster.entity;

import java.util.Date;

public class Movie {

    private long movieId;
    private String title;
    private Date releaseDate;
    private Long category;

    public Movie(long movieId, String title) {
        this.movieId = movieId;
        this.title = title;
    }

    public Movie(String title, Date releaseDate, Long category) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.category = category;
    }

    public Movie(long movieId, String title, Date releaseDate, Long category) {
        this.movieId = movieId;
        this.title = title;
        this.releaseDate = releaseDate;
        this.category = category;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }
}