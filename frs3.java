package IP;
import com.googlecode.javacv.cpp.opencv_objdetect.CvHaarClassifierCascade;
import com.googlecode.javacv.VideoInputFrameGrabber;
/*import com.googlecode.javacv.FFmpegFrameGrabber;
import java.util.concurrent.TimeUnit;
import com.googlecode.javacv.CanvasFrame;
import com.googlecode.javacv.OpenCVFrameGrabber;*/
import com.googlecode.javacv.FrameGrabber;
//import com.googlecode.javacv.JavaCvErrorCallback;
import static com.googlecode.javacv.cpp.opencv_core.*;
import static com.googlecode.javacv.cpp.opencv_highgui.*;
import static com.googlecode.javacv.cpp.opencv_imgproc.*;
import static com.googlecode.javacv.cpp.opencv_objdetect.cvHaarDetectObjects;
public class frs3 {
	private static final String CASCADE_FILE = "D:\\extras\\WheelChair\\eye det\\parojos.xml";

	public static void main(String[] args) throws Exception {

	FrameGrabber grabber=new VideoInputFrameGrabber(0);
	grabber.start();
	CvCapture capture = cvCreateFileCapture("D:\\extras\\WheelChair\\eye det\\AVI0000.avi");
	int frames = (int) cvGetCaptureProperty(capture,CV_CAP_PROP_FRAME_COUNT);

	if( frames!= 0 ) {

	//cvCreateTrackbar("Position","Example3",g_slider_position,frames,cvSetCaptureProperty(capture,CV_CAP_PROP_POS_FRAMES,10));
	IplImage originalImage;
	while (true) {

	originalImage = grabber.grab();

	IplImage grayImage = IplImage.create(originalImage.width(),originalImage.height(), IPL_DEPTH_8U, 1);

	// We convert the original image to grayscale.
	cvCvtColor(originalImage, grayImage, CV_BGR2GRAY);

	CvMemStorage storage = CvMemStorage.create();

	// We instantiate a classifier cascade to be used for detection, using
	// the cascade definition.
	CvHaarClassifierCascade cascade = new CvHaarClassifierCascade(cvLoad(CASCADE_FILE));

	// We detect the faces.
	CvSeq faces = cvHaarDetectObjects(grayImage, cascade, storage, 1.1, 1,0);


	for (int i = 0; i < faces.total(); i++) {
	CvRect r = new CvRect(cvGetSeqElem(faces, i));
	cvRectangle(originalImage, cvPoint(r.x(), r.y()),cvPoint(r.x() + r.width(), r.y() + r.height()),CvScalar.YELLOW, 1, CV_AA, 0);

	}
	cvShowImage("S1",originalImage);
	cvWaitKey(33);

	}
	}
	}

}
