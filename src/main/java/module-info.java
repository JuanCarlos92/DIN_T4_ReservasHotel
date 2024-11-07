module org.example.din_t4_reservashotel {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.din_t4_reservashotel to javafx.fxml;
    exports org.example.din_t4_reservashotel;
    exports org.example.din_t4_reservashotel.controllers;
    opens org.example.din_t4_reservashotel.controllers to javafx.fxml;
}