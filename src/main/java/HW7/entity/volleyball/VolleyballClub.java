package HW7.entity.volleyball;

import HW7.entity.Club;
import HW7.entity.LeagueName;
import HW7.entity.Result;

import java.util.Objects;

public class VolleyballClub extends Club {
    public VolleyballClub (String name) {
        super(name, LeagueName.VOLLEYBALL);
    }
    public VolleyballClub() {}
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
    public void setMatch(Club opponentClub, int point, int opponentPoint) {
        if (point > opponentPoint)
            setMatchToSetResult(opponentClub, point, opponentPoint, Result.WIN);
        else setMatchToSetResult(opponentClub, point, opponentPoint, Result.LOSE);
    }

    @Override
    public boolean checkMatch(Club opponentClub, int point, int opponentPoint) {
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
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        VolleyballClub that = (VolleyballClub) object;
        return Objects.equals(getName(), that.getName());
    }

    public int hashCode() {
        return Objects.hash(super.hashCode());
    }
}
