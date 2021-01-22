package application;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class MainPanelController {

	@FXML private TextField dirPath;
	@FXML private TextArea textArea;

	@FXML
	protected void onClickSelectFolder(ActionEvent evt) {
		 DirectoryChooser directoryChooser = new DirectoryChooser();
		 directoryChooser.setTitle( "ディレクトリ選択" );
		 Node node = (Node)evt.getSource();
		 Stage stage = (Stage) node.getScene().getWindow();
		 File f4 = directoryChooser.showDialog(stage);
		 dirPath.setText(f4.getPath());
	}

	@FXML
	protected void onClickGetData(ActionEvent evt) {
		Path path = Paths.get(dirPath.getText());
		try {
			Files.walkFileTree(path, new ExcelFileVisitor());
		} catch (IOException e) {
			textArea.setText(e.getMessage());
		}
	}

}
