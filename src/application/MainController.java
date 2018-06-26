package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.Event;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.poi.sl.usermodel.StrokeStyle.LineDash;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.sqlite.core.DB;

import com.sun.javafx.stage.StageHelper;

public class MainController /*implements Initializable*/ {
	
	public static int counter=0;
	public static User user1= new User();

	
	 private XWPFDocument resultDocument = new XWPFDocument();
	 public XWPFDocument getResultDocument() {
	        return resultDocument;
	    }
	 	 
	
	 public void createHeaddingParagraph() {
	        XWPFParagraph headding = resultDocument.createParagraph();
	        XWPFRun run = headding.createRun();
	        headding.setAlignment(ParagraphAlignment.CENTER);
	        run.setFontSize(40);
	        run.setBold(true);
	        run.setText("Curriculum Vitae");
	        run.addBreak();
	        run.addBreak();
	    }
	 @FXML
	 public void createPersonasDatiHeadingParagraph() {
	        XWPFParagraph data = resultDocument.createParagraph();
	        XWPFRun run = data.createRun();
	        data.setAlignment(ParagraphAlignment.CENTER);
	        run.setFontSize(30);
	        run.setText("Personas dati");
	        run.addBreak();
	 }

	 @FXML
	 public void createPersonasDatiParagraph() {
		 XWPFParagraph data = resultDocument.createParagraph();
	        XWPFRun run = data.createRun();
	        //Retrieve Personas dati object
	        PersonasDatiClass p = PersonasDatiController.retrievePersona();
	        
	        data.setAlignment(ParagraphAlignment.LEFT);
	        run.setFontSize(11);
	        run.setText("Vārds: " + p.getName());
	        run.addBreak();
	        
	        run.setText("Uzvārds: " + p.getSurname());
	        run.addBreak();

	        run.setText("Adrese: " + p.getAddress());
	        run.addBreak();
	        
	        run.setText("Pasta indekss: " + p.getPost_index());
	        run.addBreak();
	        
	        
	        run.setText("Valsts: " + p.getCountry());
	        run.addBreak();
	       
	        run.setText("Pilsēta: " + p.getCity());
	        run.addBreak();
	        
	        run.setText("E-pasts: " + p.getMail());
	        run.addBreak();
	        
	        run.setText("Telefons: \n" + p.getPhoneType()+" : "+p.getNumber());
	        run.addBreak();
	        
	    }
	
	 
	 @FXML
	 public void createIzglitibaHeadingParagraph() {
	        XWPFParagraph data = resultDocument.createParagraph();
	        XWPFRun run = data.createRun();
	        data.setAlignment(ParagraphAlignment.CENTER);
	        run.setFontSize(30);
	        run.setText("Izglītība");
	        run.addBreak();
	 }

	 @FXML
	 public void createIzglitibaParagraph() {
		 XWPFParagraph data = resultDocument.createParagraph();
	        XWPFRun run = data.createRun();
	        //Retrieve Izglitiba Arraylist object
	        ObservableList<IzglitibaClass> z = IzglitibaAizpildiController.study;
	        data.setAlignment(ParagraphAlignment.LEFT);
	        run.setFontSize(11);
	        for(int i=0; i<z.size();i++) {
	        	run.setText("Laiks: "+z.get(i).getDateFrom()+" līdz "+z.get(i).getDateTo());
	        	run.addBreak();
	        	run.setText("Kvalifikācija: "+z.get(i).getQualification());
	        	run.addBreak();
	        	run.setText("Mācību iestāde: "+z.get(i).getStudyPlaceName());
	        	run.addBreak();
	        	run.setText("Iegūtās zināšanas: "+z.get(i).getKnowladge());
	        	run.addBreak();
	        	run.addBreak(BreakType.valueOf(3));
	        }
	    }
	 @FXML
	 public void createDarbaPieredzeHeadingParagraph() {
	        XWPFParagraph data = resultDocument.createParagraph();
	        XWPFRun run = data.createRun();
	        data.setAlignment(ParagraphAlignment.CENTER);
	        run.setFontSize(30);
	        run.setText("Darba Pieredze");
	        run.addBreak();
	 }

	 @FXML
	 public void createDarbaPieredzeParagraph() {
		 XWPFParagraph data = resultDocument.createParagraph();
	        XWPFRun run = data.createRun();
	        //Retrieve Izglitiba Arraylist object
	        ObservableList<DarbaPieredzeClass> z = DarbaPieredzeAizpildiController.experience;
	        data.setAlignment(ParagraphAlignment.LEFT);
	        run.setFontSize(11);
	        for(int i=0; i<z.size();i++) {
	        	run.setText("Laiks: "+z.get(i).getDateFrom()+" līdz "+z.get(i).getDateTo());
	        	run.addBreak();
	        	run.setText("Profesija: "+z.get(i).getProfession());
	        	run.addBreak();
	        	run.setText("Darba vieta: "+z.get(i).getWorkPlaceName());
	        	run.addBreak();
	        	run.setText("Darba pienākumi: "+z.get(i).getWorkDuties());
	        	run.addBreak(BreakType.valueOf(3));
	        }
	    }
	 @FXML
	 public void createValodasPrasmesHeadingParagraph() {
	        XWPFParagraph data = resultDocument.createParagraph();
	        XWPFRun run = data.createRun();
	        data.setAlignment(ParagraphAlignment.CENTER);
	        run.setFontSize(30);
	        run.setText("Valodas Prasmes");
	        run.addBreak();
	 }

	 @FXML
	 public void createValodasPrasmesParagraph() {
		 XWPFParagraph data = resultDocument.createParagraph();
	        XWPFRun run = data.createRun();
	        //Retrieve Izglitiba Arraylist object
	        ObservableList<ValodasPrasmesClass> z = ValodasPrasmesAizpildiController.valodas;
	        data.setAlignment(ParagraphAlignment.LEFT);
	        run.setFontSize(11);
	        for(int i=0; i<z.size();i++) {
	        	run.setText("Valoda: "+z.get(i).getValoda()+"  Veids: "+z.get(i).getVeids());
	        	run.addBreak();	
	        	run.setText("Klausīšanās: "+z.get(i).getKlausisanas() +" Lasīšana: "+z.get(i).getLasisana()+" Rakstīšana: "+z.get(i).getRakstisana());
	        	run.addBreak();	
	        	run.setText("Monologs: "+z.get(i).getMonologs()+" Dialogs: "+z.get(i).getDialogs());
	        	run.addBreak();	
	        	if(!z.get(i).getDiplomi().equals("")) {
	        		run.setText("Diplomi:");
	        		run.setText(z.get(i).getDiplomi());
	        		run.addBreak();
	        	}
	        	run.addBreak();
	        	run.addBreak(BreakType.valueOf(3));
	        }
	    }
	 @FXML
	 public void createCitasPrasmesHeadingParagraph() {
	        XWPFParagraph data = resultDocument.createParagraph();
	        XWPFRun run = data.createRun();
	        data.setAlignment(ParagraphAlignment.CENTER);
	        run.setFontSize(30);
	        run.setText("Citas Prasmes");
	        run.addBreak();
	 }

	 @FXML
	 public void createCitasPrasmesParagraph() {
		 XWPFParagraph data = resultDocument.createParagraph();
	        XWPFRun run = data.createRun();
	        //Retrieve Izglitiba Arraylist object
	        CitasPrasmes1Class c1 = CitasPrasmes1Controller.retrieveCitasPrasmes1();
	        CitasPrasmes2Class c2 = CitasPrasmes2Controller.retrieveCitasPrasmes2();
	        data.setAlignment(ParagraphAlignment.LEFT);
	        run.setFontSize(11);
	        
	        run.setText("Komunikācijas prasmes: "+c1.getKomunikacijasPrasmes());
	        run.addBreak();
	        run.setText("Organizātoriskās prasmes: "+c1.getOrganizatoriskasPrasmes());
	        run.addBreak();
	        run.setText("Datorprasmes: "+c2.getDatorprasmes());
	        run.addBreak();
	        run.setText("Ar profesiju saistītās prasmes:"+c2.getSaistitasPrasmes());
	        run.addBreak();
	       
	    }

}



