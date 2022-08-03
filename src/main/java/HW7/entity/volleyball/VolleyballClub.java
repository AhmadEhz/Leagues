package HW7.entity.volleyball;

import HW7.entity.Club;
import HW7.entity.Result;

import java.util.Objects;

public class VolleyballClub extends Club {
    @Override
    public void setResult(Result resultMatch) {

    }

    @Override
    public String toString() {
        return null;
    }
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        VolleyballClub that = (VolleyballClub) object;
        return Objects.equals(getName(), that.getName());
    }
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }
}
