package HW7.entity.football;

import HW7.entity.Club;
import HW7.entity.Result;

import java.util.Objects;

public class FootballClub extends Club {
    private int draw;

    public FootballClub() {
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public void setDraw() {
        draw++;
    }

    @Override
    public void setResult(Result resultMatch) {
        setPlay();
        switch (resultMatch) {
            case WIN -> {
                setWin();
                setScore(getScore() + 3);
            }
            case DRAW -> {
                setDraw();
                setScore(getScore() + 1);
            }
            case LOSE -> setLose();
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FootballClub that = (FootballClub) o;
        return draw == that.draw;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), draw);
    }
}
