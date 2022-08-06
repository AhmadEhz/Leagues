package HW7.entity;

import java.util.Objects;

public class BasketballClub extends Club {

    public BasketballClub() {
        super(LeagueName.BASKETBALL);
    }

    @Override
    protected void setResult(int point, int opponentPoint, Result resultMatch) {
        addPlay();
        switch (resultMatch) {
            case WIN -> {
                addWin();
                addScore(3);
            }
            case LOSE -> addLose();
        }
    }

    @Override
    public boolean setMatch(Club opponentClub, int clubPoints, int opponentClubPoints) {
        if (checkMatchResult(opponentClub, clubPoints, opponentClubPoints))
            return false;
        if (clubPoints > opponentClubPoints)
            setMatchToSetResult(opponentClub, clubPoints, opponentClubPoints, Result.WIN);
        else if (clubPoints < opponentClubPoints)
            setMatchToSetResult(opponentClub, clubPoints, opponentClubPoints, Result.LOSE);
        return true;
    }

    @Override
    public boolean checkMatchResult(Club opponentClub, int clubPoints, int opponentClubPoints) {
        return clubPoints == opponentClubPoints || !(opponentClub instanceof BasketballClub);
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
        return getName().equalsIgnoreCase(((BasketballClub) club).getName()) && getLeague().equals(((BasketballClub) club).getLeague());
    }

    public int hashCode() {
        return Objects.hash(super.hashCode());
    }
}
