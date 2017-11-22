package sample;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
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
    public Cola cola= new Cola();//Creamos instancia de la clase cola para poder utilizar sus métodos
    public ImageView imagen(){//Método que permite mandar la imagen a donde se requiera solo con su nombre.
        Image image = new Image("sample/95790.png");//Convertimos nuestra imagen en instancia
        ImageView iv1=new ImageView();//La imagen anterior se alojara en este objeto iv1.
        iv1.setFitHeight(60);//Altura de la imagen
        iv1.setFitWidth(30);//Anchura de la imagen
        iv1.setImage(image);//Colocamos el objeto imagén el el control ImageView
        return iv1;//Retornamos el control con ImageView con la imagen
    }
    Alert alert = new Alert(Alert.AlertType.ERROR);//Mandamos a traer la clase Alert
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.insertar.setOnAction(new EventHandler<ActionEvent>( ) {//Evento clik de insertar
            @Override
            public void handle(ActionEvent event) {
                try {//Amortiguador de errores de este evento
                    if (cola.getTamaño( ) < 15) {//Establecemos un límite en las inserciones de 15
                        int valor = parseInt(insertarTxt.getText( ));//Convertimos lo que manda el usuario a entero
                        cola.insertar(valor);//Mandamos lo que inserto el usuario a la clase cola
                        //Creamos un label para almacenar el número insertado con su imagen
                        Label label = new Label( );
                        label.maxWidth(50);
                        label.setText(insertarTxt.getText( ));
                        //Creamos un hbox para almacenar nuestra imagen con su número de insertado
                        HBox hBox = new HBox(5);
                        hBox.prefWidth(40);
                        label.maxWidth(50);
                        hBox.getChildren( ).add(label);
                        hBox.getChildren( ).add(imagen( ));
                        cola1.getChildren( ).add(hBox);//Colocamos el hbox en el contenedor cola1.
                        resultado.setText("Usted a insertado la cantidad: " + valor);//Mandamos mensaje al usuario en label resultado
                        insertarTxt.setText("");//Vaciamos nuestro TextField
                    } else {//Mandamos mensaje al usuario en alert tipo error
                        alert.setTitle("Cuadro de Error");
                        alert.setHeaderText("Error");
                        alert.setContentText("A superado el límite de inserciones ");
                        alert.showAndWait();
                    }
                }catch (Exception e){//Mandamos mensaje al usuario en alert tipo error
                    alert.setTitle("Cuadro de Error");
                    alert.setHeaderText("Error");
                    alert.setContentText("Inserte un valor númerico en el recuadro");
                    alert.showAndWait();
                }
            }
        });
        this.extraer.setOnAction(new EventHandler<ActionEvent>( ) {//Evento clik de extraer
            @Override
            public void handle(ActionEvent event) {
                try {//Amortiguador de errores de este evento
                    cola1.getChildren( ).remove(0);//Removemos el primer elemento del hbox
                    resultado.setText("Ústed extrajo la cantidad: "+String.valueOf(cola.extraer( )));//Mandamos mensaje al usuario en label resultado
                }catch (Exception e){//Mandamos mensaje al usuario en alert tipo error
                    alert.setTitle("Cuadro de información");
                    alert.setHeaderText("Información");
                    alert.setContentText("La cola no tiene elementos que extraer");
                    alert.showAndWait();
                }
            }
        });
        this.tamaño.setOnAction(new EventHandler<ActionEvent>( ) {//Evento clik de tamaño
            @Override
            public void handle(ActionEvent event) {
                resultado.setText("El tamaño de la cola es: "+ cola.getTamaño());//Mandamos mensaje al usuario en label resultado
            }
        });
        this.vaciar.setOnAction(new EventHandler<ActionEvent>( ) {//Evento clik de vaciar
            @Override
            public void handle(ActionEvent event) {
                cola1.getChildren().clear();//Limpiamos el contenedor principal
                System.gc();//Llamamos a la papelera
                resultado.setText(cola.vaciarLista());//Mandamos mensaje al usuario en label resultado
            }
        });
        this.buscar.setOnAction(new EventHandler<ActionEvent>( ) {//Evento clik de buscar
            @Override
            public void handle(ActionEvent event) {
                try {//Amortiguador de errores de este evento
                    int buscar=parseInt(buscarTxt.getText());//Convertimos lo que manda el usuario a entero
                    cola.buscarXValor(buscar);//Mandamos el valor que queremos buscar a la clase cola
                    resultado.setText(cola.buscarXValor(buscar));//Mandamos mensaje al usuario en label resultado
                    buscarTxt.setText("");//Vaciamos nuestro TextField
                }catch (Exception e){//Mandamos mensaje al usuario en alert tipo error
                    alert.setTitle("Cuadro de Error");
                    alert.setHeaderText("Error");
                    alert.setContentText("Inserte un valor númerico en el recuadro");
                    alert.showAndWait();
                     }
            }
        });
    }
}
