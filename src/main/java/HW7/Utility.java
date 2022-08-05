package HW7;

import HW7.entity.Club;
import HW7.entity.LeagueName;

import java.util.Scanner;

public class Utility {
    boolean addMatch(Club club, Club opponentClub, String result) {
        int[] points = setResult(result);

        if (!club.checkResult(opponentClub, points[0], points[1]))
            return false;
        else return club.setMatch(opponentClub, points[0], points[1]);
    }

    int[] setResult(String result) {
        int[] setResult = new int[2];
        String[] newResult = result.replaceAll("\\s", "").split("-");
        setResult[0] = Integer.parseInt(newResult[0]);
        setResult[1] = Integer.parseInt(newResult[1]);
        return setResult;
    }

    String[] getLeagueNames() {
        String[] leagues = new String[LeagueName.values().length];
        int index = 0;
        for (LeagueName l : LeagueName.values()) {
            leagues[index++] = String.valueOf(l);

        }
        return leagues;
    }

    int getLeagueNumber() {
        return LeagueName.values().length;
    }

    String getLeagueName(int number) {
        String[] leagueNames = getLeagueNames();
        return leagueNames[number];
    }
    public LeagueName getLeague(int id) {
        return LeagueName.valueOf(getLeagueName(id));
    }

}
