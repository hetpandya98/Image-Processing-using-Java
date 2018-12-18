package IP;

//import org.opencv.core.video.BackgroundSubstractor;

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

public class contoursdect1 {
	public static void main(String args[]) throws IOException {
		System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
    	Imgcodecs imageCodecs = new Imgcodecs();
    	   	
    	String file1 ="C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\cars2.jpg";
    	org.opencv.core.Mat matHSV = Imgcodecs.imread(file1);
		//org.opencv.core.Mat matHSV1 = new org.opencv.core.Mat(); 
		
		org.opencv.core.Mat hierarcy = new org.opencv.core.Mat();
		
		ArrayList<org.opencv.core.MatOfPoint> Contours = new ArrayList<org.opencv.core.MatOfPoint>();
		
		String file4 ="C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\black.jpg";
		org.opencv.core.Mat contours = Imgcodecs.imread(file4);
		
		//org.opencv.core.Mat cannyEdges = new org.opencv.core.Mat();
		org.opencv.core.Mat grayMat = new org.opencv.core.Mat();
		Imgproc.cvtColor(matHSV, grayMat, Imgproc.COLOR_BGR2GRAY);
	    //Imgproc.Canny(matHSV, cannyEdges, 10, 100);
		
		Imgproc.dilate(grayMat, grayMat, Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(2, 2)));
		Imgproc.erode(grayMat, grayMat, Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(2, 2)));
		
		String file5 ="C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\xyz.jpg";
		imageCodecs.imwrite(file5,grayMat);
		
		Imgproc.Canny(grayMat,grayMat, 400, 500);
		
	    String file2 ="C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\cars2g.jpg";
		imageCodecs.imwrite(file2,grayMat);
	    
		Imgproc.findContours(grayMat, Contours, hierarcy, Imgproc.RETR_LIST,Imgproc.CHAIN_APPROX_SIMPLE);
		
	    //contours.create(cannyEdges.rows(), cannyEdges.cols(), CvType.CV_8UC3);
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
	    String file3 ="C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\contours1.jpg";
		imageCodecs.imwrite(file3,contours);

	    
	    //Imgcodecs.imwrite("C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\xyz.jpg",contours);
	    //Converting Mat back to Bitmap
	    //Utils.matToBitmap(contours, currentBitmap);
	    //imageView.setImageBitmap(currentBitmap);

	    }
}
