package util;

import java.io.File;
import java.nio.file.Path;

public class MyStringUtil {

	/**
	 * エクセルファイル判定
	 * @param path
	 * @return
	 */
	public static boolean isExcel(Path path) {
		return path.toFile().getName().endsWith(".csv") || path.toFile().getName().endsWith(".xlsx");
	}

	/**
	 * エクセルファイル判定
	 * @param file
	 * @return
	 */
	public static boolean isExcel(File file) {
		return isExcel(file.toPath());
	}
}
