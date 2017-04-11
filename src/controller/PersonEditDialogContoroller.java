package controller;

import beans.Person;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import logic.util.DateUtil;

 /**
  * Dialog to edit details of person.
 * @author nyx
 *
 */
public class PersonEditDialogContoroller {
	@FXML
	private TextField firstNameField;
	@FXML
	private TextField lastNameField;
	@FXML
	private TextField streetField;
	@FXML
	private TextField postalCodeField;
	@FXML
	private TextField cityField;
	@FXML
	private TextField birthdayField;


	private Stage dialogStage;
	private Person person;
	private boolean okClicked = false;


	/**
	 * Initializes the contoroller class. this method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void Initialize(){


	}

	/**
	 * Sets the person  to be edited in the dialog.
	 *
	 * @param person
	 */
	public void setPerson(Person person){
		this.person = person;

		firstNameField.setText(person.getFirstName());
		lastNameField.setText(person.getLastName());
		streetField.setText(person.getStreet());
		postalCodeField.setText(Integer.toString(person.getPostalCode()));
		cityField.setText(person.getCity());
		birthdayField.setText(DateUtil.format(person.getBirthday()));
		birthdayField.setPromptText("yyyy.mm.dd");
		//TODO:: 順序が逆でもよいのか調べる。
	}

	/**
	 * Returns true if the user clicked OK, false otherwise.
	 *
	 * @return
	 */
	public boolean isOkClicked(){
		return okClicked;
	}

	/**
	 * Called when the userClicked.
	 */
	@FXML
	private void handleOk(){
		if(isInputVailed()){
			person.setFirstName(firstNameField.getText());
			person.setLastName(lastNameField.getText());
			person.setStreet(streetField.getText());
			person.setPostalCode(Integer.parseInt(postalCodeField.getText()));
			person.setCity(cityField.getText());
			person.setBirthday(DateUtil.parse(birthdayField.getText()));

			okClicked = true;
			dialogStage.close();
		}
	}
/**
 * Vailedates the user input in the text fields.
 *
 * @return true if iinput the valid.
 */
private boolean isInputVailed(){
	//StringBuilder を使用したほうが効率が良い気がするが写経なのでSrring型を+演算子を用いて結合する
	String errorMassage ="";
	if(firstNameField.getText() == null || firstNameField.getText().length() ==0 ){
		errorMassage +="No valid first name!\n";
	}
	if(lastNameField.getText() == null || lastNameField.getText().length() ==0 ){
		errorMassage +="No valid last name!\n";
	}
	if(streetField.getText() == null || streetField.getText().length() ==0 ){
		errorMassage +="No valid street!\n";
	}
	if(postalCodeField.getText() == null || postalCodeField.getText().length() ==0 ){
		errorMassage +="No valid street!\n";
	}else{
		try{
			Integer.parseInt(postalCodeField.getText());
		}catch(NumberFormatException e){
			errorMassage +="No valid postal code (must be an integer) !\n";
		}
	}
	if(cityField.getText() == null || cityField.getText().length() ==0 ){
		errorMassage +="No valid street!\n";
	}
	if(birthdayField.getText()==null || birthdayField.getText().length() ==0 ){

	}
	return false;
}
     akosajopdjsaop
}
