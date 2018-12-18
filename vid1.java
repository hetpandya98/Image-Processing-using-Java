package IP;

/*import org.opencv.core.Core;
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
import static com.googlecode.javacv.cpp.opencv_imgproc.cvFindContours;*/

import com.googlecode.javacv.CanvasFrame;
import com.googlecode.javacv.FFmpegFrameRecorder;
//import com.googlecode.javacv.FrameGrabber;
import com.googlecode.javacv.OpenCVFrameGrabber;
import com.googlecode.javacv.cpp.avutil;
import com.googlecode.javacv.cpp.opencv_core.IplImage;

/*import java.awt.Color;
import java.io.IOException;
import java.util.Random;*/

import javax.naming.LinkException;

import org.bytedeco.javacpp.opencv_core.CvType;
//import org.bytedeco.javacpp.opencv_videoio.*;
/*import org.opencv.core.Core;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import com.googlecode.javacv.cpp.opencv_core.CvContour;
import com.googlecode.javacv.cpp.opencv_core.CvMemStorage;
import com.googlecode.javacv.cpp.opencv_core.CvScalar;
import com.googlecode.javacv.cpp.opencv_core.CvSeq;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import com.googlecode.javacv.cpp.opencv_highgui.CvCapture;*/


public class vid1 {
	public static final String FILENAME = "output.mp4";
 public static void main(String args[]) throws Exception , LinkException{
	 
	 OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);
	 grabber.start();
	 IplImage grabbedImage = grabber.grab();

     CanvasFrame canvasFrame = new CanvasFrame("Cam");
     canvasFrame.setCanvasSize(grabbedImage.width(), grabbedImage.height());

     System.out.println("framerate = " + grabber.getFrameRate());
     grabber.setFrameRate(grabber.getFrameRate());
     FFmpegFrameRecorder recorder = new FFmpegFrameRecorder(FILENAME,  grabber.getImageWidth(),grabber.getImageHeight());

     
     //((Object) recorder.setVideoCodec(13);
     recorder.setFormat("mp4");
     recorder.setPixelFormat(avutil.PIX_FMT_YUV420P);
     recorder.setFrameRate(30);
     recorder.setBitrate(10 * 1024 * 1024);

     recorder.start();
     while (canvasFrame.isVisible() && (grabbedImage = grabber.grab()) != null) {
         canvasFrame.showImage(grabbedImage);
         recorder.record(grabbedImage);
     }
     recorder.stop();
     grabber.stop();
     canvasFrame.dispose();
	 
 }
}
