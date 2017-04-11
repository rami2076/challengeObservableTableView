package controller;

import application.MainApp;
import beans.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import logic.util.DateUtil;

public class PersonOverviewController {
	@FXML
	private TableView<Person> personTable;
	@FXML
	private TableColumn<Person,String> firstNameColumn;
	@FXML
	private TableColumn<Person,String> lastNameColumn;

	@FXML
	private Label firstNameLabel;
	@FXML
	private Label lastNameLabel;
	@FXML
	private Label streetLabel;
	@FXML
	private Label postalCodeLabel;
	@FXML
	private Label cityLabel;
	@FXML
	private Label birthdayLabel;

	@FXML
	private Button deleteButton;

	//Reference to the main application.
	private MainApp mainApp;

	// it is run after Inititialize()
	public PersonOverviewController(){

	}
	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize(){
		 // Initialize the person table with the two columns.
		// I need  to know cellvalueFactory.
		firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
		lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
		//Clear person details.
		showPersonDetails(null);
		//Listen for selection changes and show the person details when changed.
		personTable.getSelectionModel().selectedItemProperty().addListener(
			(observable,oldValue,newValue)->showPersonDetails(newValue));

	}
	//解析中↓
	/**
	 * Is called by the main application to give a reference back to itself.
	 *
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp ){
		this.mainApp = mainApp;
		// Add observable list data to the table
		personTable.setItems(mainApp.getPersonData());
	}


	/**
	 *Fills all text fields to show details about the person.
	 *if the specified is null , all text fields are cleared.
	 *
	 * @param person the person or null
	 */
	private void showPersonDetails(Person person){
		if(person != null){
			//fill the labels with info from the person object.
			firstNameLabel.setText(person.getFirstName());
			lastNameLabel.setText(person.getLastName());
			streetLabel.setText(person.getStreet());
			postalCodeLabel.setText(Integer.toString(person.getPostalCode()));
			cityLabel.setText(person.getCity());
			birthdayLabel.setText(DateUtil.format(person.getBirthday()));

			//TODO::  we need a way to convert the birthday  into a String.
			//birthdayLabel.setText(person.getBirthday(...));
		}else{
			//person is null, remove  all the text
			firstNameLabel.setText("");
			lastNameLabel.setText("");
			postalCodeLabel.setText("");
			streetLabel.setText("");
			cityLabel.setText("");
			birthdayLabel.setText("");

		}
	}

	/**
	 * Called when the user click on the delete button.
	 */
	@FXML
	private  void handleDeletePerson( ){
		int selctedIndex = personTable.getSelectionModel().getSelectedIndex();
		try{
			if(selctedIndex >=0){
		personTable.getItems().remove(selctedIndex);
			}else{
				//nothing selected.
				Alert alert = new Alert(AlertType.WARNING);
				alert.initOwner(mainApp.getPrimaryStage());
				alert.setTitle("No Selection.");
				alert.setHeaderText("No Person Selected");
				alert.setContentText("Please select a person in the table.");

				alert.showAndWait();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

aaaaaaaaatesttestetstet

}
