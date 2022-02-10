/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectoAnimacion;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class OyenteTeclado implements KeyListener{
    Principal juego;

    public OyenteTeclado(Principal ventanaJuego) {
        this.juego = ventanaJuego;
    }   
   
    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent evento) {
        if(evento.getKeyCode()==KeyEvent.VK_LEFT){          
           juego.moverIzquierda();
        }
        if(evento.getKeyCode()==KeyEvent.VK_RIGHT){
           juego.moverDerecha();
        }
        if(evento.getKeyCode()==KeyEvent.VK_UP){
           juego.moverArriba();
        }
        if(evento.getKeyCode()==KeyEvent.VK_DOWN){
           juego.moverAbajo();
        }
        if(evento.getKeyCode()==KeyEvent.VK_ESCAPE){
         juego.dispose();
        }
        if(evento.getKeyCode()==KeyEvent.VK_SPACE){
         juego.teclaEspacio();
        }       
    }

    @Override
    public void keyReleased(KeyEvent ke) {
       juego.bailando();
    }    
}