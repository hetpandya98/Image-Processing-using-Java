package IP;

import org.opencv.core.Core;
import org.opencv.imgcodecs.Imgcodecs;

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
import static com.googlecode.javacv.cpp.opencv_imgproc.CV_BGR2HSV;
import static com.googlecode.javacv.cpp.opencv_imgproc.CV_CHAIN_APPROX_SIMPLE;
import static com.googlecode.javacv.cpp.opencv_imgproc.CV_RETR_CCOMP;
import static com.googlecode.javacv.cpp.opencv_imgproc.cvFindContours;

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

public class Fin1 {
	public static void main(String args[]) {
		System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
    	Imgcodecs imageCodecs = new Imgcodecs();
    	
    	String file1 ="C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\fg.jpg";
    	org.opencv.core.Mat matHSV = Imgcodecs.imread(file1);
    	String file2 ="C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\bg.jpg";
    	org.opencv.core.Mat matHSV1 = Imgcodecs.imread(file2);
    	
    	Imgproc.cvtColor(matHSV, matHSV, Imgproc.COLOR_BGR2GRAY);
    	Imgproc.cvtColor(matHSV1, matHSV1, Imgproc.COLOR_BGR2GRAY);
    	
    	//Imgproc.threshold(matHSV, matHSV, 100, 255, Imgproc.THRESH_BINARY);
    	//Imgproc.threshold(matHSV1, matHSV1, 0, 255, Imgproc.THRESH_BINARY);
    	
    	String file7 ="C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\ft.jpg";
		imageCodecs.imwrite(file7,matHSV);
		String file8 ="C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\bt.jpg";
		imageCodecs.imwrite(file8,matHSV1);
    	
    	org.opencv.core.Mat diff = new org.opencv.core.Mat();
    	Core.absdiff(matHSV, matHSV1, diff);
    	
    	/*org.opencv.core.Mat diff = new org.opencv.core.Mat();
    	String file3 ="C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\ping.jpg";
    	Imgcodecs.imwrite(file3,diff);*/
    	
    	//Imgproc.erode(diff, diff, Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(2, 2)));
    	
    	ArrayList<org.opencv.core.MatOfPoint> Contours = new ArrayList<org.opencv.core.MatOfPoint>();
    	org.opencv.core.Mat hierarcy = new org.opencv.core.Mat();
    	
    	String file4 ="C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\black.jpg";
		org.opencv.core.Mat contours = Imgcodecs.imread(file4);
		
		Imgproc.Canny(diff,diff, 100, 500);
		
		String file6 ="C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\canny.jpg";
		imageCodecs.imwrite(file6,diff);
    	
    	Imgproc.findContours(diff, Contours, hierarcy, Imgproc.RETR_LIST,Imgproc.CHAIN_APPROX_SIMPLE);
    	
    	Random r = new Random();
	    System.out.println(Contours.size());
	    int c=0;
	    for (int i = 0; i < Contours.size(); i++) {
	    	if(Imgproc.contourArea(Contours.get(i))>0.0) {
	    		c++;
	    		Imgproc.drawContours(contours, Contours, i, new Scalar(0,255,0), -1);//r.nextInt(255)
	    	}
	    } 
	    System.out.println(c);
	    String file5 ="C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\contours2.jpg";
		imageCodecs.imwrite(file5,contours);

	}
}
