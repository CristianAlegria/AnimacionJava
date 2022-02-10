/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectoAnimacion;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;


public class Imagen extends Thread{
    private int x;
    private int y;
    private int numerosSprites;
    private String carpeta;   
    InputStream imgStream;
    private Image img[];
    

    public Imagen(int x, int y, int numerosSprites, String carpeta) {
        this.x = x;
        this.y = y;
        this.numerosSprites = numerosSprites;
        this.carpeta = carpeta;
    }
   

    public Imagen() {
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getNumerosSprites() {
        return numerosSprites;
    }

    public Image[] getImg() {
        return img;
    }

    public void setImg(Image[] img) {
        this.img = img;
    }

    public void setNumerosSprites(int numerosSprites) {
        this.numerosSprites = numerosSprites;
    }

    public String getCarpeta() {
        return carpeta;
    }

    public void setCarpeta(String carpeta) {
        this.carpeta = carpeta;
    }
    
    public void cargaImagen() {
        img = new Image[numerosSprites];//Inicializamos el vector con un tamaño       
        try{        
               
               for (int i = 0; i <numerosSprites; i++) {            
                 imgStream = Principal.class.getResourceAsStream(carpeta+i+".png");
                 img[i] = ImageIO.read(imgStream);                
                }     
            
        }catch(IOException e){
           //TODO Auto generated catch block
            e.printStackTrace();
        }       
    }
    
    public void  run(){
        cargaImagen();
    }
    
}
