package IP;

import org.opencv.core.Core;
import org.opencv.imgcodecs.Imgcodecs;

import java.util.ArrayList;
import java.util.List;

import java.lang.Object;
import org.opencv.core.CvType;

import static com.googlecode.javacpp.Loader.sizeof;
import static com.googlecode.javacv.cpp.opencv_core.CV_FILLED;
import static com.googlecode.javacv.cpp.opencv_core.CV_RGB;
import static com.googlecode.javacv.cpp.opencv_core.IPL_DEPTH_8U;
import static com.googlecode.javacv.cpp.opencv_core.cvCreateImage;
import static com.googlecode.javacv.cpp.opencv_core.cvCreateMemStorage;
import static com.googlecode.javacv.cpp.opencv_core.cvDrawContours;
import static com.googlecode.javacv.cpp.opencv_core.cvGetSize;
import static com.googlecode.javacv.cpp.opencv_core.cvPoint;
import static com.googlecode.javacv.cpp.opencv_highgui.cvShowImage;
import static com.googlecode.javacv.cpp.opencv_imgproc.CV_CHAIN_APPROX_SIMPLE;
import static com.googlecode.javacv.cpp.opencv_imgproc.CV_RETR_CCOMP;
import static com.googlecode.javacv.cpp.opencv_imgproc.cvFindContours;

import com.googlecode.javacv.CanvasFrame;
import com.googlecode.javacv.FFmpegFrameRecorder;
import com.googlecode.javacv.FrameGrabber;
import com.googlecode.javacv.OpenCVFrameGrabber;
import com.googlecode.javacv.cpp.avutil;
import com.googlecode.javacv.cpp.opencv_core.IplImage;

import java.awt.Color;
import java.io.IOException;
import java.util.Random;

//import org.bytedeco.javacpp.opencv_core.CvType;
import org.opencv.core.Core;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import com.googlecode.javacv.cpp.opencv_core.CvContour;
import com.googlecode.javacv.cpp.opencv_core.CvMemStorage;
import com.googlecode.javacv.cpp.opencv_core.CvScalar;
import com.googlecode.javacv.cpp.opencv_core.CvSeq;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import com.googlecode.javacv.cpp.opencv_highgui.CvCapture;

public class vid3 {
	public static void main(String args[]) {
		CanvasFrame canvas = new CanvasFrame("VideoCanvas"); 
		   
		  //Set Canvas frame to close on exit
		     canvas.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);   
		      
		     //Declare FrameGrabber to import video from "video.mp4"
		     FrameGrabber grabber = new OpenCVFrameGrabber("G:\\Other Videos\\IMG_2714.mp4");  
		      
		      
		     try {      
		       
		      //Start grabber to capture video
		      grabber.start();      
		       
		      //Declare img as IplImage
		      IplImage img;
		       
		      while (true) {
		        
		       //inser grabed video fram to IplImage img
		       img = grabber.grab();
		        
		       //Set canvas size as per dimentions of video frame.
		       canvas.setCanvasSize(grabber.getImageWidth(), grabber.getImageHeight()); 
		        
		       if (img != null) {       
		        //Show video frame in canvas
		        canvas.showImage(img);               
		        }
		       }
		      }
		     catch (Exception e) {      
		     }
	}

}
