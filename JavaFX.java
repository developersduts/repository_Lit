import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends Application {
	
	TextArea ta = new TextArea();
	TextArea sta = new TextArea();
	TableView table = new TableView();
	Tooltip tt1 = new Tooltip();
	Tooltip tt2 = new Tooltip();
	Tooltip tt3 = new Tooltip();
	Tooltip tt4 = new Tooltip();
	Tooltip tt5 = new Tooltip();
	Tooltip tt6 = new Tooltip();
	Tooltip tt7 = new Tooltip();
	Tooltip tt8 = new Tooltip();
	Tooltip tt9 = new Tooltip();
	List<Person> list = new ArrayList<>();
	
	ObservableList<Person> data;	
	SplitMenuButton mb;
	ArrayList<String> as;
	String s;
	String st;
	String ex;
	Label ls = new Label("");
	Label ls2 = new Label("");
	Label ls3 = new Label("");
	Label ls4 = new Label("");
	String[] y;
	
	public void start(Stage Stage) {
		Stage.setTitle("�������� � ����������");
		
		FileChooser fileChooser = new FileChooser();
		
		Button butop = new Button("³������ ����");
		Button butsa = new Button("�������� ����");
		Button buthe = new Button("?");
		Button buttf = new Button("��������� �������");
		Button butts = new Button("�������� �������");
		Button butsn = new Button("�������� ����");
		Button butsp = new Button("OK");
		
		butop.setDisable(true);
		butsn.setDisable(true);
		butts.setDisable(true);
		table.setDisable(true);
		s = "�� �� ������� �����!"+"\n"+"�������� ������� ����, ��� ���������� ������.";
		ex = "�����   г�     �����" +"\n"
		   + "-------   ------   ----------"+"\n";
		st = "                  �������� ����������!!!"+"\n"
		    +"����� �������� ������ �������� ��������-"+"\n"+"����, �� ���� ��������� ����������."+"\n"
		    +"������������� , �� �� ������� ��������,"+"\n"+"� ����� ��������� �������." +"\n"
		    +"�������� ���� �� ������� :"+"\n";
		
		ta.setText(s);
		ls.setText(st);
		ls.setTextFill(Color.web("#DC143C"));
		ls.setFont(new Font("Arial", 20));
		ls2.setText(ex);
		ls2.setFont(new Font("Arial", 15));
		ls3.setText("����� �������� ������ � ��������"+"\n"+"����������� ����������� ��������� ����������!");
		ls3.setFont(new Font("Arial", 8));
		
		butsp.setStyle("-fx-font: 22 arial; -fx-base: #ADFF2F;");
		butsp.setOnAction((ActionEvent event) -> {	 
			
            butop.setDisable(false);
            butsp.setDisable(true);
            
            ls4.setText("������ �� �����,"+"\n"+"������ ������!");
    		ls4.setFont(new Font("Arial", 30));
    		ls3.setFont(new Font("Arial", 12));
            
            VBox vbox = new VBox();
    		HBox hbox = new HBox();
    		VBox vbox2 = new VBox();
    		VBox hbox2 = new VBox();
    		
    		vbox.getChildren().addAll(vbox2,hbox);
    		hbox.getChildren().addAll(butop);
    		vbox2.getChildren().add(ls4);
    		vbox.getChildren().add(hbox2);
    		hbox2.getChildren().add(ls3);
    	
    		vbox.setPadding(new Insets(10, 10, 10, 10));
    		hbox.setPadding(new Insets(0, 10, 10, 155));
    		vbox2.setPadding(new Insets(10, 10, 10, 85));
    		hbox2.setPadding(new Insets(0, 10, 0, 15));
    		
    		butop.setStyle("-fx-base:  #ADFF2F;");
    		buthe.setStyle("-fx-base: #87CEEB;");
    		
    		Scene scene = new Scene(vbox, 450, 190);
    		Stage.setScene(scene);
            Stage.show();	
            
        });
		
		butop.setOnAction(new EventHandler<ActionEvent>(){
        	
            public void handle(ActionEvent arg0) {
                FileChooser fileChooser = new FileChooser();                 
                
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
                fileChooser.getExtensionFilters().add(extFilter);                 
                
                File file = fileChooser.showOpenDialog(Stage);
                if(file != null){
                    ta.setText("³������ ����:"+"\n"+readFile(file));
                }
                
                VBox vbox = new VBox();
        		HBox hbox = new HBox();
        		VBox vbox2 = new VBox();
        		HBox hbox2 = new HBox();
        		HBox hbox3 = new HBox();
        		HBox hbox4 = new HBox();
        		
        		vbox.getChildren().addAll(hbox4, hbox, ta, hbox3, hbox2);
        		hbox.getChildren().addAll(butsn,butsa);
        		vbox2.getChildren().add(buthe);
        		hbox2.getChildren().add(table);
        		hbox3.getChildren().addAll(buttf,butts);
        		hbox4.getChildren().addAll(butop, vbox2);
        		
        		vbox.setPadding(new Insets(10, 10, 10, 10));
        		hbox.setPadding(new Insets(10, 10, 10, 0));
        		vbox2.setPadding(new Insets(0, 0, 0, 190));
        		hbox2.setPadding(new Insets(10, 0, 10, 0));
        		hbox3.setPadding(new Insets(10, 0, 0, 0));
                
        		table.setStyle("-fx-base:  #A9A9A9;");
        		ta.setStyle("-fx-base:  #A9A9A9;");
        		butop.setStyle("-fx-base:  #ADFF2F;");
        		butsa.setStyle("-fx-base:  #ADFF2F;");
        		buttf.setStyle("-fx-base:  #ADFF2F;");
        		butts.setStyle("-fx-base:  #ADFF2F;");
        		butsn.setStyle("-fx-base:  #ADFF2F;");
                
        		Scene scene = new Scene(vbox, 336, 550);
        		Stage.setScene(scene);
                Stage.show();
            } 
            
        });
		
		butsn.setOnAction((ActionEvent event) -> {	 
			ta.setText(s);
            butsn.setDisable(true);
            butsp.setDisable(true);
            butsa.setDisable(false);
        });
		
		butsa.setOnAction((ActionEvent event) -> {	            
	            
	            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("���� RTF", "*.rtf");
	            fileChooser.getExtensionFilters().add(extFilter);	            
	            
	            File file1 = fileChooser.showSaveDialog(Stage);
	            
	            if(file1 != null){
	                SaveFile(ta.getText(), file1);
	            }
	        });
		 
		buttf.setOnAction((ActionEvent event) -> {
			 
		        TableColumn authorCol = new TableColumn("�����");
		        authorCol.setMinWidth(110);
		        authorCol.setMaxWidth(110);
		        authorCol.setCellValueFactory(new PropertyValueFactory<Person,String>("author"));
		 
		        TableColumn birthCol = new TableColumn("г� ����������");
		        birthCol.setMinWidth(104);
		        birthCol.setMaxWidth(104);
		        birthCol.setCellValueFactory(new PropertyValueFactory<Person,String>("birth"));
		        
		        
		        TableColumn countryCol = new TableColumn("�����");
		        countryCol.setMinWidth(100);
		        countryCol.setMaxWidth(100);
		        countryCol.setCellValueFactory(new PropertyValueFactory<Person,String>("country"));
		 
		        data = FXCollections.observableArrayList(list);

		        table.setItems(data);
		        
		        table.getColumns().addAll(authorCol, birthCol, countryCol);
		        buttf.setDisable(true);
		        buttf.setStyle("-fx-base:  #DC143C;");
		        butts.setDisable(false);
		        table.setDisable(false);
		        butop.setDisable(true);
		        ta.setText("������� ��������� ��������� ������:"+"\n"+s);
		        
	        });
		
		butts.setOnAction((ActionEvent event) -> {	            
	            
	            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("���� RTF", "*.rtf");
	            fileChooser.getExtensionFilters().add(extFilter);	            
	            
	            File file1 = fileChooser.showSaveDialog(Stage);
	            
	            if(file1 != null){
	            	SaveFileTable(table.getItems(), file1);
	            }
	        });
		 
		buthe.setOnAction((ActionEvent event) -> {
			 ta.setText("�� �������� ��������� ��� ���������� ����� �" + "\n" +"��������� ���������� �������� �����."+ "\n" +"\n"
		 + "�� ��������� ���� �������� �� ������� �������-"+"\n"+"���� ���� ���� �� ����������� ��������� �� "+
					 "\n"+"������� ���� �� ��� ������������ ����`����." +"\n"+"\n" 
		 + "                               ��������!!! "+"\n"+"-��������� ������� ������� ���� 1 ���, ���"+"\n"
					 +"  ������ �������� �������� ����;"+"\n"+"-���� ��������� ����� �� ���� �������������"+"\n"
		 +"  ����� ����������� � �������;"+"\n"+"-�� ������ ���������� ��������� ������� � ���"+"\n"
					 +"  ��� ������ �� �������� ����� ���� ��� ��"+"\n"+"  �������� ���� ���������� ����������� �����;");
			 butsn.setDisable(false);
			 butsa.setDisable(true);
	        });
			

		table.setMinWidth(312);

		 
        tt1.setText("���� ��� ����������� ������ �� �� ��������");
		ta.setTooltip(tt1);
		tt2.setText("�������� ��� ���������� �����");
		butsa.setTooltip(tt2);
		tt3.setText("������� ��� ����������� �� ���������� ������");
		table.setTooltip(tt3);
		tt4.setText("�������� ��� ������� ����");
		butop.setTooltip(tt4);
		tt5.setText("�������� ��� �������� ��������� ���������� �� ������ �������� ��������");
		buthe.setTooltip(tt5);
		tt6.setText("�������� ��� ��������� �������");
		buttf.setTooltip(tt6);
		tt7.setText("�������� ��� ���������� ����� �������");
		butts.setTooltip(tt7);
		tt8.setText("�������� ��� ��������� ��������� �����");
		butsn.setTooltip(tt8);
        
		
		
		VBox vbox = new VBox();
		HBox hbox = new HBox();
		VBox vbox2 = new VBox();
		VBox hbox2 = new VBox();
		
		vbox.getChildren().addAll(ls,vbox2,hbox);
		hbox.getChildren().addAll(butsp);
		vbox2.getChildren().add(ls2);
		vbox.getChildren().add(hbox2);
		hbox2.getChildren().add(ls3);
	
		vbox.setPadding(new Insets(10, 10, 10, 10));
		hbox.setPadding(new Insets(0, 10, 10, 175));
		vbox2.setPadding(new Insets(10, 10, 10, 135));
		hbox2.setPadding(new Insets(0, 10, 0, 225));
		
		butop.setStyle("-fx-base:  #ADFF2F;");
		buthe.setStyle("-fx-base: #87CEEB;");
		
		Scene scene = new Scene(vbox, 450, 300);
		Stage.setScene(scene);
        Stage.show();		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	private void SaveFile(String content, File file){
        try {
            FileWriter fileWriter;              
            fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException ex) {
        }          
    }
	
	private void SaveFileTable(ObservableList<Person> d, File file){
		try {
            FileWriter fileWriter;              
            fileWriter = new FileWriter(file);
            fileWriter.write(d.toString());
            ta.setText("�� �������� ���� :"+"\n"+d.toString());
            fileWriter.close();
        } catch (IOException ex) {
        }         
    }
	
	 
	private String readFile(File file){
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        
        try { 
            bufferedReader = new BufferedReader(new FileReader(file));          
            
            String text = "";
            s = "";
            while ((text = bufferedReader.readLine()) != null) {
            	s += text +" "+ "\n";
                sb.append(text + "\n"); 
            } 
        	y = s.split(" ");
            
            for(int j = 0; j < y.length-1; j++) {
        		String a1 = y[j++].trim();
        		String a2 = y[j++].trim();
        		String a3 = y[j].trim();
        		Person p = new Person(a1,a2,a3);
        		list.add(p);
        	}
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }       
        return sb.toString();
    }

	public  class Person {
   	 
    	private final SimpleStringProperty author;
        private final SimpleStringProperty birth;
        private final SimpleStringProperty country;
 
        private Person(String fauthor, String lbirth, String pcountry) {
            this.author = new SimpleStringProperty(fauthor);
            this.birth= new SimpleStringProperty(lbirth);
            this.country = new SimpleStringProperty(pcountry);
        }
        
        public String getAuthor() {
            return author.get();
        }
 
        public String getBirth() {
            return birth.get();
        }
        
        public String getCountry() {
        	return country.get();
        }
        
        public String toString() {
    		return this.author + " " + this.birth+ " " + this.country +"\n";
    	}
    }
    
}
