package ba.unsa.etf.rpr;

public  class VlastitaZivotinja extends Zivotinja {

    public VlastitaZivotinja(String id, String ime) throws NeispravanFormatIdaException {
        super(id, ime);
    }

    @Override
    public String glas() {
        return null;
    }
}
