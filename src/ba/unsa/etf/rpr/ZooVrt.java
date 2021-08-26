package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Supplier;

public class ZooVrt {
    private List<Zivotinja> lista = new ArrayList<>();

    public int broj() {
        return lista.size();
    }


    public String dajTabelu() {
String rezultat="";
for(Zivotinja z:lista){
    rezultat+=z.getIme() + " (";
    if(z instanceof Pas) rezultat+="Pas"+ ") " +": "+z.getId()+"\n";
    if(z instanceof Macka) rezultat+="Macka"+ ") "+": "+z.getId()+"\n";
    if(z instanceof Lav) rezultat+="Lav"+ ") "+": "+z.getId()+"\n";
    if(z instanceof DomacaMacka) rezultat+="DomacaMacka "+ ") "+": "+z.getId()+"\n";
    if(z instanceof Tigar) rezultat+="Tigar" + ") "+": "+z.getId()+"\n";
    if(z instanceof Vuk) rezultat+="Vuk" + ") "+": "+z.getId()+"\n";
    if(z instanceof DomaciPas) rezultat+="DomaciPas" + ") "+": "+z.getId()+"\n";

}
return rezultat;
    }
//sada pisemo dodaj u 4 varijante
    //prva varijanta je sa parametrom tipa Class, ime i id
    public void dodaj(Class vrstZivotinje,String ime, String id) throws NeispravanFormatIdaException {
        Zivotinja z=null;
        if(vrstZivotinje.getName().contains("DomaciPas"))
            z=new DomaciPas(id,ime);
        if(vrstZivotinje.getName().contains("DomacaMacka"))
            z=new DomacaMacka(id,ime);
        if(vrstZivotinje.getName().contains("Lav"))
            z=new Lav(id,ime);
        if(vrstZivotinje.getName().contains("Tigar"))
            z=new Tigar(id,ime);
        if(vrstZivotinje.getName().contains("Vuk"))
            z=new Vuk(id,ime);
       lista.add(z);
    }
    //druga varijanta dodaje objekat tipa zivotinja
    public void dodaj(Zivotinja z){
        lista.add(z);
    }
    //treca varijanta dodaj, ima samo vrstu i ime a id automatski se odredjuje

    public void dodaj(Class vrstZivotinje,String ime) throws NeispravanFormatIdaException {
        int id=nadjiNajveciId();
        String sId=Zivotinja.generisiId("ime")+"-"+id;
        dodaj(vrstZivotinje,ime,sId);

    }
    private static int numerickiDio(Zivotinja z){
        String id = z.getId(); //da dobijem id koji je string
        return Integer.parseInt(id.substring(id.indexOf('-') + 1));
    }

    private int nadjiNajveciId() {
        int max=0;
        for(Zivotinja z:lista) {
            int broj=ZooVrt.numerickiDio(z);
            if (broj > max) max = broj;
        }
        return max;

        }
    /*public void dodaj(String vrstaZivotinje, String id, String ime, Supplier<String>f){


    }*/

    public void obrisi(String id){
        for(Zivotinja z:lista)
            if (z.getId().equals(id)) {
                lista.remove(z);
            }
    }

public Set<Zivotinja> koToTamoGovori(String glasanje){
        Set<Zivotinja> set=new TreeSet<>();
        //sada razvajamo po zarezu
    for(String s:glasanje.split(",")){
        Zivotinja pronadjena=null;
        for(Zivotinja z:lista){
            if(z.glas().equals(s))
                if(pronadjena==null)
                pronadjena=z;
                else if(ZooVrt.numerickiDio(pronadjena)>ZooVrt.numerickiDio(z))
                    pronadjena=z;
        }
        if(pronadjena==null)
            throw new IllegalArgumentException("Nijedna zivotinja se ne glasa sa"+s);
        set.add(pronadjena);
    }
    return set;
}


}