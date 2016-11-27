
package accounting.software;

import java.awt.event.*;
import java.awt.print.*;


import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

import java.io.FileInputStream;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Sides;

/**
 *
 * @author Furkan
 * @author Şahin Eğilmez
 */
public class Printer implements Printable, ActionListener {
    private String file=""; //pdf file name

    /**
     *
     * @param filename
     */
    public Printer(String filename) {
        file=filename;
    }
    /**
     * 
     * @param g Graphic class
     * @param pf page format
     * @param page page count
     * @return 1
     * @throws PrinterException 
     * 
     * This methos print to pdf
     */
    @Override
    public int print(Graphics g, PageFormat pf, int page) throws
            PrinterException {

        DocFlavor flavor = DocFlavor.SERVICE_FORMATTED.PAGEABLE;
        PrintRequestAttributeSet patts = new HashPrintRequestAttributeSet();
        patts.add(Sides.DUPLEX);
        PrintService[] ps = PrintServiceLookup.lookupPrintServices(flavor, patts);
        if (ps.length == 0) {
            //
        }
        //System.out.println("Available printers: " + Arrays.asList(ps));
        PrintService myService = null;
        for (PrintService printService : ps) {
            if (printService.getName().equals("Your printer name")) {
                myService = printService;
                break;
            }
        }
        if (myService == null) {
            //
        }
        try (FileInputStream fis = new FileInputStream(file)) {
            Doc pdfDoc = new SimpleDoc(fis, DocFlavor.INPUT_STREAM.AUTOSENSE, null);
            DocPrintJob printJob = myService.createPrintJob();
            printJob.print(pdfDoc, new HashPrintRequestAttributeSet());
        }catch(Exception e){
            e.printStackTrace();
            throw new PrinterException("File Not Found!");
        }
        return 1;
    }
    /**
     * 
     * @param e action
     * 
     * This method active for Button.OnClick()
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(this);
        boolean ok = job.printDialog();
        if (ok) {
            try {
                job.print();
            } catch (PrinterException ex) {
                ex.printStackTrace();
                /* The job did not successfully complete */
            }
        }
    }
}
