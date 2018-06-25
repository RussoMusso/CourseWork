package application;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.swing.JFormattedTextField;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class DownloadController {
	
	@FXML
	private Button back;
	@FXML
	private Button download;
	@FXML
    private TextField path_txt;
	@FXML
	private Button chosePath;
	
	
	@FXML
    void path_clikced(ActionEvent event) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File selectedDirectory = directoryChooser.showDialog(Main.st);
        path_txt.setText(selectedDirectory.getAbsolutePath());
    }
	
	private XWPFDocument document;

    @FXML
    void finish_clicked(ActionEvent event) {

    	MainController cv= new MainController();
        document = cv.getResultDocument();
        
        cv.createHeaddingParagraph();
        cv.createPersonasDatiHeadingParagraph();
        cv.createPersonasDatiParagraph();
        cv.createIzglitibaHeadingParagraph();
        cv.createIzglitibaParagraph();
        cv.createDarbaPieredzeHeadingParagraph();
        cv.createDarbaPieredzeParagraph();
        cv.createValodasPrasmesHeadingParagraph();
        cv.createValodasPrasmesParagraph();
        cv.createCitasPrasmesHeadingParagraph();
        cv.createCitasPrasmesParagraph();
        
        try {
            FileOutputStream output = new FileOutputStream(path_txt.getText() + "/" +" CV.doc");
            document.write(output);
            output.close();
           } catch (Exception e) {
           
        }

    }
	
	
	
	
	
	
	@FXML
	private  void goBack(ActionEvent event) throws IOException  {
		
		MainController.counter--;
		Parent _page= FXMLLoader.load(getClass().getResource(Main.pages.get(MainController.counter)));
		Scene _scene = new Scene(_page);
		Stage app_stage=(Stage)((Node) event.getSource()).getScene().getWindow();
		app_stage.setScene(_scene);
		app_stage.show();
	}
}
