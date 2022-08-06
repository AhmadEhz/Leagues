package HW7.entity;

import java.util.Objects;

public class VolleyballClub extends Club {
    public VolleyballClub(String name) {
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
        if (!checkMatchResult(opponentClub, point, opponentPoint))
            return false;
        if (point > opponentPoint)
            setMatchToSetResult(opponentClub, point, opponentPoint, Result.WIN);
        else setMatchToSetResult(opponentClub, point, opponentPoint, Result.LOSE);
        return true;
    }

    @Override
    public boolean checkMatchResult(Club opponentClub, int clubPoints, int opponentClubPoints) {
        if (isNull())
            return false;
        if (opponentClub instanceof VolleyballClub)
            if ((clubPoints == 3 && opponentClubPoints < 3) || (opponentClubPoints == 3 & clubPoints < 3))
                return true;
        return false;
    }

    @Override
    public String toString() {
        return getName() + " --> " +
                "Plays: " + getPlay() + " | " +
                "Wins: " + getWin() + " | " +
                "Loses: " + getLose() + " | " +
                "Score: " + getScore();
    }

    @Override
    public boolean equals(Object club) {
        if (this == club) return true;
        if (club == null || getClass() != club.getClass()) return false;
        return getName().equalsIgnoreCase(((VolleyballClub) club).getName()) && getLeague().equals(((VolleyballClub) club).getLeague());
    }

    public int hashCode() {
        return Objects.hash(super.hashCode());
    }
}
