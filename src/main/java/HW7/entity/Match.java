package HW7.entity;

public abstract class Match {
    protected Club firstClub;
    protected Club secondClub;

    public Match(Club firstClub, Club secondClub) {
        this.firstClub = firstClub;
        this.secondClub = secondClub;
    }

    protected abstract void setMatch(int[] scores);
    protected abstract boolean checkMatch(int[] scores);

    protected void setMatch(Result resultMatch) {
        switch (resultMatch) {
            case WIN -> {
                firstClub.setResult(Result.WIN);
                secondClub.setResult(Result.LOSE);
            }
            case DRAW -> {
                firstClub.setResult(Result.DRAW);
                secondClub.setResult(Result.DRAW);
            }
            case LOSE -> {
                firstClub.setResult(Result.LOSE);
                secondClub.setResult(Result.WIN);
            }
        }
    }
}
