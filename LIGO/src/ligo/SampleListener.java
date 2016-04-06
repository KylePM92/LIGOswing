/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligo;
import com.leapmotion.leap.*;


/**
 *
 * @author Mike
 */
public class SampleListener extends Listener{
    
    public void onConnect(Controller controller){
        System.out.println("Connected");
        
    }
    
    public void onFrame(Controller controller){
        
        Frame frame = controller.frame();
        
        if(frame.gestures().count() > 0){
            System.out.println("Suhhh dude a gesture");
                Gesture gesture = frame.gestures().get(0);
                
                switch(gesture.type()){
                    
                        case TYPE_SCREEN_TAP:
                        System.out.println("Tap tap!");
                        break;
                            
                        case TYPE_KEY_TAP:
                        System.out.println("Key tap!");
                        break;
                        case TYPE_CIRCLE:
                        System.out.println("Circlin!");
                        break;
                            
                        case TYPE_SWIPE:
                        System.out.println("Swiper no swiping!");
                        break;
                            
                        default:
                        System.out.println("What was that!?");
                        break;
                            

                }
                
                        System.out.println(gesture.type());
                        ScreenTapGesture screentap = new ScreenTapGesture(frame.gestures().get(0));
	                System.out.println(screentap.position());

                
        }
        
    }
    
}
