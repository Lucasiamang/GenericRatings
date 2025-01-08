package com.lucas.genericratings.profile;

import com.lucas.genericratings.details.Title;

public class TimeWatched {
    private int sumTime;

    public int getSumTime() {
        return sumTime;
    }

    public void calcTime(Title t){

        sumTime += t.getLength();

    }

}
