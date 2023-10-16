package com.qa.ecs.utils;

import java.io.File;

//import org.sikuli.script.FindFailed;
//import org.sikuli.script.Screen;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class ImageUtil {

    public static String getImageText(String filePath) throws TesseractException {
        Tesseract tes = new Tesseract();
        tes.setDatapath("./src/test/resources/tessdata");
        tes.setLanguage("eng");
        String result = tes.doOCR(new File(filePath));
        System.out.println(result);
        return result;
    }
    
    
    /*
    public static void enterText(String referenceImageFilePage, String valueToSet) {
    	Screen sc =  new Screen();
    	sc.type(referenceImageFilePage,valueToSet);
    }
    */
    
    /*
    public static void click(String referenceImageFilePage) {
    	Screen sc =  new Screen();
    	try {
			sc.click(referenceImageFilePage);
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    */
}
