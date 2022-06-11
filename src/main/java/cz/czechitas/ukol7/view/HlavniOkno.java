package cz.czechitas.ukol7.view;

import cz.czechitas.ukol7.Aplikace;
import cz.czechitas.ukol7.Barva;
import cz.czechitas.ukol7.controller.PreferenceController;
import cz.czechitas.ukol7.formbuilder.FormBuilder;
import cz.czechitas.ukol7.formbuilder.FormBuilderWithContainer;
import cz.czechitas.ukol7.model.PreferenceBean;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class HlavniOkno extends JFrame {

    private final PreferenceController controller;

    public HlavniOkno(PreferenceController controller) throws HeadlessException {
        super("Přezdívka + oblíbená barva");
        this.controller = controller;
        this.init();
    }

    public void start() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(Aplikace.class.getResource("czechitas-icon.png")).getImage());
        setLayout(new MigLayout("wrap 2", "[right]rel[50:75:250,grow,fill]unrel[right]rel[50:75:250,grow,fill]"));
        setMinimumSize(new Dimension(400, 200));

        FormBuilderWithContainer<PreferenceBean> formBuilder = FormBuilder.create(controller.getModel())
                .container(this);

        formBuilder
                .label("&Přezdívka:")
                .textField("prezdivka")
                .add("left, span");

        formBuilder
                .label("&Oblíbená barva:")

                .radioButton("Bílá", "barva", Barva.Bila.toString())
                .add("right, span")
                .radioButton("Černá", "barva", Barva.Cerna.toString())
                .add("right, span")
                .radioButton("Modrá", "barva", Barva.Modra.toString())
                .add("right, span")
                .radioButton("Zelená", "barva", Barva.Zelena.toString())
                .add("right, span")
                .radioButton("Červená", "barva", Barva.Cervena.toString())
                .add("right, span")
                .radioButton("Žlutá", "barva", Barva.Zluta.toString())
                .add("right, span");


        formBuilder
                .panel(panel -> {

                    JButton ulozitButton = new JButton(controller.getUlozitAction());

                    getRootPane().setDefaultButton(ulozitButton);

                    panel.add(ulozitButton);
                })
                .add("right, span");

        pack();
    }
}
