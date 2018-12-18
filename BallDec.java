package IP;

import static com.googlecode.javacv.cpp.opencv_imgproc.CV_BGR2HSV;
//import org.opencv.highgui.HighGui;
import com.googlecode.javacv.*;
import com.googlecode.javacv.cpp.*;
import com.googlecode.javacv.cpp.opencv_core.CvPoint;
import com.googlecode.javacv.cpp.opencv_core.CvScalar;
import com.googlecode.javacv.cpp.opencv_core.CvSeq;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import com.googlecode.javacv.cpp.opencv_highgui.CvCapture;

import static com.googlecode.javacv.cpp.opencv_calib3d.*;
import static com.googlecode.javacv.cpp.opencv_objdetect.*;
import static com.googlecode.javacv.cpp.opencv_core.*;
import static com.googlecode.javacv.cpp.opencv_highgui.*;
import static com.googlecode.javacv.cpp.opencv_imgproc.*;
import com.googlecode.javacv.cpp.opencv_highgui.*;
import org.opencv.core.*;
import org.opencv.core.Point;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.util.ArrayList;
import java.util.List;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Color;

import org.opencv.core.Core;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class BallDec {
	public static void main(String []args) throws IOException {
		
		System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
	    Imgcodecs imageCodecs = new Imgcodecs();
	    
	    String file1 ="C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\ball3.jpg"; 
		org.opencv.core.Mat matHSV1 = Imgcodecs.imread(file1);
		String file ="C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\ball3.jpg"; 
		org.opencv.core.Mat matHSV = Imgcodecs.imread(file);
		
		Imgproc.cvtColor(matHSV1,matHSV,CV_BGR2HSV);
		List<org.opencv.core.Mat> channels=new ArrayList<org.opencv.core.Mat>();
		Core.split(matHSV,channels);
		
		org.opencv.core.Mat H = channels.get(0);
		org.opencv.core.Mat S = channels.get(1);
		org.opencv.core.Mat V = channels.get(2);
		org.opencv.core.Mat VO = channels.get(2);
		//Imgproc.cvtColor(V,V,Imgproc.COLOR_BGR2GRAY);
		/*org.opencv.core.Core.bitwise_not(V,V);
		org.opencv.core.Core.bitwise_or(VO,V,VO);
		org.opencv.core.Core.bitwise_not(V,V);
		org.opencv.core.Core.bitwise_and(VO,V,V);*/
		
		org.opencv.core.Core.bitwise_not(H,H);
		
		org.opencv.core.Mat HM = channels.get(0);
		org.opencv.core.Mat SM = channels.get(1);
		org.opencv.core.Mat VM = channels.get(2);
		org.opencv.core.Mat AB = channels.get(0);
		
		String file2 ="C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\ballH.jpg";
		String file3 ="C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\ballS.jpg";
		String file4 ="C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\ballV.jpg";
		
		imageCodecs.imwrite(file2,H);
		imageCodecs.imwrite(file3,S);
		imageCodecs.imwrite(file4,V);
		
		//cvThreshold(colorDst, threshold, 155, 255, CV_THRESH_BINARY);
		Imgproc.threshold(H,HM, 150, 255, Imgproc.THRESH_BINARY);
		Imgproc.threshold(S,SM, 155, 255, Imgproc.THRESH_TRIANGLE);
		Imgproc.threshold(V,VM, 200, 255, Imgproc.THRESH_BINARY);
		
		String file5 ="C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\ballHM.jpg";
		String file6 ="C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\ballSM.jpg";
		String file7 ="C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\ballVM.jpg";
		
		imageCodecs.imwrite(file5,HM);
		imageCodecs.imwrite(file6,SM);
		imageCodecs.imwrite(file7,VM);
		
		org.opencv.core.Core.bitwise_and(HM,SM,AB);
		org.opencv.core.Core.bitwise_and(AB,VM,AB);
		String file8 ="C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\ballT.jpg";
		imageCodecs.imwrite(file8,AB);
		
		String file11 ="C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\ball3.jpg"; 
		
		org.opencv.core.Mat src = Imgcodecs.imread(file11);
		org.opencv.core.Mat gray = new org.opencv.core.Mat();
		Imgproc.cvtColor(src, gray, Imgproc.COLOR_BGR2GRAY);
		
		//cvSmooth(gray, gray, CV_GAUSSIAN, 3);
		
		String file10 ="C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\ballG.jpg";
		imageCodecs.imwrite(file10,gray);
		
		org.opencv.core.Mat circles = new org.opencv.core.Mat();
        Imgproc.HoughCircles(gray, circles, Imgproc.HOUGH_GRADIENT, 1.0,
                (double)gray.rows()/16, // change this value to detect circles with different distances to each other
                100.0, 30.0, 1, 100); // change the last two parameters
                // (min_radius & max_radius) to detect larger circles
        for (int x = 0; x < circles.cols(); x++) {
            double[] c = circles.get(0, x);
            Point center = new Point(Math.round(c[0]), Math.round(c[1]));
            // circle center	
            Imgproc.circle(matHSV1, center, 1, new Scalar(0,100,100), 3, 8, 0 );
            // circle outline
            int radius = (int) Math.round(c[2]);
            Imgproc.circle(matHSV1, center, radius, new Scalar(255,0,255), 3, 8, 0 );
        }
        String file9 ="C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\ballFin.jpg";
		imageCodecs.imwrite(file9,matHSV1);
		
        	//cvShowImage("Result",src);
		
		  /*IplImage src = cvLoadImage("C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\144424.jpg");
		  IplImage gray = cvCreateImage(cvGetSize(src), 8, 1);
		
		  
		  cvCvtColor(src, gray, CV_BGR2GRAY);  
		  cvSmooth(gray, gray, CV_GAUSSIAN, 3);
		   
		  CvMemStorage mem = CvMemStorage.create();
		   
		  CvSeq circles = cvHoughCircles( 
		    gray, //Input image
		    mem, //Memory Storage
		    CV_HOUGH_GRADIENT, //Detection method
		    1, //Inverse ratio
		    100, //Minimum distance between the centers of the detected circles
		    100, //Higher threshold for canny edge detector
		    100, //Threshold at the center detection stage
		    15, //min radius
		    500 //max radius
		    );
		   
		  for(int i = 0; i < circles.total(); i++){
		      CvPoint3D32f circle = new CvPoint3D32f(cvGetSeqElem(circles, i));
		      CvPoint center = cvPointFrom32f(new CvPoint2D32f(circle.x(), circle.y()));
		      int radius = Math.round(circle.z());      
		      cvCircle(src, center, radius, CvScalar.GREEN, 6, CV_AA, 0);    
		     }*/
	}
}
