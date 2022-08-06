package HW7.entity;

import java.util.Arrays;

public class ClubList {
    private Club[] clubs = new Club[100];
    private int index = 0;

    public Club get(Club club) {
        for (int i = 0; i < index; i++) {
            if (club.equals(clubs[i]))
                return clubs[i];
        }
        return null;
    }


    public Club[] getLeague(LeagueName leagueName) {
        Club[] leagueTeams = new Club[index];
        int indexOfLeague = 0;
        for (int i = 0; i < index; i++) {
            if (clubs[i].getLeague() == leagueName)
                leagueTeams[indexOfLeague++] = clubs[i];
        }
        if (isEmpty() || leagueTeams[0] == null)
            return null;
        else return sortClub(leagueTeams);
    }

    public boolean add(Club club) {
        if (index == clubs.length)
            clubs = Arrays.copyOf(clubs, clubs.length + 100);
        if (!checkClub(club)) {
            clubs[index] = club;
            index++;
            return true;
        } else return false;
    }

    public void update(Club club) {
        for (int i = 0; i < index; i++)
            if (club.equals(clubs[i]))
                clubs[i] = club;
    }

    public boolean remove(Club club) {
        int indexOfClub = getClubIndex(club);
        if (indexOfClub == -1)//If indexOfClub equals -1 , it means no club found.
            return false;
        else {
            for (int i = indexOfClub; i < index; i++)
                clubs[i] = clubs[i + 1];
            clubs[index--] = null;
            return true;
        }
    }

    private int getClubIndex(Club club) {
        for (int i = 0; i < index; i++) {
            if (club.equals(club))
                return i;
        }
        return -1;
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public boolean checkClub(Club club) {
        for (int i = 0; i < index; i++) {
            if (club.equals(this.clubs[i]))
                return true;
        }
        return false;
    }

    private int size() {
        return index;
    }

    private Club[] sortClub(Club[] leagueTeams) {//Sort clubs with selection sort (score, descending)
        int size = 0;
        for (Club c : leagueTeams)
            if (c!=null)
                size++;
        for (int i = 0; i < size - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < size; j++) {
                if (leagueTeams[j].getScore() > leagueTeams[min_idx].getScore())
                    min_idx = j;
            }
            Club temp = leagueTeams[i];
            leagueTeams[i] = leagueTeams[min_idx];
            leagueTeams[min_idx] = temp;
        }
        return leagueTeams;
    }

    public boolean setMatch(Club club, Club opponentClub, int clubPoints, int opponentClubPoints) {
        if (club.setMatch(opponentClub, clubPoints, opponentClubPoints)) {
            update(club);
            update(opponentClub);
            return true;
        } else return false;
    }
}
