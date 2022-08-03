package HW7.entity.volleyball;

import HW7.entity.Club;
import HW7.entity.Match;

public class VolleyballMatch extends Match {

    public VolleyballMatch(Club firstClub, Club secondClub) {
        super(firstClub, secondClub);
    }

    @Override
    public void setMatch(int[] scores) {

    }
    @Override
    public boolean checkMatch(int[] scores) {
        return (scores[0]==3&&scores[1]<3)||(scores[1] != 3 && scores[0]<3);
    }
}
