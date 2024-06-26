module com.boombastic.mediatecafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires jdk.compiler;

    opens com.boombastic.mediatecafx to javafx.fxml;
    opens com.boombastic.mediatecafx.entity to org.hibernate.orm.core;

    exports com.boombastic.mediatecafx;
    exports com.boombastic.mediatecafx.controllers;
    opens com.boombastic.mediatecafx.controllers to javafx.fxml;
}