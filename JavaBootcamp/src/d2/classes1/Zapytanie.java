package d2.classes1;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

/**
 * Created by exitle on 22.10.17.
 */
public class Zapytanie {
    private String user;
    private String email;
    private LocalDate date;


    public Zapytanie(String user, String email) {
        this.user = user;
        this.email = email;
        this.date = LocalDate.now();
    }

    public boolean is2WeeksOld() {
        Period p = Period.between(LocalDate.now(), this.date);
        if (p.getYears() > 0 || p.getMonths() > 0 || p.getDays() > 14) {
            return false;
        } else {
            return true;
        }
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDate() {
        return date;
    }
}
