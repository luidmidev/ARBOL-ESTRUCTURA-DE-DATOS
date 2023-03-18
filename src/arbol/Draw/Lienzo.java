/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.Draw;

import java.awt.Graphics;
import javax.swing.JPanel;
import arbol.*;

/**
 *
 * @author daniel
 */
public class Lienzo extends JPanel {

    private Arbol objArbol;
    public static final int DIAMETRO = 30;
    public static final int RADIO = DIAMETRO / 2;
    public static final int ANCHO = 50;

    public void setObjArbol(Arbol objArbol) {
        this.objArbol = objArbol;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); 
        pintar(g, getWidth() / 2, 20, objArbol.getRaiz());
    }

    private void pintar(Graphics g, int x, int y, Nodo n) {
        if (n == null) {
        } else {
            int EXTRA = Arbol.nodosCompletos(n) * (ANCHO / 2);
            g.drawOval(x, y, DIAMETRO, DIAMETRO);
            g.drawString(n.getDato().toString(), x + 9, y + 20);
            if (n.gethIzq() != null) {
                g.drawLine(x + RADIO - 2, y + RADIO * 2, x - ANCHO - EXTRA + RADIO, y + ANCHO);
            }
            if (n.gethDer() != null) {
                g.drawLine(x + RADIO + 2, y + RADIO * 2, x + ANCHO + EXTRA + RADIO, y + ANCHO);
            }
            pintar(g, x - ANCHO - EXTRA, y + ANCHO, n.gethIzq());
            pintar(g, x + ANCHO + EXTRA, y + ANCHO, n.gethDer());
        }
    }
}
