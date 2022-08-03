package HW7.entity;

public abstract class Club {
    private String name;
    private int score;
    private int play;
    private int win;
    private int lose;

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
        this.score+=score;
    }

    public int getPlay() {
        return play;
    }

    public void addPlay(int play) {
        this.play = play;
    }

    public void addPlay() {
        play++;
    }

    public int getWin() {
        return win;
    }

    public void addWin(int win) {
        this.win = win;
    }

    public void addWin() {
        win++;
    }

    public int getLose() {
        return lose;
    }

    public void addLose(int lose) {
        this.lose = lose;
    }

    public void addLose() {
        lose++;
    }

    public abstract void setResult(Result resultMatch);

    @Override
    public abstract String toString();
    @Override
    public abstract boolean equals(Object object);
}
