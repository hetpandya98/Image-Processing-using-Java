package IP;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

import com.googlecode.javacv.*;
import com.googlecode.javacv.cpp.*;
import com.googlecode.javacv.cpp.opencv_core.CvPoint;
import com.googlecode.javacv.cpp.opencv_core.CvScalar;
import com.googlecode.javacv.cpp.opencv_core.CvSeq;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import com.googlecode.javacv.cpp.opencv_highgui.CvCapture;

import static com.googlecode.javacv.cpp.opencv_core.*;
import static com.googlecode.javacv.cpp.opencv_imgproc.*;
import static com.googlecode.javacv.cpp.opencv_calib3d.*;
import static com.googlecode.javacv.cpp.opencv_objdetect.*;
import static com.googlecode.javacv.cpp.opencv_highgui.*;
public class objdetect1 {
	static void video_tracking(){
	      //read image
	       IplImage orgImg = cvLoadImage("C:\\Users\\Het Pandya\\Desktop\\Just some random stuff\\Untitled.jpg");

	       IplImage thresholdImage = hsvThreshold(orgImg);
	       cvSaveImage("hsvthreshold.jpg", thresholdImage);
	       //Dimension position = getCoordinates(thresholdImage);
	       //System.out.println("Dimension of original Image : " + thresholdImage.width() + " , " + thresholdImage.height());
	       //System.out.println("Position of red spot    : x : " + position.width + " , y : " + position.height);

	   }

	   /*static Dimension getCoordinates(IplImage thresholdImage) {
	       int posX = 0;
	       int posY = 0;
	       CvMoments moments = new CvMoments();
	       cvMoments(thresholdImage, moments, 1);
	       double momX10 = cvGetSpatialMoment(moments, 1, 0); // (x,y)
	       double momY01 = cvGetSpatialMoment(moments, 0, 1);// (x,y)
	       double area = cvGetCentralMoment(moments, 0, 0);
	       posX = (int) (momX10 / area);
	       posY = (int) (momY01 / area);
	       return new Dimension(posX, posY);
	   }*/

	   static IplImage hsvThreshold(IplImage orgImg) {

	       // Convert the image into an HSV image
	       IplImage imgHSV = cvCreateImage(cvGetSize(orgImg), 8, 3);

	       cvCvtColor(orgImg, imgHSV, CV_BGR2HSV);

	       //create a new image that will hold the threholded image
	       // 1- color = monochrome
	       IplImage imgThreshold = cvCreateImage(cvGetSize(orgImg), orgImg.depth(), 1);

	       //do the actual thresholding
	       cvInRangeS(imgHSV, cvScalar(13, 0, 0, 0), cvScalar(40, 117, 124, 88), imgThreshold);

	       cvReleaseImage(imgHSV);

	       cvSmooth(imgThreshold, imgThreshold, CV_MEDIAN, 13);
	       // save
	       return imgThreshold;
	   }
}
