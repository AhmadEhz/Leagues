package HW7.entity.football;

import HW7.entity.Club;
import HW7.entity.LeagueName;
import HW7.entity.Result;

import java.util.Objects;

public class FootballClub extends Club {
    private int draw;
    public FootballClub (String name) {
        super(name, LeagueName.FOOTBALL);
    }
    public FootballClub() {}

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
        return "Name:" + getName() + "\n" +
                "Plays: " + getPlay() + "\n" +
                "Wins: " + getWin() + "\n" +
                "Loses: " + getLose() + "\n" +
                "Draws: " + getDraw() + "\n" +
                "Score: " + getScore();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        FootballClub that = (FootballClub) object;
        return Objects.equals(getName(), that.getName());
    }

    @Override
    public void setMatch(Club opponentClub, int point, int opponentPoint) {//Set the result match and pass it to setMatch.
        if (point> opponentPoint)
            setMatchToSetResult(opponentClub, point, opponentPoint, Result.WIN);
        else if (point < opponentPoint)
            setMatchToSetResult(opponentClub, point, opponentPoint, Result.LOSE);
        else setMatchToSetResult(opponentClub, point, opponentPoint, Result.DRAW);
    }

    @Override
    public boolean checkMatch(Club opponentClub, int point, int opponentPoint) {//In football, any point are accepted.
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), draw);
    }
}
