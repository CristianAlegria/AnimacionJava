/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectoAnimacion;
/////////////////MP3/////////////////////////
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

//////////////////SONIDO WAV/////////////////
import java.applet.AudioClip;
////////////////////////////////////////////

public class Sonido extends Thread{    
    String ruta;
    public Sonido(String ruta) {
        this.ruta=ruta;
    }
    
    public void run() {
       // musicaDeFondo();
        while(true){
          reproducirSonido();     
        }       
    }    
    public  void reproducirSonido(){
       
             try {
                FileInputStream fis;
                Player player;
                 fis = new FileInputStream(ruta);
                BufferedInputStream bis = new BufferedInputStream(fis);

                player = new Player(bis);
                player.play();         
            } catch (JavaLayerException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
       
    }
  /*  public  void sonidoGorila(){
    
           try {
            FileInputStream fis;
            Player player;
            fis = new FileInputStream("C:\\Users\\User\\Desktop\\Animacion Actualizacion 5\\proyectoFinalAnimacion\\src\\Sonidos\\animals028.mp3");
            BufferedInputStream bis = new BufferedInputStream(fis);

            player = new Player(bis);
            player.play();         
        } catch (JavaLayerException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }    
    
    }*/
    Thread gorila = new Thread(){
        public void run() {
            //sonidoGorila();             
       }  
    };

    public Thread getGorila() {
        return gorila;
    }

    public void setGorila(Thread gorila) {
        this.gorila = gorila;
    }

   
    
    
  
}
