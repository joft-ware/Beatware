package com.company;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.logging.Logger;


public class KeyListener extends KeyAdapter {
    Logger logger = Logger.getLogger("");
    @Override
    public void keyPressed(KeyEvent e) {
        if(Beatware.game==null)
            return;
        if(e.getKeyCode()==KeyEvent.VK_S) {
            Beatware.game.pressS();
        }
        else if(e.getKeyCode()==KeyEvent.VK_D) {
            Beatware.game.pressD();
        }
        else if(e.getKeyCode()==KeyEvent.VK_F) {
            Beatware.game.pressF();
        }
        else if(e.getKeyCode()==KeyEvent.VK_SPACE) {
            Beatware.game.pressSpace();
        }
        else if(e.getKeyCode()==KeyEvent.VK_J) {
            Beatware.game.pressJ();
        }
        else if(e.getKeyCode()==KeyEvent.VK_K) {
            Beatware.game.pressK();
        }
        else if(e.getKeyCode()==KeyEvent.VK_L) {
            Beatware.game.pressL();
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {
        if(Beatware.game==null)
            return;
        if(e.getKeyCode()==KeyEvent.VK_S) {
            Beatware.game.releaseS();
        }
        else if(e.getKeyCode()==KeyEvent.VK_D) {
            Beatware.game.releaseD();
        }
        else if(e.getKeyCode()==KeyEvent.VK_F) {
            Beatware.game.releaseF();
        }
        else if(e.getKeyCode()==KeyEvent.VK_SPACE) {
            Beatware.game.releaseSpace();
        }
        else if(e.getKeyCode()==KeyEvent.VK_J) {
            Beatware.game.releaseJ();
        }
        else if(e.getKeyCode()==KeyEvent.VK_K) {
            Beatware.game.releaseK();
        }
        else if(e.getKeyCode()==KeyEvent.VK_L) {
            Beatware.game.releaseL();
        }
    }
}
