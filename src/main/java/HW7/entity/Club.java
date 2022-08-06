package HW7.entity;

import java.util.Objects;

public abstract class Club {
    private String name;
    private int score;
    private int play;
    private int win;
    private int lose;
    private LeagueName league;
    public Club (String name,LeagueName league) {
        this.name = name;
        this.league = league;
    }
    public Club (LeagueName league) {
        this.league = league;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void addScore(int score) {
        this.score += score;
    }


    public LeagueName getLeague() {
        return league;
    }

    public void setType(LeagueName league) {
        this.league = league;
    }

    public int getPlay() {
        return play;
    }

    public void setPlay(int play) {
        this.play = play;
    }

    public void addPlay() {
        play++;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public void addWin() {
        win++;
    }

    public int getLose() {
        return lose;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }

    public void addLose() {
        lose++;
    }

    protected abstract void setResult(int point, int opponentPoint, Result resultMatch);//For add scores and wins and loses (and draws).

    public abstract boolean setMatch(Club opponentClub, int clubPoint, int opponentClubPoint);//index 0 for club points, index 1 for opponent club points

    public abstract boolean checkMatchResult(Club opponentClub, int point, int opponentPoint);

    protected void setMatchToSetResult(Club opponentClub, int point, int opponentPoint, Result resultMatch) {
        switch (resultMatch) {
            case WIN -> {
                setResult(point, opponentPoint, Result.WIN);
                opponentClub.setResult(opponentPoint, opponentPoint, Result.LOSE);
            }
            case DRAW -> {
                setResult(point, opponentPoint, Result.DRAW);
                opponentClub.setResult(opponentPoint, opponentPoint, Result.DRAW);
            }
            case LOSE -> {
                setResult(point, opponentPoint, Result.LOSE);
                opponentClub.setResult(opponentPoint, opponentPoint, Result.WIN);
            }
        }
    }

    @Override
    public abstract String toString();

    @Override
    public abstract boolean equals(Object object);

    @Override
    public int hashCode() {
        return Objects.hash(name, score, play, win, lose, league);
    }
    public boolean isNull() {
        return this == null;
    }
}
