package HW7.entity.football;

import HW7.entity.Club;
import HW7.entity.Match;
import HW7.entity.Result;

public class FootballMatch extends Match {

    public FootballMatch(FootballClub firstClub, FootballClub secondClub) {
        super(firstClub,secondClub);
    }

    public void setMatch(int[] result) {
        int firstClubScores = result[0];
        int secondClubScores = result[1];
        if (firstClubScores > secondClubScores)
            setMatch(Result.WIN);
        else if (firstClubScores < secondClubScores)
            setMatch(Result.LOSE);
        else setMatch(Result.DRAW);
    }
    @Override
    public boolean checkMatch(int[] result) {
        return true;
    }
}
