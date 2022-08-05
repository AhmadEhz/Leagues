package HW7.entity;

import HW7.entity.football.FootballClub;
import HW7.entity.volleyball.VolleyballClub;


public class SetClub {
    private static Club initialClub(LeagueName league) {//If you want to add a league, add the same as FootballClub and VolleyballClub.
        if (league == LeagueName.FOOTBALL) {
            FootballClub club = new FootballClub();
            return club;
        } else if (league == LeagueName.VOLLEYBALL) {
            VolleyballClub club = new VolleyballClub();
            return club;
        }
        else return null;
    }
    public static Club[] setClubs(String clubName, String opponentClubName, LeagueName league) {
        Club [] clubs = new Club [2];
        clubs[1] = initialClub(league);
        clubs[2] = initialClub(league);
        clubs[1].setName(clubName);
        clubs[2].setName(opponentClubName);
        return null;
    }

    public static Club setClub(LeagueName league) {
        return initialClub(league);
    }
    public static Club createClub(String clubName, LeagueName league) {
        Club club = initialClub(league);
        club.setName(clubName);
      return club;
    }
}
