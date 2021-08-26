package ba.unsa.etf.rpr;

public abstract class Zivotinja {
private String id;
private String ime;

    public Zivotinja(String id, String ime) throws NeispravanFormatIdaException {
        if(id.isBlank()) throw new IllegalArgumentException("Id ne može biti prazan");
        if(ime.isBlank()) throw new IllegalArgumentException("Ime ne može biti prazno");
        if(!provjeri(id,ime))throw new NeispravanFormatIdaException("Id nije ok");
        this.id = id;
        this.ime = ime;
    }

    private boolean provjeri(String id, String ime) {
        String novoIme="";
        for(int i=0;i<ime.length();i++){
            if(ime.charAt(i)>='a' && ime.charAt(i)<='z') novoIme+=ime.charAt(i);
            if(ime.charAt(i)>='A' && ime.charAt(i)<='Z') novoIme+=(char)(ime.charAt(i)+32);
            if(ime.charAt(i)=='č' || ime.charAt(i)=='ć' || ime.charAt(i)=='Č' || ime.charAt(i)=='Ć') novoIme+='c';
            if(ime.charAt(i)=='Š' || ime.charAt(i)=='š') novoIme+='s';
            if(ime.charAt(i)=='Ž' || ime.charAt(i)=='ž') novoIme+='z';
            if(ime.charAt(i)=='Đ' || ime.charAt(i)=='đ') novoIme+='d';
        }
        if(id.length()<=novoIme.length()+1) return false;
        if(!id.substring(0,novoIme.length()).equals(novoIme)) return false;
        if(id.charAt(novoIme.length())!='-') return false;
        for(int i=novoIme.length()+1;i<id.length();i++){
            if(id.charAt(i)<'0' || id.charAt(i)>'9') return false;
        }

return true;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) throws NeispravanFormatIdaException {
        if(id.isBlank()) throw new IllegalArgumentException("Id ne može biti prazan");
        if(!provjeri(id,ime))throw new NeispravanFormatIdaException("Id nije ok");

        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) throws NeispravanFormatIdaException {
        if(ime.isBlank()) throw new IllegalArgumentException("Ime ne može biti prazno");
        if(!provjeri(id,ime))throw new NeispravanFormatIdaException("Id nije ok");
        this.ime = ime;
    }
    public abstract String glas();
}
