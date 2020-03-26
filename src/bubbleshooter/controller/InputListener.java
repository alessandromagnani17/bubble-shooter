package bubbleshooter.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class InputListener implements MouseListener, MouseMotionListener {

    @Override
    public void mouseClicked(final MouseEvent e) {
        System.out.println(e.getX() + ", " + e.getY());
    }

    @Override
    public void mouseEntered(final MouseEvent e) {
    }

    @Override
    public void mouseDragged(final MouseEvent e) {
        //mouseMoved(e);
    }

    @Override
    public void mouseMoved(final MouseEvent e) {
        //repaint();
    }

    @Override
    public void mousePressed(final MouseEvent e) {
    }

    @Override
    public void mouseReleased(final MouseEvent e) {
    }

    @Override
    public void mouseExited(final MouseEvent e) {
    }
}
