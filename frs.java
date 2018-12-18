package IP;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.*;
import org.opencv.core.Core;

import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

public class frs {
public static void main(String arg[]){  
        
        // Load the native library.  
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);    
        String window_name = "Capture - Face detection";  
        view.Control frame = new view.Control();  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.setSize(300,300);  
        My_Panel.processor my_processor;   
        my_processor = new My_Panel.processor();
        My_Panel my_panel = new My_Panel();  
        frame.setContentPane(my_panel);       
        frame.setVisible(true);        
        //-- 2. Read the video stream  
        Mat webcam_image=new Mat();  
        VideoCapture capture =new VideoCapture(0);   
        if( capture.isOpened())  
        {  
            while( true )  
            {  
                capture.read(webcam_image);  
                if( !webcam_image.empty() )  
                {   
                    frame.setSize(2*webcam_image.width()+40,2*webcam_image.height());  
                    //-- 3. Apply the classifier to the captured image  
                    webcam_image=my_processor.detect(webcam_image);  
                    
                    //-- 4. Display the image  
                    my_panel.MatToBufferedImage(my_processor.detect(webcam_image)); // We could look at the error...  
                    my_panel.repaint();   
                }  
                else  
                {   
//                    System.out.println(" --(!) No captured frame -- Break!");   
                    break;   
                }  
            }  
        }  
        return;  
    }  
}
