////Remember that if your PDF contains some scanned images, it wont be able to parse it. Test case will pass but nothing will be printed on console///////////

///Execution flow=> Create URL obj-> put it into FileInputStream object-->Put FileInputStream obj to BufferedInputStrrea to parse it-->Create PDDocument object to load Parsed File-->Finally get text using PDFTextStripper////////////////

package ReadPdfPackage;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PDFReaderTest {
	
	@Test
	public void ReadPdfTest() throws Exception {
		
		URL url=new URL("http://www.africau.edu/images/default/sample.pdf"); //Creating object of URL class(Java class) and passing URL to it where PDF is located
		
		//If you want to read PDF from your local computer location then pass location in URL as shown below
		
		//URL url=new URL("PDF file location From local computer comes here");
		
		
		InputStream ip=url.openStream(); //Creating object of input stream with Mentioned URL above
		
		//Below BifferedReader will parse the input stream
		
		BufferedInputStream fileparse=new BufferedInputStream(ip); //Creating obj of BufferedInputStream class and passing obj of ileInpputStream
		
		PDDocument document=null; //Creating object of PDDocument which is coming from PDF box
		
		document=PDDocument.load(fileparse);
		
		String PDFContent=new PDFTextStripper().getText(document);
		
		System.out.println(PDFContent);
		
		//Below testing some assertions
		Assert.assertTrue(PDFContent.contains("A Simple PDF File"));
		Assert.assertTrue(PDFContent.contains("Simple PDF File 2"));
	}

}
