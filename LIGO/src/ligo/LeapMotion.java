/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligo;

import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Gesture;
import java.io.IOException;

/**
 *
 * @author Mike
 */
public class LeapMotion {
    
     public static void main(String[] args) {
	        // Create a sample listener and controller
	        LeapMotionListener listener = new LeapMotionListener();
	        Controller controller = new Controller();
	        controller.enableGesture(Gesture.Type.TYPE_SCREEN_TAP);
	        controller.enableGesture(Gesture.Type.TYPE_KEY_TAP);
	        controller.enableGesture(Gesture.Type.TYPE_CIRCLE);
	        controller.enableGesture(Gesture.Type.TYPE_SWIPE);
	
	        // Have the sample listener receive events from the controller
	        controller.addListener(listener);
	
	        // Keep this process running until Enter is pressed
	        System.out.println("Press Enter to quit...");
	        try {
	            System.in.read();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	
	        // Remove the sample listener when done
	        controller.removeListener(listener);
	    }
    
}
