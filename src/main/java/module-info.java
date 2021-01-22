module application {
	requires transitive javafx.graphics;
	requires transitive javafx.controls;
	requires transitive javafx.fxml;
	requires transitive javafx.base;
	requires poi;
	requires poi.ooxml;
	requires java.desktop;

	opens application;
	exports application;
}