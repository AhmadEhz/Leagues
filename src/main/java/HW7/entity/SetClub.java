package HW7.entity;

import HW7.entity.football.FootballClub;
import HW7.entity.volleyball.VolleyballClub;


public class SetClub {
    public static Club[] setClubs(Club firstClub, Club secondClub) {

        if (firstClub instanceof FootballClub) {
            FootballClub[] clubs = new FootballClub[2];
            return clubs;
        } else if (firstClub instanceof VolleyballClub) {
            VolleyballClub[] clubs = new VolleyballClub[2];
            return clubs;
        }
        return null;
    }

    public static Club setClub(LeagueName league) {
        if (league == LeagueName.FOOTBALL) {
            FootballClub club = new FootballClub();
            return club;
        } else if (league == LeagueName.VOLLEYBALL) {
            VolleyballClub club = new VolleyballClub();
            return club;
        }
        return null;
    }
    public static Club setClub(String name, LeagueName league) {
        if (league == LeagueName.FOOTBALL) {
            FootballClub club = new FootballClub(name);
            return club;
        } else if (league == LeagueName.VOLLEYBALL) {
            VolleyballClub club = new VolleyballClub();
            return club;
        }
        return null;
    }
}
