/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.software;

import java.awt.event.*;
import java.awt.print.*;


import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Sides;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;

public class Printer implements Printable, ActionListener {
    private String file="";
    public Printer(String filename) {
        file=filename;
    }
    
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
