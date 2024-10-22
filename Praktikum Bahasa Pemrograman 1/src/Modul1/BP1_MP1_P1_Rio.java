package Modul1;
import java.awt.*;
public class BP1_MP1_P1_Rio extends Frame {
    public static void main (String[] args){
        BP1_MP1_P1_Rio test = new BP1_MP1_P1_Rio();
    }
    public BP1_MP1_P1_Rio(){
        super("BP1_MP1_P1_Rio");
        setSize (300, 100);
        Panel panelTombol = new Panel();
        panelTombol.add(new Button ("Mulai"));
        panelTombol.add(new Button ("Selesai"));
        add("East", panelTombol);
        show();
    }
}
