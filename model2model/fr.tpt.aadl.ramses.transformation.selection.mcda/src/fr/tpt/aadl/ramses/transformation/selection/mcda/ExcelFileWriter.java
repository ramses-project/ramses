package fr.tpt.aadl.ramses.transformation.selection.mcda;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

import jxl.CellView;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.UnderlineStyle;
import jxl.write.Formula;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;


public class ExcelFileWriter
{

  private WritableCellFormat timesBoldUnderline;
  private WritableCellFormat times;
  private String excelFileName;

  private int columnOffset=0;
  private WritableSheet mainSheet;
  private WritableWorkbook workbook ;
  
  public ExcelFileWriter(String outputFile) {
    this.excelFileName = outputFile;
    File file = new File(excelFileName);
    WorkbookSettings wbSettings = new WorkbookSettings();

    wbSettings.setLocale(new Locale("en", "EN"));

    
    try
    {
      workbook = Workbook.createWorkbook(file, wbSettings) ;
      workbook.createSheet("Alternative Scores", 0);
      mainSheet = workbook.getSheet(0);
      // Lets create a times font
      WritableFont times10pt = new WritableFont(WritableFont.TIMES, 10);
      // Define the cell format
      times = new WritableCellFormat(times10pt);
      // Lets automatically wrap the cells
      times.setWrap(true);

      // create create a bold font with unterlines
      WritableFont times10ptBoldUnderline = new WritableFont(WritableFont.TIMES, 10, WritableFont.BOLD, false,
                                                             UnderlineStyle.SINGLE);
      timesBoldUnderline = new WritableCellFormat(times10ptBoldUnderline);
      // Lets automatically wrap the cells
      timesBoldUnderline.setWrap(true);

      CellView cv = new CellView();
      cv.setFormat(times);
      cv.setFormat(timesBoldUnderline);
      cv.setAutosize(true);
    }
    catch(IOException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    catch(WriteException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
  }

  public void write() throws IOException, WriteException {
    // copy sheet to keep track of previous allocations
    workbook.write();
    workbook.close();
  }

  public void addNumber(int column, int row,
                         long num) throws WriteException, RowsExceededException 
  {
    Number number;
    number = new Number(column, row, num, times);
    mainSheet.addCell(number);
  }

  public void addLabel(int column, int row, String s)
      throws WriteException, RowsExceededException {
    Label label;
    label = new Label(column, row, s, times);
    mainSheet.addCell(label);
  }

  
//private void createLabel(WritableSheet sheet)
//throws WriteException {
//// Lets create a times font
//WritableFont times10pt = new WritableFont(WritableFont.TIMES, 10);
//// Define the cell format
//times = new WritableCellFormat(times10pt);
//// Lets automatically wrap the cells
//times.setWrap(true);
//
//// create create a bold font with unterlines
//WritableFont times10ptBoldUnderline = new WritableFont(WritableFont.TIMES, 10, WritableFont.BOLD, false,
//                                                     UnderlineStyle.SINGLE);
//timesBoldUnderline = new WritableCellFormat(times10ptBoldUnderline);
//// Lets automatically wrap the cells
//timesBoldUnderline.setWrap(true);
//
//CellView cv = new CellView();
//cv.setFormat(times);
//cv.setFormat(timesBoldUnderline);
//cv.setAutosize(true);
//
//// Write a few headers
//addCaption(sheet, 0, 0, "Header 1");
//addCaption(sheet, 1, 0, "This is another header");
//
//
//}
} 
