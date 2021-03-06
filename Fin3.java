package IP;

import org.opencv.core.Core;
import org.opencv.imgcodecs.Imgcodecs;

import java.util.ArrayList;
import java.util.List;

/*import java.lang.Object;
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
import java.io.IOException;*/
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

public class Fin3 {
	public static void main(String args[]) {
		System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
    	Imgcodecs imageCodecs = new Imgcodecs();
    	
    	String file1 ="C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\fg.jpg";
    	org.opencv.core.Mat matHSV = Imgcodecs.imread(file1);
    	String file2 ="C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\bg.jpg";
    	org.opencv.core.Mat matHSV1 = Imgcodecs.imread(file2);
    	
    	
    	
    	Imgproc.cvtColor(matHSV, matHSV, Imgproc.COLOR_BGR2HSV);
    	Imgproc.cvtColor(matHSV1, matHSV1, Imgproc.COLOR_BGR2HSV);
    	
    	List<org.opencv.core.Mat> channels=new ArrayList<org.opencv.core.Mat>();
		Core.split(matHSV,channels);
		org.opencv.core.Mat H = channels.get(0);
		
		
		List<org.opencv.core.Mat> channels1=new ArrayList<org.opencv.core.Mat>();
		Core.split(matHSV1,channels1);
		org.opencv.core.Mat H1 = channels1.get(0);
    	
		String file8 ="C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\H.jpg";
		imageCodecs.imwrite(file8,H);
		
		String file9 ="C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\H1.jpg";
		imageCodecs.imwrite(file9,H1);
    	
    	//org.opencv.core.Mat diff = new org.opencv.core.Mat();
    	//Core.absdiff(matHSV, matHSV1, diff);
    	
    	//org.opencv.core.Mat thr = new org.opencv.core.Mat();
    	Imgproc.threshold(H, H, 75, 255, Imgproc.THRESH_BINARY);
        //Imgproc.blur(thr, thr, new Size(3, 3));
        //Imgproc.threshold(thr, thr, 50, 200, Imgproc.THRESH_BINARY);

    	Imgproc.threshold(H1, H1, 75, 255, Imgproc.THRESH_BINARY);
    	
    	org.opencv.core.Mat diff = new org.opencv.core.Mat();
    	Core.absdiff(H, H1, diff);
    	
    	String file7 ="C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\diff1.jpg";
		imageCodecs.imwrite(file7,diff);
    	
    	Imgproc.erode(diff, diff, Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(2, 2)));
    	
    	//Imgproc.cvtColor(diff, diff, Imgproc.COLOR_BGR2GRAY);
    	
    	org.opencv.core.Mat hierarcy = new org.opencv.core.Mat();
		ArrayList<org.opencv.core.MatOfPoint> Contours = new ArrayList<org.opencv.core.MatOfPoint>();
		Imgproc.Canny(diff,diff, 0, 500);
		String file5 ="C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\edg.jpg";
		imageCodecs.imwrite(file5,diff);
    	Imgproc.findContours(diff, Contours, hierarcy, Imgproc.RETR_LIST,Imgproc.CHAIN_APPROX_SIMPLE);
    	
    	
    	String file4 ="C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\black.jpg";
		org.opencv.core.Mat contours = Imgcodecs.imread(file4);
		
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
	    String file6 ="C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\contours.jpg";
		imageCodecs.imwrite(file6,contours);
	}
}
