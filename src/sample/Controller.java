package sample;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;
import static java.lang.Integer.parseInt;
public class Controller implements Initializable{
    @FXML
    Button insertar, extraer, tamaño, vaciar, buscar;
    @FXML
    TextField insertarTxt, buscarTxt;
    @FXML
    HBox cola1;
    @FXML
    Label resultado;
    public Cola cola= new Cola();
    public ImageView imagen(){
        Image image = new Image("sample/95790.png");
        ImageView iv1=new ImageView();
        iv1.setFitHeight(60);
        iv1.setFitWidth(30);
        iv1.setImage(image);
        return iv1;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.insertar.setOnAction(new EventHandler<ActionEvent>( ) {
            @Override
            public void handle(ActionEvent event) {
                ScrollPane scroll = new ScrollPane();
                scroll.setContent(cola1);
                try {
                    if (cola.getTamaño( ) < 15) {
                        int valor = parseInt(insertarTxt.getText( ));
                        cola.insertar(valor);
                        Label label = new Label( );
                        label.prefWidth(10);
                        label.setText(insertarTxt.getText( ));
                        HBox hBox = new HBox( );
                        hBox.getChildren( ).add(label);
                        hBox.getChildren( ).add(imagen( ));
                        cola1.getChildren( ).add(hBox);
                        resultado.setText("Usted a insertado la cantidad: " + valor);
                        insertarTxt.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "El número de inserciones no puede ser mayor a 15");
                    }
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null, "Inserte números en los recuadros");}
            }
        });
        this.extraer.setOnAction(new EventHandler<ActionEvent>( ) {
            @Override
            public void handle(ActionEvent event) {
                try {

                    cola1.getChildren( ).remove(0);
                    resultado.setText("Ústed extrajo la cantidad: "+String.valueOf(cola.extraer( )));
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null, "La cola no tiene valores");
                }
            }
        });
        this.tamaño.setOnAction(new EventHandler<ActionEvent>( ) {
            @Override
            public void handle(ActionEvent event) {
                System.out.println(cola.getTamaño());
                resultado.setText("El tamaño de la cola es: "+ cola.getTamaño());
            }
        });
        this.vaciar.setOnAction(new EventHandler<ActionEvent>( ) {
            @Override
            public void handle(ActionEvent event) {
                cola1.getChildren().clear();
                System.gc();
                resultado.setText(cola.vaciarLista());
            }
        });
        this.buscar.setOnAction(new EventHandler<ActionEvent>( ) {
            @Override
            public void handle(ActionEvent event) {
                try {
                    int buscar=parseInt(buscarTxt.getText());
                    cola.buscarXValor(buscar);
                    resultado.setText(cola.buscarXValor(buscar));
                    buscarTxt.setText("");
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null,"Ingresa números en el recuadro");
                }

            }
        });
    }
}
