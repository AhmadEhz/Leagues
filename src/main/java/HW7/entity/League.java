package HW7.entity;

public abstract class League {
    Club [] clubs = new Club[100];

    public Club[] getClubs() {
        return clubs;
    }

    public void setClubs(Club[] clubs) {
        this.clubs = clubs;
    }
}
