package IP;

import org.opencv.core.Core;
import org.opencv.imgcodecs.Imgcodecs;

import com.googlecode.javacv.cpp.opencv_core.CvContour;
import com.googlecode.javacv.cpp.opencv_core.CvSeq;

import static com.googlecode.javacpp.Loader.sizeof;
import static com.googlecode.javacv.cpp.opencv_core.CV_FILLED; 
import static com.googlecode.javacv.cpp.opencv_core.CV_RGB; 
import static com.googlecode.javacv.cpp.opencv_core.IPL_DEPTH_8U; 
import static com.googlecode.javacv.cpp.opencv_core.cvCreateImage; 
import static com.googlecode.javacv.cpp.opencv_core.cvCreateMemStorage; 
import static com.googlecode.javacv.cpp.opencv_core.cvDrawContours; 
import static com.googlecode.javacv.cpp.opencv_core.cvFlip; 
import static com.googlecode.javacv.cpp.opencv_core.cvGetSize; 
import static com.googlecode.javacv.cpp.opencv_core.cvPoint; 
import static com.googlecode.javacv.cpp.opencv_highgui.*;
import static org.bytedeco.javacpp.opencv_highgui.*;
//import static org.bytedeco.javacpp.opencv_imgcodecs.cvLoadImage;
import static com.googlecode.javacv.cpp.opencv_highgui.cvLoadImage; 
import static com.googlecode.javacv.cpp.opencv_highgui.cvSaveImage;
import static com.googlecode.javacv.cpp.opencv_highgui.cvShowImage;
import static com.googlecode.javacv.cpp.opencv_imgproc.CV_BGR2GRAY; 
import static com.googlecode.javacv.cpp.opencv_imgproc.CV_CHAIN_APPROX_SIMPLE; 
import static com.googlecode.javacv.cpp.opencv_imgproc.CV_RETR_CCOMP; 
import static com.googlecode.javacv.cpp.opencv_imgproc.CV_THRESH_BINARY; 
import static com.googlecode.javacv.cpp.opencv_imgproc.cvCvtColor; 
import static com.googlecode.javacv.cpp.opencv_imgproc.cvFindContours; 
import static com.googlecode.javacv.cpp.opencv_imgproc.cvThreshold; 
 
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import com.googlecode.javacv.CanvasFrame; 
//import com.googlecode.javacv.FrameGrabber.Exception; 
import com.googlecode.javacv.OpenCVFrameGrabber; 
import com.googlecode.javacv.cpp.opencv_core.CvContour; 
import com.googlecode.javacv.cpp.opencv_core.CvMemStorage; 
import com.googlecode.javacv.cpp.opencv_core.CvScalar; 
import com.googlecode.javacv.cpp.opencv_core.CvSeq; 
import com.googlecode.javacv.cpp.opencv_core.IplImage; 

public class contoursdect {
	public static void main(String args[]) throws IOException {
		System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
    	Imgcodecs imageCodecs = new Imgcodecs();
    	
    	//BufferedImage img= ImageIO.read(new File("C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\coins.png"));
    	//IplImage matHSV1= IplImage.createFrom(img);
    	
    	//IplImage matHSV1 = cvLoadImage("C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\coins.png");
    	//IplImage matHSV = cvCreateImage(cvGetSize(matHSV1),IPL_DEPTH_8U,3);
    	
    	CvMemStorage mem;
    	
    	String file1 ="C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\coins.png"; 
		org.opencv.core.Mat matHSV1 = Imgcodecs.imread(file1);
		IplImage matHSV = cvCreateImage(cvGetSize(matHSV1),IPL_DEPTH_8U,3);
		
		//IplImage img = new IplImage(matHSV1);
		
		//IplImage temp=matHSV1;
		
		/*String file2 ="C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\coins.png"; 
		org.opencv.core.Mat matHSV = Imgcodecs.imread(file2);*/
		
		CvSeq cvSeq=new CvSeq();
		mem = cvCreateMemStorage(0); 
		
		cvFindContours(matHSV1, mem, cvSeq, sizeof(CvContour.class), CV_RETR_CCOMP, CV_CHAIN_APPROX_SIMPLE);
        CvSeq ptr = new CvSeq(); 
        CvSeq contours = new CvSeq(); 
        Random rand = new Random(); 
        for (ptr = contours; ptr != null; ptr = ptr.h_next()) { 
            Color randomColor = new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat()); 
            CvScalar color = CV_RGB( randomColor.getRed(), randomColor.getGreen(), randomColor.getBlue()); 
            cvDrawContours(matHSV1, ptr, color, CV_RGB(0,0,0), -1, CV_FILLED, 8, cvPoint(0,0)); 
        } 
        //canvas.showImage(matHSV1); 
        cvShowImage("C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\coins1.png",matHSV1);
	}
}
