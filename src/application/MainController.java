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
	        /*
	        			+"\nOrganizātoriskās prasmes: "+c1.getOrganizatoriskasPrasmes()
	        			+"\nDatorprasmes: "+c2.getDatorprasmes()
	        			+"\nAr profesiju saistītās prasmes:"+c2.getSaistitasPrasmes());*/
	        			
	       
	    }
	 
	

	
	/*ObservableList<IzglitibaClass> study = FXCollections.observableArrayList();*/
	
	//Variables for DarbaPieredze Table
	/*
	@FXML
	protected TableView<DarbaPieredzeClass> tableView;
	@FXML
	protected TableColumn<DarbaPieredzeClass, LocalDate>dateFrom;
	@FXML
	protected TableColumn<DarbaPieredzeClass, LocalDate>dateTo;
	@FXML
	protected  TableColumn<DarbaPieredzeClass, String>proffession;
	@FXML
	protected TableColumn<DarbaPieredzeClass, String>workPlaceName;
	*/
	
	
	/*
	public void initialize(URL url, ResourceBundle rb) {
		
		dateFrom.setCellValueFactory(new PropertyValueFactory<DarbaPieredzeClass, LocalDate>("dateFrom"));
		dateTo.setCellValueFactory(new PropertyValueFactory<DarbaPieredzeClass, LocalDate>("dateTo"));
		proffession.setCellValueFactory(new PropertyValueFactory<DarbaPieredzeClass, String>("profession"));
		workPlaceName.setCellValueFactory(new PropertyValueFactory<DarbaPieredzeClass, String>("workPlaceName"));
		//load data
		tableView.setItems(getEverything());
	}
	*/
	
	public ObservableList<DarbaPieredzeClass> getEverything(){
		ObservableList<DarbaPieredzeClass> p = FXCollections.observableArrayList();
		p.add(new DarbaPieredzeClass("Klauns", "Cirks", "Riga", "Klaunoties", LocalDate.of(1999, Month.APRIL, 12),LocalDate.of(1999, Month.APRIL, 12)));
		p.add(new DarbaPieredzeClass("Klauns", "Cirks", "Riga", "Klaunoties", LocalDate.of(1999, Month.APRIL, 12),LocalDate.of(1999, Month.APRIL, 12)));
		return p;
	}
	
	
	
	
	
	/*
	String writtenName="";
	String writtenSurname="";
	String writtenAddress="";
	String writtenPostIndex="";
	String writtenCity="";
	String writtenNumber="";
	String writtenMail="";
	String writtenCountry="";
	String writtenPhoneType="";
	/*
	String writtenIzglitibaFrom="";
	String writtenIzglitibaTo="";
	String writtenIzglitibaQualification="";
	String writtenIzglitibastudyPlaceName="";
	String writtenIzglitibaKnowladge="";
	*/
	/*
	@FXML
	private TextField IzglitibaStudyPlaceName;
	@FXML
	private TextField IzglitibaQualification;
	@FXML
	private TextArea IzglitibaKnowladge;
	@FXML
	private DatePicker IzglitibaDateFrom;
	@FXML
	private DatePicker IzglitibaDateTo;
	@FXML
	private Label IzglitibaWarningText;
	
	@FXML
	private TableView<IzglitibaClass> IzglitibaTable;
	@FXML
	private TableColumn<IzglitibaClass, LocalDate>IzglitibaDateFromCol;
	@FXML
	private TableColumn<IzglitibaClass, LocalDate>IzglitibaDateToCol;
	@FXML
	private TableColumn<IzglitibaClass, String>IzglitibaQualificationCol;
	@FXML
	private TableColumn<IzglitibaClass, String>IzglitibaStudyPlaceNameCol;
	

	*/
/*
public void initialize(URL url, ResourceBundle rb) {
		
	
		IzglitibaDateFromCol.setCellValueFactory(new PropertyValueFactory<IzglitibaClass, LocalDate>("IzglitibaDateFrom"));
		IzglitibaDateToCol.setCellValueFactory(new PropertyValueFactory<IzglitibaClass, LocalDate>("dateTo"));
		IzglitibaQualificationCol.setCellValueFactory(new PropertyValueFactory<IzglitibaClass, String>("1"));
		IzglitibaStudyPlaceNameCol.setCellValueFactory(new PropertyValueFactory<IzglitibaClass, String>("w1"));
		//load data
		IzglitibaTable.setItems(study);
	
	}
*/
	/*
	ObservableList<String> phoneTypes = FXCollections.observableArrayList(
			"Mobilais",
			"Darba",
			"Mājas"
			);
	ObservableList<String> countries = Stream.of(Locale.getISOCountries())
	        .map(locales -> new Locale("", locales))
	        .map(Locale::getDisplayCountry)
	        .collect(Collectors.toCollection(FXCollections::observableArrayList));
	
	@FXML
	private TextField name;
	@FXML
	private TextField surname;
	@FXML
	private TextField address;
	@FXML
	private TextField post_index;
	@FXML
	private TextField city;
	@FXML
	private TextField number;
	@FXML
	private TextField mail;
	@FXML
	private ChoiceBox<String> country = new ChoiceBox<>() ;
	@FXML
	private ChoiceBox<String>phoneType = new ChoiceBox<>();
	@FXML
	private Button nextPage = new Button();
	@FXML
	private Button but = new Button();
	
	@FXML
	private void initializeCountries() {
		
		
		phoneType.setItems(phoneTypes);
		country.setItems(countries);
		//country.setValue("Latvia");
		
	
	}

	@FXML
	private void getPersonasDati() {
		writtenAddress+=address.getText();
		writtenCity=city.getText();
		writtenCountry= country.getValue().toString();
		writtenMail=mail.getText();
		writtenNumber=number.getText();
		writtenPhoneType=phoneType.getValue().toString();
		writtenPostIndex=post_index.getText();
		writtenSurname=surname.getText();
		System.out.println(writtenAddress+writtenCity+writtenCountry+writtenMail+writtenName+writtenNumber+writtenPhoneType+writtenPostIndex+writtenSurname);
	}
	/*
	@FXML
	private void makeIzglitibaDatiObject(ActionEvent event) throws IOException {
		IzglitibaWarningText.setText("");
		if(IzglitibaQualification.getText().equals("") || IzglitibaStudyPlaceName.getText().equals("") || IzglitibaKnowladge.getText().equals("") || IzglitibaDateTo.getValue()==null|| IzglitibaDateFrom.getValue()==null )
		{
			IzglitibaWarningText.setText("*Lūdzu aizpildiet visus laukus");
		}
		else {
			IzglitibaClass obj = new IzglitibaClass(IzglitibaQualification.getText(), IzglitibaStudyPlaceName.getText(), IzglitibaKnowladge.getText(), IzglitibaDateFrom.getValue(), IzglitibaDateTo.getValue());
			study.add(obj);
			
			System.out.println(study);
			Parent Izglitiba_page= FXMLLoader.load(getClass().getResource("/application/Izglitiba.fxml"));
			Scene Izglitiba_scene = new Scene(Izglitiba_page);
			Stage app_stage=(Stage)((Node) event.getSource()).getScene().getWindow();
			app_stage.setScene(Izglitiba_scene);
			app_stage.show();
		}
	}

	*/
	
	
	/*
	@FXML
	private TextField username;
	@FXML
	private PasswordField pass;
	public void signIn(ActionEvent event) {
		String writtenUsername = username.getText();
		String writtenPassword = pass.getText();
		if(writtenPassword.equals("1")&& writtenUsername.equals("1")) {
			System.out.println("You are in");
		}
	
		
	}
*/
}



