package HW7.entity;

import HW7.entity.football.FootballClub;
import HW7.entity.volleyball.VolleyballClub;


public class SetClubs {
    public static Club[] setClubs (Club firstClub, Club secondClub) {
        Club [] clubs = null;
        if (firstClub instanceof FootballClub)
            clubs = new FootballClub[2];
        else if (firstClub instanceof VolleyballClub)
            clubs = new VolleyballClub [2];
        return clubs;
    }
}
