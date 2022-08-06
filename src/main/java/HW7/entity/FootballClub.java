package HW7.entity;

import java.util.Objects;

public class FootballClub extends Club {
    private int draw;

    public FootballClub(String name) {
        super(name, LeagueName.FOOTBALL);
    }

    public FootballClub() {
        super(LeagueName.FOOTBALL);
    }

    public int getDraw() {
        return draw;
    }

    public void addDraw(int draw) {
        this.draw = draw;
    }

    public void addDraw() {
        draw++;
    }

    @Override
    protected void setResult(int goal, int opponentGoal, Result resultMatch) {
        addPlay();
        switch (resultMatch) {
            case WIN -> {
                addWin();
                addScore(3);
            }
            case DRAW -> {
                addDraw();
                addScore(1);
            }
            case LOSE -> addLose();
        }
    }

    @Override
    public String toString() {
        return  getName() + " --> " +
                " P: " + getPlay() + " | " +
                " W: " + getWin() + " | " +
                " L: " + getLose() + " | " +
                " D: " + getDraw() + " | " +
                "S: " + getScore();
    }

    @Override
    public boolean equals(Object club) {
        if (this == club) return true;
        if (club == null || getClass() != club.getClass()) return false;
        return getName().equalsIgnoreCase(((FootballClub) club).getName()) && getLeague().equals(((FootballClub) club).getLeague());
    }

    @Override
    public boolean setMatch(Club opponentClub, int point, int opponentPoint) {//Set the result match and pass it to setMatch.
        if (!checkMatchResult(opponentClub, point, opponentPoint))
            return false;
        if (point > opponentPoint)
            setMatchToSetResult(opponentClub, point, opponentPoint, Result.WIN);
        else if (point < opponentPoint)
            setMatchToSetResult(opponentClub, point, opponentPoint, Result.LOSE);
        else setMatchToSetResult(opponentClub, point, opponentPoint, Result.DRAW);
        return true;
    }

    @Override
    public boolean checkMatchResult(Club opponentClub, int point, int opponentPoint) {//In football, any point are accepted.
        if (isNull())
            return false;
        return opponentClub instanceof FootballClub;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), draw);
    }
}
