package application;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import util.MyStringUtil;

public class ExcelFileVisitor extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if(MyStringUtil.isExcel(file)) {

        } else {
        	System.out.println(file.toFile().getName());
        }

        return FileVisitResult.CONTINUE;
    }
}
