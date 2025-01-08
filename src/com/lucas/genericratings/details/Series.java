package com.lucas.genericratings.details;

public class Series extends Title{
    private int seasons;
    private int averageDuration;
    private int numberEpisodes;

    public Series(String titleName, int releaseDate) {
        super(titleName, releaseDate);
    }

    public int getSeasons() {
        return seasons;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public int getAverageDuration() {
        return averageDuration;
    }

    public void setAverageDuration(int averageDuration) {
        this.averageDuration = averageDuration;
    }

    public int getNumberEpisodes() {
        return numberEpisodes;
    }

    public void setNumberEpisodes(int numberEpisodes) {
        this.numberEpisodes = numberEpisodes;
    }

    @Override
    public int getLength() {
        return seasons * averageDuration * numberEpisodes;
    }

}
