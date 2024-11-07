package org.example.din_t4_reservashotel.controllers;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Controller {

    @FXML private TextField tfDni;
    @FXML private TextField tfNombre;
    @FXML private TextField tfDireccion;
    @FXML private TextField tfLocalidad;
    @FXML private TextField tfProvincia;

    @FXML private DatePicker dpFechaLlegada;
    @FXML private DatePicker dpFechaSalida;
    @FXML private Spinner<Integer> spinnerNumHabitacion;
    @FXML private ComboBox<String> cboxTipoHabitacion;
    @FXML private CheckBox checkboxFumador;
    @FXML private RadioButton rbAlojamientoDesayuno;
    @FXML private RadioButton rbMediaPension;
    @FXML private RadioButton rbPensionCompleta;
    @FXML private Label lbFumador; // Mensaje de fumador

    @FXML private Button btAceptar;
    @FXML private Button btCancelar;
    @FXML private Button btLimpiar;
    private Scene scene; //Declarar la escena a nivel de clase

    //Iniciar el controller
    public void initialize() {
        //ToolTips
        tfDni.setTooltip(new Tooltip("Introduce el DNI"));
        tfNombre.setTooltip(new Tooltip("Introduce el nombre"));
        tfDireccion.setTooltip(new Tooltip("Introduce la dirección"));
        tfLocalidad.setTooltip(new Tooltip("Introduce la localidad"));
        tfProvincia.setTooltip(new Tooltip("Introduce la provincia"));
        dpFechaLlegada.setTooltip(new Tooltip("Selecciona la fecha de llegada"));
        dpFechaSalida.setTooltip(new Tooltip("Selecciona la fecha de salida"));
        spinnerNumHabitacion.setTooltip(new Tooltip("Selecciona el número de habitaciones"));
        cboxTipoHabitacion.setTooltip(new Tooltip("Selecciona el tipo de habitación"));
        checkboxFumador.setTooltip(new Tooltip("Marcar si eres fumador"));
        rbAlojamientoDesayuno.setTooltip(new Tooltip("Selecciona alojamiento y desayuno"));
        rbMediaPension.setTooltip(new Tooltip("Selecciona media pensión"));
        rbPensionCompleta.setTooltip(new Tooltip("Selecciona pensión completa"));

        //Listado de tipos de habitación
        cboxTipoHabitacion.getItems().addAll("Doble de uso individual", "Doble", "Junior Suite", "Suite");

        //Spinner para el número de habitaciones
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1); //Min 1, Max 10, Start 1
        spinnerNumHabitacion.setValueFactory(valueFactory);

        //Crear un ToggleGroup para los RadioButton (Solo puede elgir 1)
        ToggleGroup alojamientoGroup = new ToggleGroup();
        rbAlojamientoDesayuno.setToggleGroup(alojamientoGroup);
        rbMediaPension.setToggleGroup(alojamientoGroup);
        rbPensionCompleta.setToggleGroup(alojamientoGroup);

        //Evento para mostrar mensaje si se selecciona fumador
        checkboxFumador.setOnAction(event -> {
            if (checkboxFumador.isSelected()) {
                lbFumador.setText("En virtud de la Ley de Sanidad se informa a los clientes\n" +
                        "de que sólo podrán fumar en las habitaciones\n" +
                        "reservadas para tal fin.");
            } else {
                lbFumador.setText("");
            }
        });
    }

        //configurar los atajos de teclado
        public void setScene (Scene scene){

            this.scene = scene;
            scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {

                if (event.isAltDown()) {
                    if (event.getCode() == KeyCode.D) {
                        tfDni.requestFocus();
                    } else if (event.getCode() == KeyCode.N) {
                        tfNombre.requestFocus();
                    } else if (event.getCode() == KeyCode.L) {
                        tfLocalidad.requestFocus();
                    } else if (event.getCode() == KeyCode.P) {
                        tfProvincia.requestFocus();
                    } else if (event.getCode() == KeyCode.I) {
                        tfDireccion.requestFocus();

                    }
                }
            });
        }

    //botón Aceptar
    @FXML
    private void handleAceptar() {

        System.out.println("Reserva confirmada para: " + tfNombre.getText());
    }

    //botón Cancelar
    @FXML
    private void handleCancelar() {
        Stage stage = (Stage) btCancelar.getScene().getWindow();
        // Cierra la ventana
        System.out.println("Reserva cancelada");
        stage.close();
    }

    //limpiar los campos
    @FXML
    private void handleLimpiar() {
        tfDni.clear();
        tfNombre.clear();
        tfDireccion.clear();
        tfLocalidad.clear();
        tfProvincia.clear();
        dpFechaLlegada.setValue(null);
        dpFechaSalida.setValue(null);
        spinnerNumHabitacion.getValueFactory().setValue(1);
        cboxTipoHabitacion.getSelectionModel().clearSelection();
        checkboxFumador.setSelected(false);
        rbAlojamientoDesayuno.setSelected(false);
        rbMediaPension.setSelected(false);
        rbPensionCompleta.setSelected(false);
        lbFumador.setText("");
    }

    //Atajos de teclado para poner el foco en los campos
    @FXML
    private void handleKeyPress(KeyEvent event) {
        if (event.getCode() == KeyCode.D) {
            tfDni.requestFocus();
        } else if (event.getCode() == KeyCode.N) {
            tfNombre.requestFocus();
        } else if (event.getCode() == KeyCode.L) {
            tfLocalidad.requestFocus();
        } else if (event.getCode() == KeyCode.P) {
            tfProvincia.requestFocus();
        }
    }
}