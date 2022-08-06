package HW7.util;

import HW7.entity.*;


public class SetClub {
    private static Club initialClub(LeagueName league) {//If you want to add a league, add the same as FootballClub and VolleyballClub.
        if (league == LeagueName.FOOTBALL) {
            return new FootballClub();
        } else if (league == LeagueName.VOLLEYBALL) {
            return new VolleyballClub();
        }
        else if(league == LeagueName.BASKETBALL) {
            return new BasketballClub();
        }
        else return null;
    }

    public static Club setClub(LeagueName league) {
        return initialClub(league);
    }
    public static Club setClub(String clubName, LeagueName league) {
        Club club = initialClub(league);
        if (club != null)
            club.setName(clubName);
        return club;
    }
}
