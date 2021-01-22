package application;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFShape;
import org.apache.poi.xssf.usermodel.XSSFSimpleShape;

import javafx.scene.control.TextArea;
import util.MyStringUtil;

public class ExcelFileVisitor extends SimpleFileVisitor<Path> {

	private TextArea textArea;

	public ExcelFileVisitor(TextArea textArea) {
		this.textArea = textArea;
	}

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if(MyStringUtil.isExcel(file)) {
        	Workbook workbook = WorkbookFactory.create(file.toFile());
        	for(int i=0; i< workbook.getNumberOfSheets(); ++i) {
        		Sheet sheet = workbook.getSheetAt(i);
        		XSSFDrawing drawing = (XSSFDrawing) sheet.createDrawingPatriarch();
        		List<XSSFShape> shapeList = drawing.getShapes();
        		shapeList.stream().forEach(shape -> {
        			XSSFSimpleShape ss = (XSSFSimpleShape)shape;
        			textArea.setText(ss.getText() + textArea.getText());
        		});
        	}
        }
        return FileVisitResult.CONTINUE;
    }
}
