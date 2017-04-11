package application;



import beans.Person;
import controller.PersonOverviewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;



/**
 * @author nyx
 *
 */
public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;

	private ObservableList<Person> personData = FXCollections.observableArrayList();

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("AddressApp");

		initRootLayOut();
		showPersonOverView();
	}


	/*
	 *Initializes the root layout.
	 */
	public void initRootLayOut(){
		try{
			//Load root layout from fxml file.
			System.out.println(MainApp.class.getResource("view/RootLayout.fxml"));
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane)loader.load();
			//Show the scene containing the root layout
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);//not resize
			primaryStage.show();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 *	Initializes the person overview inside the root layout.
	 */
	public void showPersonOverView(){
		try{
			//load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/PersonOverview.fxml"));
			AnchorPane personOverView = (AnchorPane)loader.load();
			//Set person over view into the center of root  layout.
			rootLayout.setCenter(personOverView);


			  // Give the controller access to the main app.
	        PersonOverviewController controller = loader.getController();
	        controller.setMainApp(this);


		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public Stage getPrimaryStage(){
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * constluctor
	 */
	public  MainApp(){
		//Add some sampledata
		personData.add(new Person("a","b") );
		personData.add(new Person("c","d") );
		personData.add(new Person("e","f") );
		personData.add(new Person("g","h") );
		personData.add(new Person("i","j") );
	}
	/**
     * Returns the data as an observable list of Persons.
     * @return
     */
	 public ObservableList<Person> getPersonData() {
	        return personData;
	    }
public boolean showPersonEditDialog(Person person){

return true;
}

}
