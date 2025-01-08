package com.lucas.genericratings.details;

public class Title implements Comparable<Title>{

    private String titleName;
    private int length;
    private int releaseDate;
    private String dateYear;
    private boolean isSub;
    private double averageRating;
    private double totalRating;

    public Title(TitleOMDB actualTitle) {
        this.titleName = actualTitle.title();
        this.dateYear = actualTitle.year();
        this.length = Integer.valueOf(actualTitle.runtime().substring(0,2));
        this.averageRating = actualTitle.metascore();
        this.totalRating = actualTitle.imdbVotes();
    }

    @Override
    public int compareTo(Title name) {
        return this.getTitleName().compareTo(name.getTitleName());
    }

    public Title(String titleName, int releaseDate) {
        this.titleName = titleName;
        this.releaseDate = releaseDate;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }


    public boolean isSub() {
        return isSub;
    }

    public String getTitleName() {
        return titleName;
    }

    public int getLength() {
        return length;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void showDetails(){
        System.out.println("name: " + titleName);
        System.out.println("title length: " + getLength() + "min.");
        System.out.println("release date: " + releaseDate);

    }

    public double getTotalRating(){
        return totalRating;

    }
    public double getAverageRating(){
        return averageRating;

    }


    @Override
    public String toString() {
        return
                "name= " + titleName + '\'' +
                ", length= " + length + " min." +
                ", release date= " + dateYear +
                ", Rating=" + averageRating +
                '}';
    }
}
