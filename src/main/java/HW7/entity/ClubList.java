package HW7.entity;

import java.util.Arrays;

public class ClubList {
    private Club[] clubs = new Club[100];
    private int index = 0;

    public Club get(int index) {
        return clubs[index];
    }
    public Club get(Club club) {
        for (int i = 0; i < index; i++) {
            if(club.equals(clubs[i]))
                return clubs[i];
        }
        return null;
    }

    public Club[] getLeague(LeagueName leagueName) {
        Club[] league = new Club[index];
        int indexOfLeague = 0;
        for (int i = 0; i < index; i++) {
        if (clubs[i].getLeague() == leagueName)
            league[indexOfLeague++] = clubs[i];
        }
        return league;
    }

    public void add(Club club) {
        if (index == clubs.length)
            clubs = Arrays.copyOf(clubs, clubs.length + 100);
        clubs[index] = club;
        index++;
    }

    public void remove(int index) {
        if (index >= size()) {
            System.out.println("index not exist!");
            return;
        }
        for (int i = index; i < this.index; i++)
            clubs[i] = clubs[i + 1];
        this.index--;
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public boolean checkClub(int index) {
        if (index > this.index)
            return false;
        else return true;
    }

    private int size() {
        return index;
    }
}
