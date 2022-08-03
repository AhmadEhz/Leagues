package HW7.entity;

import java.util.Objects;

public abstract class Club {
    private String name;
    private int score;
    private int play;
    private int win;
    private int lose;
    private int winScore;

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

    public int getPlay() {
        return play;
    }

    public void setPlay(int play) {
        this.play = play;
    }
    public void setPlay() {
        play++;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }
    public void setWin() {
        win++;
    }

    public int getLose() {
        return lose;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }
    public void setLose() {
        lose++;
    }

    public int getWinScore() {
        return winScore;
    }

    public void setWinScore(int winScore) {
        this.winScore = winScore;
    }
    public abstract void setResult(Result resultMatch);

    @Override
    public abstract String toString();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Club club = (Club) o;
        return score == club.score && play == club.play && win == club.win && lose == club.lose && Objects.equals(name, club.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score, play, win, lose);
    }
}
