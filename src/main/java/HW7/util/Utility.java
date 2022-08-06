package HW7.util;

import HW7.entity.Club;
import HW7.entity.LeagueName;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Utility {

    public void delay(int delayTime) {
        try {
            TimeUnit.SECONDS.sleep(delayTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String[] getLeagueNames() {
        String[] leagues = new String[LeagueName.values().length];
        int index = 0;
        for (LeagueName l : LeagueName.values()) {
            leagues[index++] = String.valueOf(l);

        }
        return leagues;
    }

    public int getLeagueNumber() {
        return LeagueName.values().length;
    }

    public String getLeagueName(int number) {
        String[] leagueNames = getLeagueNames();
        return leagueNames[number];
    }

    public LeagueName getLeague(int id) {
        return LeagueName.valueOf(getLeagueName(id));
    }

}
