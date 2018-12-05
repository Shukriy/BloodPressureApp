package pdf;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImage;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import GUI.Graph;
import ccol.BloodPressure;
import ccol.Patient;
import ccol.Readings;

import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import org.jfree.chart.ChartUtilities;

/** This class generates a pdf, given a patient, and their ave, min and max BP readings.
 * @author Abdullah Ali, Shukriya Ali
 *
 */
public class Pdf {
	private static Patient p;
	private static Document document;
	private static ArrayList<Readings> readings;
	private static BloodPressure ave;
	private static BloodPressure min;
	private static BloodPressure max;	
	private static final Chunk NEWLINE = new Chunk("\n");
	
	
    public static void createPDF (Patient patient, BloodPressure average, 
    								BloodPressure minimum, BloodPressure maximum) {
    	p = patient;
    	readings = p.getReadings();
    	ave = average;
    	min = minimum;
    	max = maximum;
        document = new Document();
        
        try {
        	
        	if (System.getProperty("os.name").equals("Linux")) {				// If running linux, saves in main directory
        		PdfWriter.getInstance(document, new FileOutputStream(	
        				System.getProperty("user.home") + "/Report.pdf")); 
        	} else {        													// Otherwise saves in temp folder
        		PdfWriter.getInstance(document, new FileOutputStream(
								System.getProperty("java.io.tmpdir") + "Report.pdf"));
        	}
			
			
			Calendar cal = Calendar.getInstance();
			String time = "Generated on: " + cal.toString();
			
			document.open();
			document.addHeader("Produced by Team Raleigh", time);
			
			document.addTitle("Patient Report");
			Paragraph space = new Paragraph("");
            document.add(space);
            
			document.add(createInfo());
			document.add(NEWLINE);
			
			document.add(graphImage());
			document.add(NEWLINE);
			
			document.add(addReadings());
			document.add(NEWLINE);
			
			document.close();
			
			System.out.println("doc created successfully");
			
			// Opens the document from where it was saved
			if (System.getProperty("os.name").equals("Linux")) {
        		File myFile = new File(System.getProperty("user.home") + "/Report.pdf");
    			Desktop.getDesktop().open(myFile);
        		
        	} else {   		
        		File myFile = new File(System.getProperty("java.io.tmpdir") + "Report.pdf");
    			Desktop.getDesktop().open(myFile);
        	}
			
			
        
        } catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Couldn't open the file");
		}  
        
    }
    
    private static PdfPTable createInfo() {
 
        PdfPTable table = new PdfPTable(4);
        PdfPCell titleCell = new PdfPCell(new Phrase("Patien Blood Pressure Report"));
        titleCell.setColspan(6);
        titleCell.setHorizontalAlignment(1); //0=Left, 1=Centre, 2=Right
        table.addCell(titleCell);
        
        PdfPCell nameCell = new PdfPCell(new Phrase(
        		"Name: " + p.getTitle() + " " + p.getFirstName() + " " + p.getSurName()));
        nameCell.setColspan(2);
        nameCell.setHorizontalAlignment(0); //0=Left, 1=Centre, 2=Right
        table.addCell(nameCell);
        
        PdfPCell addressCell = new PdfPCell(new Phrase("Address: " + p.getAddress()));
        addressCell.setColspan(2);
        addressCell.setHorizontalAlignment(0); //0=Left, 1=Centre, 2=Right
        table.addCell(addressCell);                       
        
        table.addCell("Date of Birth");
        table.addCell(p.getDobString());
        table.addCell("BP Target");
        table.addCell(p.getTarget().toString());
        table.addCell("Total Number of Readings");
        table.addCell( ((Integer) p.getReadings().size()).toString());
        table.addCell("Average BP");
        table.addCell(ave.toString());
        table.addCell("Highest BP");
        table.addCell(max.toString());
        table.addCell("Lowest BP");
        table.addCell(min.toString());            
        return table;
	
    }   
    
    private static Image graphImage () {
    	java.awt.Image img = Graph.getImage(p, 500, 200);
    	Image image = null;
		try {
			image = Image.getInstance(img, Color.WHITE);
		} catch (BadElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return image;
    }
    
    private static PdfPTable addReadings () {
    	 PdfPTable table = new PdfPTable(5);
         PdfPCell titleCell = new PdfPCell(new Phrase("Patient Readings"));
         titleCell.setColspan(10);
         titleCell.setHorizontalAlignment(1); //0=Left, 1=Centre, 2=Right
         table.addCell(titleCell);
         
         table.addCell("Date");
         table.addCell("Time");
         table.addCell("Average BP");

         PdfPCell commTCell = new PdfPCell(new Phrase("Comments"));
         commTCell.setColspan(2);
         table.addCell(commTCell);
         
         for (Readings r : readings) {
	         table.addCell(r.getDate().toString());
	         table.addCell(r.getTime().toString());
	         table.addCell(r.getAve().toString());

	         PdfPCell commCell = new PdfPCell(new Phrase(r.getComments()));
	         commCell.setColspan(2);
	         table.addCell(commCell);
         }
           
         return table;  	
    	
    }
}
