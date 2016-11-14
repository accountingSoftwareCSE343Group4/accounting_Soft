/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.software;

/**
 *
 * @author zozge
 */



import java.util.Date;

import java.io.FileOutputStream;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/*
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;*/

public class CreateReport {
 
        private static final String FILE = "Temp.pdf";
        private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 25,
                        Font.BOLD);
        private static Font catFont2 = new Font(Font.FontFamily.TIMES_ROMAN, 18,
                        Font.BOLD); 
        private static final Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
                        Font.NORMAL, BaseColor.RED);
        private static final Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 14,
                        Font.BOLD);
        private static final Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
                        Font.BOLD);

        public static void main(String[] args) {
            
                try {
                        Document document = new Document();
                        PdfWriter.getInstance(document, new FileOutputStream(FILE));
                        document.open();
                        
                        addTitlePage(document);
                        addContent(document);
                        document.close();
                } catch (Exception e) {
                        e.printStackTrace();
                }
                
                
        }


        private static void addTitlePage(Document document)
                        throws DocumentException {
                Paragraph preface = new Paragraph();
                // We add one empty line
                addEmptyLine(preface, 15);
                // big header
                preface.add(new Paragraph("             Report Of Accounting System", catFont));

                addEmptyLine(preface, 1);
                // Report Date
                preface.add(new Paragraph(
                                          "                              Date : " 
                                                  + new Date(), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                                smallBold));
                addEmptyLine(preface, 1);
             
                document.add(preface);

        }

        private static void addContent(Document document) throws DocumentException {
                Paragraph preface = new Paragraph();
                Anchor anchor = new Anchor("", catFont);
                // Second parameter is the number of the chapter
                Chapter catPart = new Chapter(new Paragraph(anchor), 1);

                Paragraph subPara = new Paragraph("", subFont);
                Section subCatPart = catPart;
                
                // add a list
              //  createList(subCatPart);
                Paragraph paragraph = new Paragraph();
               

                // add a table
                createTable(subCatPart);
                
                addEmptyLine(paragraph, 1);
                subCatPart.add(paragraph);
                
                createTable2(subCatPart);
                
                addEmptyLine(paragraph, 1);
                subCatPart.add(paragraph);
                
                createTable3(subCatPart);
                
                addEmptyLine(paragraph, 1);
                subCatPart.add(paragraph);
                
                createTable4(subCatPart);
                
                addEmptyLine(paragraph, 1);
                subCatPart.add(paragraph);
                
                createTable5(subCatPart);
                
                addEmptyLine(paragraph, 1);
                subCatPart.add(paragraph);
                
                // now add all this to the document
                document.add(catPart);


        }

        private static void createTable(Section subCatPart)
                throws BadElementException {
                PdfPTable table = new PdfPTable(3);

                // t.setBorderColor(BaseColor.GRAY);
                // t.setPadding(4);
                // t.setSpacing(4);
                // t.setBorderWidth(1);

                PdfPCell c1 = new PdfPCell(new Phrase("DIESEL"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);

                c1 = new PdfPCell(new Phrase("GASOLINE"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);

                c1 = new PdfPCell(new Phrase("LPG"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);
                table.setHeaderRows(1);

                table.addCell("AVAILABLE AMOUNT (LT) = " + AccountingSystem.getInstance().getFuel(0).getFuelAmount());
                table.addCell("AVAILABLE AMOUNT (LT) = " + AccountingSystem.getInstance().getFuel(1).getFuelAmount());
                table.addCell("AVAILABLE AMOUNT (LT) = " + AccountingSystem.getInstance().getFuel(2).getFuelAmount());
                table.addCell("PURCHASE PRICE(TL)    = " + AccountingSystem.getInstance().getFuel(0).getBuyingPrice());
                table.addCell("PURCHASE PRICE(TL)    = " + AccountingSystem.getInstance().getFuel(1).getBuyingPrice());
                table.addCell("PURCHASE PRICE(TL)    = " + AccountingSystem.getInstance().getFuel(2).getBuyingPrice());
                table.addCell("CURRENT PRICE (LT)    = " + AccountingSystem.getInstance().getFuel(0).getSalePrice());
                table.addCell("CURRENT PRICE (LT)    = " + AccountingSystem.getInstance().getFuel(1).getSalePrice());
                table.addCell("CURRENT PRICE (LT)    = " + AccountingSystem.getInstance().getFuel(2).getSalePrice());

                subCatPart.add(table);

        }
        private static void createTable2(Section subCatPart)
                throws BadElementException {
                PdfPTable table = new PdfPTable(7); // personel bilgi tipleri 
                    
                // t.setBorderColor(BaseColor.GRAY);
                // t.setPadding(4);
                // t.setSpacing(4);
                // t.setBorderWidth(1);

                PdfPCell c1 = new PdfPCell(new Phrase("Name"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                
                table.addCell(c1);

                c1 = new PdfPCell(new Phrase("Lastname"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);

                c1 = new PdfPCell(new Phrase("Address"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);
                
                c1 = new PdfPCell(new Phrase("Phone Number"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);

                c1 = new PdfPCell(new Phrase("Jop"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);
                
                c1 = new PdfPCell(new Phrase("Salary"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);

                c1 = new PdfPCell(new Phrase("Ssk Prim"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);
          
                table.setHeaderRows(1);

               
                for (int i=0; i < AccountingSystem.getInstance().getPersonnelSize(); i++){
                    table.addCell(AccountingSystem.getInstance().getPerson(i).getName()); // Name
                    table.addCell(AccountingSystem.getInstance().getPerson(i).getLastName()); // LastName
                    table.addCell(AccountingSystem.getInstance().getPerson(i).getAddress()); // Address
                    table.addCell(AccountingSystem.getInstance().getPerson(i).getPhoneNumber()); // PhoneNumber
                    table.addCell(AccountingSystem.getInstance().getPerson(i).getJop()); // Job
                    table.addCell(String.valueOf(AccountingSystem.getInstance().getPerson(i).getSalary())); // Salary
                    table.addCell(String.valueOf(AccountingSystem.getInstance().getPerson(i).getSskBonus())); // Ssk Prim
                }   
                subCatPart.add(table);

        }
        private static void createTable3(Section subCatPart)
                throws BadElementException {
                PdfPTable table = new PdfPTable(3);

                // t.setBorderColor(BaseColor.GRAY);
                // t.setPadding(4);
                // t.setSpacing(4);
                // t.setBorderWidth(1);

                PdfPCell c1 = new PdfPCell(new Phrase("Personnel Expenses"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);

                c1 = new PdfPCell(new Phrase("Fuel Expenses"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);

                c1 = new PdfPCell(new Phrase("Other Expenses"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);
                
                table.setHeaderRows(1);

                subCatPart.add(table);

        }
        private static void createTable4(Section subCatPart)
                throws BadElementException {
                PdfPTable table = new PdfPTable(2);

                // t.setBorderColor(BaseColor.GRAY);
                // t.setPadding(4);
                // t.setSpacing(4);
                // t.setBorderWidth(1);

                PdfPCell c1 = new PdfPCell(new Phrase("Rent"));
                c1.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(c1);

                c1 = new PdfPCell(new Phrase("..."));
                c1.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(c1);

               
                
                table.setHeaderRows(1);

                table.addCell("Environmental Cleaning Tax");
                table.addCell("..");
                table.addCell("Electric"); 
                table.addCell("..");
                table.addCell("Water");
                table.addCell("..");
                table.addCell("Natural Gas"); 
                table.addCell("..");
                
                
                subCatPart.add(table);

        }
        private static void createTable5(Section subCatPart)
                throws BadElementException {
                PdfPTable table = new PdfPTable(2);

                // t.setBorderColor(BaseColor.GRAY);
                // t.setPadding(4);
                // t.setSpacing(4);
                // t.setBorderWidth(1);

                table.setHeaderRows(1);

                
                for(int i=0; i< AccountingSystem.getInstance().getSalesListSize(); ++i){
                    
                    PdfPCell c1 = new PdfPCell(new Phrase(AccountingSystem.getInstance().getSale(i).getName()));
                    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(c1);
                
                    table.addCell(String.valueOf(AccountingSystem.getInstance().getSale(i).getIncome()));
                }
                
                subCatPart.add(table);

        }        


        private static void addEmptyLine(Paragraph paragraph, int number) {
                for (int i = 0; i < number; i++) {
                        paragraph.add(new Paragraph(" "));
                }
        }
    
    

   
    
}

