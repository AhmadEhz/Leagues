package HW7;

import HW7.entity.Club;
import HW7.entity.LeagueName;

public class Utility {
    boolean addMatch(Club club, Club opponentClub, String result) {
        int[] points = setResult(result);

        if (!club.checkMatch(opponentClub, points[0], points[1]))
            return false;
        else club.setMatch(opponentClub, points[0], points[1]);
        return true;
    }

    int[] setResult(String result) {
        int[] setResult = new int[2];
        String[] newResult = result.replaceAll("\\s", "").split("-");
        setResult[0] = Integer.parseInt(newResult[0]);
        setResult[1] = Integer.parseInt(newResult[1]);
        return setResult;
    }
        String [] getLeagueName() {
        String [] leagues = new String[LeagueName.values().length];
        int index = 0;
            for (LeagueName l:LeagueName.values()) {
                leagues[index++] = String.valueOf(l);

            }
            return leagues;
        }

}
