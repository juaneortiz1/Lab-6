package presentation;
import domain.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AManufacturingGUI extends JFrame{
    private JMenu menu;
    private JMenuBar menuBar;
    private JMenuItem nuevo, abra00, guarde00, importe, exporte, salir;
    private JFileChooser fileChooser;
    public static final int SIDE=20;
    public final int SIZE;
    private JButton ticTacButton;
    private JPanel  controlPanel;
    private PhotoAManufacturing photo;
    private AManufacturing aManufacturing;
   
    private AManufacturingGUI() {
        aManufacturing=new AManufacturing();
        SIZE=aManufacturing.getSize();
        prepareElements();
        prepareActions();
    }
    
    private void prepareElements() {
        setTitle("aManufacturing celular");
        photo=new PhotoAManufacturing(this);
        ticTacButton=new JButton("Tic-tac");
        setLayout(new BorderLayout());
        add(photo,BorderLayout.NORTH);
        add(ticTacButton,BorderLayout.SOUTH);
        setSize(new Dimension(SIDE*SIZE+15,SIDE*SIZE+42));
        setResizable(false);
        photo.repaint();
        prepareElementosMenu();
    }
    public void prepareElementosMenu(){
        menuBar = new JMenuBar();
        menu = new JMenu("Menu");
        fileChooser = new JFileChooser();

        nuevo = new JMenuItem("Nuevo");
        abra00 = new JMenuItem("Abrir");
        guarde00 = new JMenuItem("Guardar como");
        importe = new JMenuItem("Importar");
        exporte = new JMenuItem("Exportar como");
        salir = new JMenuItem("salir");

        menu.add(nuevo);
        menu.add(abra00);
        menu.add(guarde00);
        menu.add(importe);
        menu.add(exporte);
        menu.add(salir);

        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    private void prepareActions(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        prepareActionsMenu();
        ticTacButton.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    ticTacButtonAction();
                }
            });

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    opSalir();
                }catch (ReplicateExcepcion excepcion){
                    excepcion.getMessage();
                }
            }
        });

    }

    private void prepareActionsMenu() {
        nuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    opNuevo();
                }catch (ReplicateExcepcion excepcion){
                    excepcion.getMessage();
                }
            }
        });
        guarde00.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    opGuardar();
                }catch (ReplicateExcepcion excepcion){
                    excepcion.getMessage();
                }
            }
        });
        abra00.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    opAbrir();
                }catch (ReplicateExcepcion excepcion){
                    excepcion.getMessage();
                }
            }
        });
        importe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    opImportar();
                }catch (ReplicateExcepcion excepcion){
                    excepcion.getMessage();
                }
            }
        });
        exporte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    opExportar();
                }catch (ReplicateExcepcion excepcion){
                    excepcion.getMessage();
                }
            }
        });
        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    opSalir();
                }catch (ReplicateExcepcion excepcion){
                    excepcion.getMessage();
                }
            }
        });
    }

    private void opNuevo() throws ReplicateExcepcion {
        AManufacturingGUI frame = this;
        int resultado = JOptionPane.showConfirmDialog(frame, "¿Está seguro que quiere abrir una nueva pestaña?", "Nuevo", JOptionPane.YES_NO_OPTION);
        if (resultado == JOptionPane.YES_OPTION) {
            frame.setVisible(false);
            AManufacturingGUI gui = new AManufacturingGUI();
            gui.setVisible(true);
        } else if (resultado == JOptionPane.NO_OPTION) {
            frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
    }

    private void opExportar() throws ReplicateExcepcion {
    }

    private void opImportar() throws ReplicateExcepcion  {
    }

    private void opAbrir() throws ReplicateExcepcion {

    }
    private void opGuardar() throws ReplicateExcepcion {

    }
    private void opSalir() throws ReplicateExcepcion{
        int r = JOptionPane.showConfirmDialog(null,"¿Está seguro que desea salir?");
        if(r == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }

    private void ticTacButtonAction() {
        aManufacturing.ticTac();
        photo.repaint();
    }



    public AManufacturing getaManufacturing(){
        return aManufacturing;
    }
    
    public static void main(String[] args) {
        AManufacturingGUI ca=new AManufacturingGUI();
        ca.setVisible(true);
    }  
}

class PhotoAManufacturing extends JPanel{
    private AManufacturingGUI gui;

    public PhotoAManufacturing(AManufacturingGUI gui) {
        this.gui=gui;
        setBackground(Color.white);
        setPreferredSize(new Dimension(gui.SIDE*gui.SIZE+10, gui.SIDE*gui.SIZE+10));         
    }


    public void paintComponent(Graphics g){
        AManufacturing aManufacturing=gui.getaManufacturing();
        super.paintComponent(g);
         
        for (int c=0;c<=aManufacturing.getSize();c++){
            g.drawLine(c*gui.SIDE,0,c*gui.SIDE,aManufacturing.getSize()*gui.SIDE);
        }
        for (int f=0;f<=aManufacturing.getSize();f++){
            g.drawLine(0,f*gui.SIDE,aManufacturing.getSize()*gui.SIDE,f*gui.SIDE);
        }       
        for (int f=0;f<aManufacturing.getSize();f++){
            for(int c=0;c<aManufacturing.getSize();c++){
                if (aManufacturing.getThing(f,c)!=null){
                    g.setColor(aManufacturing.getThing(f,c).getColor());
                    if (aManufacturing.getThing(f,c).shape()==Thing.SQUARE){                  
                        if (aManufacturing.getThing(f,c).isActive()){
                            g.fillRoundRect(gui.SIDE*c+1,gui.SIDE*f+1,gui.SIDE-2,gui.SIDE-2,2,2);
                        }else{
                            g.drawRoundRect(gui.SIDE*c+1,gui.SIDE*f+1,gui.SIDE-2,gui.SIDE-2,2,2);    
                        }
                    }else {
                        if (aManufacturing.getThing(f,c).isActive()){
                            g.fillOval(gui.SIDE*c+1,gui.SIDE*f+1,gui.SIDE-2,gui.SIDE-2);
                        } else {
                            g.drawOval(gui.SIDE*c+1,gui.SIDE*f+1,gui.SIDE-2,gui.SIDE-2);
                        }
                    }
                }
            }
        }
    }



}