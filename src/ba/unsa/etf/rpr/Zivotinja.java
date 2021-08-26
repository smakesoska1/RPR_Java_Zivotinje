package ba.unsa.etf.rpr;

public abstract class Zivotinja {
private String id;
private String ime;

    public Zivotinja(String id, String ime) {
        this.id = id;
        this.ime = ime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }
}
