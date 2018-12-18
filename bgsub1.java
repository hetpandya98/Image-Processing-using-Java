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

public class bgsub1 {
	public static void main(String args[]) {
		System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
    	Imgcodecs imageCodecs = new Imgcodecs();
    	
    	String file1 ="C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\image(2).jpg";
    	org.opencv.core.Mat matHSV = Imgcodecs.imread(file1);
    	String file2 ="C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\image(3).jpg";
    	org.opencv.core.Mat matHSV1 = Imgcodecs.imread(file2);
    	
    	//Imgproc.cvtColor(matHSV,matHSV,CV_BGR2HSV);
    	//Imgproc.cvtColor(matHSV1,matHSV1,CV_BGR2HSV);
    	//List<org.opencv.core.Mat> channels=new ArrayList<org.opencv.core.Mat>();
    	//List<org.opencv.core.Mat> channels1=new ArrayList<org.opencv.core.Mat>();
    	//Core.split(matHSV,channels);
    	//Core.split(matHSV,channels1);
    	
    	//org.opencv.core.Mat H = channels.get(0);
    	//org.opencv.core.Mat H1 = channels1.get(0);
    	
    	org.opencv.core.Mat diff = new org.opencv.core.Mat();
    	Core.absdiff(matHSV, matHSV1, diff);
    	
    	String file3 ="C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\diffH.jpg";
    	Imgcodecs.imwrite(file3,diff);
    	
    	
	}
}
