/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectoAnimacion;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import org.omg.CORBA.ARG_INOUT;

/**
 *
 * @author User
 */
public class Principal extends JFrame implements Runnable{
    Image[]img;//Declaramos un vector de imagenes
    Image fondo;//Declaramos la imagen que sera el fondo
   // Imagen vectorBananas[];
    InputStream imgStream;
    private BufferStrategy estrategia;//Llamo la clase
    int numeroImagen=1;//Esta variable controla la imagen mostrar
    Timer timer1;//Declaromos nuertro time
    //int x,y=520;//La variable que establece la posicion en x
    boolean noMueve;
   // String carpeta="/CaminandoDerecha/";
   // int tamanioImagen=11;
    int direccion=0;
    boolean subir = true;
    boolean EntradaTierra=true;
    int rapidez;
    //Musica fondo
    Sonido sonido;
    //Sonido rugido;
    Imagen objImagen;
    Imagen banana;
    OyenteTeclado oyenteTeclado; 
    int numeroBananas=0;
   
    
    public Principal(){
        super("Don King Kong");
        sonido = new Sonido("C:\\Users\\User\\Desktop\\Animacion Actualizacion 5\\proyectoFinalAnimacion\\src\\Sonidos\\la-atmosfera_4.mp3");
     
        this.setSize(1300,640);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.createBufferStrategy(4);
        this.setResizable(false);
        this.addKeyListener(new OyenteTeclado(this));
        estrategia = getBufferStrategy();
        objImagen = new Imagen(50,520,8,"/Bailando/");       
        noMueve = true;
        banana = new Imagen(300,88,8,"/Banana/");
       // this.addKeyListener(kl);
         banana.start();
        sonido.start();
        //banana.start();
        cargaImagen();
        repaint();        
        run();   
        
    }    

    public void cargaImagen() {
        img = new Image[objImagen.getNumerosSprites()];//Inicializamos el vector con un tamaño       
        try{
            imgStream = Principal.class.getResourceAsStream("/Fondo/Paisaje.jpg");//Inicializamos imagen de fondo            
            fondo = ImageIO.read(imgStream);      
               
               for (int i = 1; i <objImagen.getNumerosSprites(); i++) {            
                 imgStream = Principal.class.getResourceAsStream("/ImagenesGorila"+objImagen.getCarpeta()+i+".png");
                 img[i] = ImageIO.read(imgStream);                
                }     
            
        }catch(IOException e){
           //TODO Auto generated catch block
            e.printStackTrace();
        }       
    }
    @Override
    public void run() {       
         
        timer1 = new Timer(85,new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                numeroBananas++;
                if(numeroBananas>=8){
                   numeroBananas=0;
                }
                if(noMueve==true){
                       if(objImagen.getY()==520){
                           numeroImagen++;
                           if(numeroImagen==objImagen.getNumerosSprites()){
                              numeroImagen = 1;                           
                           }   
                           System.out.println("1");
                       }
                       
                }else{  
                      // if(!objImagen.getCarpeta().equals("/Bailando/")){
                           numeroImagen++;
                           if(numeroImagen==objImagen.getNumerosSprites()){
                             numeroImagen = 1;                           
                           } 
                            System.out.println("2");
                       //}
                                                              
                    }             
            }
        });
        
        timer1.start();     
    }
   
    @Override
    public void paint(Graphics g){
        update(g);
        
    }
    @Override
     public void update(Graphics g) { 
         
        try {
             Graphics2D g3 =(Graphics2D)estrategia.getDrawGraphics();
             Graphics2D g2 =(Graphics2D)estrategia.getDrawGraphics();
             g3.drawImage(fondo, 0,0,1300,640,null);
             g3.drawImage(img[numeroImagen],objImagen.getX(),objImagen.getY(),96,70,null);            
             g2.drawImage(banana.getImg()[numeroBananas],banana.getX(),banana.getY(),41,49,null);   
             estrategia.show();
             repaint();
        }catch (Exception e) {
         }
     }

    public Imagen getObjImagen() {
        return objImagen;
    }

    public void setObjImagen(Imagen objImagen) {
        this.objImagen = objImagen;
    }

    public int getNumeroImagen() {
        return numeroImagen;
    }

    public void setNumeroImagen(int numeroImagen) {
        this.numeroImagen = numeroImagen;
    }

    public boolean isNoMueve() {
        return noMueve;
    }

    public void setNoMueve(boolean noMueve) {
        this.noMueve = noMueve;
    }

    public int getDireccion() {
        return direccion;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }

    public boolean isEntradaTierra() {
        return EntradaTierra;
    }

    public void setEntradaTierra(boolean EntradaTierra) {
        this.EntradaTierra = EntradaTierra;
    }
    
    public  void moverDerecha(){
         
        if(EntradaTierra==true){
            if(!objImagen.getCarpeta().equals("/CaminandoDerecha/")){
              objImagen.setCarpeta("/CaminandoDerecha/");
              //tamanioImagen=11;
              objImagen.setNumerosSprites(11);
              cargaImagen();
              numeroImagen=0;
            }
              noMueve = false;
             // x = x+5;
              objImagen.setX(objImagen.getX()+5);
              direccion=0;
        }
            
         if(objImagen.getY()<=88&&objImagen.getX()>=200&&objImagen.getX()<1090){                     
             if(!objImagen.getCarpeta().equals("/PasandoCuerdaDerecha/")){
             // carpeta="/PasandoCuerdaDerecha/";  
               objImagen.setCarpeta("/PasandoCuerdaDerecha/");
              // tamanioImagen=11;
               objImagen.setNumerosSprites(11);
               numeroImagen=1;
               cargaImagen();                           
               EntradaTierra=false;
             }
             if(numeroImagen++>=10){
                numeroImagen=1;                         
             }
             //x =x +5;
              objImagen.setX(objImagen.getX()+5);
             //System.out.println(numeroImagen);
         }   
    }
    
    public void moverIzquierda(){
        if(EntradaTierra==true){
            if(!objImagen.getCarpeta().equals("/CaminandoIzquierda/")){
              // carpeta="/CaminandoIzquierda/";
                objImagen.setCarpeta("/CaminandoIzquierda/");
               numeroImagen=0;
              // tamanioImagen=11;
               objImagen.setNumerosSprites(11);
               cargaImagen();                
             }
             noMueve= false;
            // x = x-5; 
             objImagen.setX(objImagen.getX()-5);
             direccion=1;
            }
             if(objImagen.getY()<=88&&objImagen.getX()>=210&&objImagen.getX()<=1090){                     
                 if(!objImagen.getCarpeta().equals("/PasandoCuerdaIzquierda/")){
                  // carpeta="/PasandoCuerdaIzquierda/";
                    objImagen.setCarpeta("/PasandoCuerdaIzquierda/");
                    numeroImagen=0;
                   //tamanioImagen=11;
                    objImagen.setNumerosSprites(11);
                    cargaImagen(); 
                    EntradaTierra=false;
                 }
                 if(numeroImagen++>=10){
                    numeroImagen=1;                         
                 }
                // x =x -5;
                 objImagen.setX(objImagen.getX()-5);
             }
               // System.out.println(numeroImagen); 
    
    }
    
    public  void moverAbajo(){
         if(EntradaTierra==true){
               if(direccion==0){
                    if(!objImagen.getCarpeta().equals("/AgachandoseDerecha/")){
                     // carpeta="/AgachandoseDerecha/";
                      objImagen.setCarpeta("/AgachandoseDerecha/");  
                      //tamanioImagen=7;
                      objImagen.setNumerosSprites(7);
                      numeroImagen=0;
                      cargaImagen();                          
                    }                        
                    if(numeroImagen++>=6&&objImagen.getCarpeta().equals("/AgachandoseDerecha/")){
                       numeroImagen=6;
                    } 


                }else{                           
                      if(!objImagen.getCarpeta().equals("/AgachandoseIzquierda/")){
                       // carpeta="/AgachandoseIzquierda/";
                        objImagen.setCarpeta("/AgachandoseIzquierda/");  
                        //tamanioImagen=7;
                        objImagen.setNumerosSprites(7);
                        numeroImagen=0;
                        cargaImagen();                          
                      }                        
                      if(numeroImagen++>=6&&objImagen.getCarpeta().equals("/AgachandoseIzquierda/")){
                         numeroImagen=6;
                      }
                    }
         }
        if(EntradaTierra==false){
             if(objImagen.getY()<=520&&objImagen.getX()>=1030&&objImagen.getX()<=1090){  
                     if(!objImagen.getCarpeta().equals("/TrepandoCuerda/")){
                      // carpeta="/TrepandoCuerda/";
                         objImagen.setCarpeta("/TrepandoCuerda/"); 
                       //tamanioImagen=10;
                         objImagen.setNumerosSprites(10);
                        numeroImagen=1;
                        objImagen.setX(1080);
                        cargaImagen();               
                    }                            
                  //  y+=4;
                   objImagen.setY(objImagen.getY()+4);
                   //System.out.println(y);
                   if(numeroImagen++>=9&&objImagen.getCarpeta().equals("/TrepandoCuerda/")){
                       numeroImagen=1;
                   }
                  if(objImagen.getY()>=520){
                    EntradaTierra=true;
                  } 
            }
        }    
    }

    public void moverArriba(){
       //TrepandoCuerda
        // System.out.println(" X:  "+x);
        // System.out.println(" Y:  "+y);
       if(objImagen.getX()>=1030&&objImagen.getX()<=1090&&objImagen.getY()>=88){
             if(!objImagen.getCarpeta().equals("/TrepandoCuerda/")){
              // carpeta="/TrepandoCuerda/";
                objImagen.setCarpeta("/TrepandoCuerda/"); 
              // tamanioImagen=10;
                objImagen.setNumerosSprites(10);
                numeroImagen=1;
              // x=1080;
                objImagen.setX(1080);
                EntradaTierra=false;
               //EntradaNoTierra=true;
                cargaImagen();               
            }                            
            //  y-=4; 
            objImagen.setY(objImagen.getY()-4);
          //  System.out.println(y);
            if(numeroImagen++>=9&&objImagen.getCarpeta().equals("/TrepandoCuerda/")){
              numeroImagen=1;
            }                           
        }
    }
    public  void teclaEspacio(){
       if(EntradaTierra==false&&objImagen.getY()>88){
         if(!objImagen.getCarpeta().equals("/Girando/")){
           // carpeta="/Girando/";
              objImagen.setCarpeta("/Girando/"); 
           // tamanioImagen=7;
              objImagen.setNumerosSprites(7);
              numeroImagen=1; 
               noMueve=false; 
              //x=1070;
             // EntradaTierra=false;
              objImagen.setX(1070);
              cargaImagen();                                           
            }
          //  noMueve=false;
            
       }    
    }  
    public  void  bailando(){
      if(EntradaTierra==true){ 
        if(!objImagen.getCarpeta().equals("/Bailando/")){
             // carpeta="/TrepandoCuerda/";
               objImagen.setCarpeta("/Bailando/"); 
             // tamanioImagen=10;
              objImagen.setNumerosSprites(8);
               numeroImagen=1;
              // x=1080;               
               //EntradaTierra=false;
              //EntradaNoTierra=true;
               noMueve=true;              
               cargaImagen();              
            }
     }
            
    }
}
