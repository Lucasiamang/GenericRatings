package com.lucas.genericratings.details;

public class Movie extends Title{
    private String director;
    private String mainActor;

    public Movie(String titleName, int releaseDate) {
        super(titleName, releaseDate);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getMainActor() {
        return mainActor;
    }

    public void setMainActor(String mainActor) {
        this.mainActor = mainActor;
    }

}
