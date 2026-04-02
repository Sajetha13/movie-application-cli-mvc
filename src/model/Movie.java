package model;

public class Movie {
    private int id;
    private String title;
    private String genre;
    private int rankNumber;

    public Movie(int id, String title, String genre, int rankNumber) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.rankNumber = rankNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getRankNumber() {
        return rankNumber;
    }

    public void setRankNumber(int rankNumber) {
        this.rankNumber = rankNumber;
    }
}
