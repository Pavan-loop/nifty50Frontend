module com.nichi.nifty50frontend {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.naming;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires java.sql;

    opens com.nichi.nifty50frontend to javafx.fxml, org.hibernate.orm.core;
    opens com.nichi.nifty50frontend.controller to javafx.fxml;
    opens com.nichi.nifty50frontend.model to javafx.fxml;
    opens com.nichi.nifty50frontend.database.model to org.hibernate.orm.core;

    exports com.nichi.nifty50frontend;
    exports com.nichi.nifty50frontend.controller;
    exports com.nichi.nifty50frontend.model;
}