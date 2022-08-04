package HW7.entity.volleyball;

import HW7.entity.Club;
import HW7.entity.LeagueName;
import HW7.entity.Result;
import HW7.entity.football.FootballClub;

import java.util.Objects;

public class VolleyballClub extends Club {
    public VolleyballClub (String name) {
        super(name, LeagueName.VOLLEYBALL);
    }
    public VolleyballClub() {
        super(LeagueName.VOLLEYBALL);
    }
    @Override
    protected void setResult(int point, int opponentPoint, Result resultMatch) {
        addPlay();
        switch (resultMatch) {
            case WIN -> {
                addWin();
                if (opponentPoint < 2)
                    addScore(3);
                else addScore(2);
            }
            case LOSE -> {
                addLose();
                if (point == 2)
                    addScore(1);
            }
        }
    }

    @Override
    public boolean setMatch(Club opponentClub, int point, int opponentPoint) {
        if (!checkMatch(opponentClub,point,opponentPoint))
            return false;
        if (point > opponentPoint)
            setMatchToSetResult(opponentClub, point, opponentPoint, Result.WIN);
        else setMatchToSetResult(opponentClub, point, opponentPoint, Result.LOSE);
        return true;
    }

    @Override
    public boolean checkMatch(Club opponentClub, int point, int opponentPoint) {
        if (isNull())
            return false;
        if (opponentClub instanceof VolleyballClub)
            if ((point == 3 && opponentPoint < 3) ||(opponentPoint == 3 & point < 3))
                return true;
        return false;
    }

    @Override
    public String toString() {
        return "Name:" + getName() + "\n" +
                "Plays: " + getPlay() + "\n" +
                "Wins: " + getWin() + "\n" +
                "Loses: " + getLose() + "\n" +
                "Score: " + getScore();
    }

    @Override
    public boolean equals(Object club) {
        if (this == club) return true;
        if (club == null || getClass() != club.getClass()) return false;
        return getName() == ((VolleyballClub) club).getName() && getLeague() == ((VolleyballClub) club).getLeague() ;
    }

    public int hashCode() {
        return Objects.hash(super.hashCode());
    }
}
