package presentation;
import domain.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AManufacturingGUI extends JFrame{
    private JMenu menu;
    private JMenuBar menuBar;
    private JMenuItem nuevo, abra00, guarde00, importe, exporte;
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

    private void prepareActions(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        prepareActionsMenu();
        ticTacButton.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    ticTacButtonAction();
                }
            });

    }

    private void prepareActionsMenu() {
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
        opNuevo();
        opSalir();

    }

    private void opGuardar() throws ReplicateExcepcion {

    }

    private void opSalir() {
        AManufacturingGUI frame = this;
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                JPanel panel = new JPanel();
                panel.setSize(new Dimension(250, 250));
                panel.setLayout(null);
                JLabel label2 = new JLabel("Do you wanna exit?");
                label2.setVerticalAlignment(SwingConstants.TOP);
                label2.setHorizontalAlignment(SwingConstants.CENTER);
                label2.setBounds(20, 80, 200, 20);
                panel.add(label2);
                UIManager.put("OptionPane.minimumSize", new Dimension(400, 200));
                int res = JOptionPane.showConfirmDialog(null, panel, "Exit message",
                        JOptionPane.YES_NO_OPTION);
                if (res == 0) {
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                } else if (res == 1) {
                    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

                }
            }
        });
    }

    /**
     * Prepara el menu
     */
    public void prepareElementosMenu(){
        menuBar = new JMenuBar();
        menu = new JMenu("menu");
        fileChooser = new JFileChooser();

        abra00 = new JMenuItem("Abra");
        guarde00 = new JMenuItem("Guarde");
        importe = new JMenuItem("Importe");
        exporte = new JMenuItem("Exporte");


        menu.add(abra00);
        menu.add(guarde00);
        menu.add(importe);
        menu.add(exporte);

        menuBar.add(menu);
        setJMenuBar(menuBar);

    }
    private void opNuevo() {
        AManufacturingGUI frame = this;
        abra00.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent ev) {
                int resultado = JOptionPane.showConfirmDialog(frame,
                        "¿Está seguro que quiere abrir una nueva pestaña?", "Nuevo", JOptionPane.YES_NO_OPTION);
                if (resultado == JOptionPane.YES_OPTION) {
                    frame.setVisible(false);
                    AManufacturingGUI gui = new AManufacturingGUI();
                    gui.setVisible(true);


                } else if (resultado == JOptionPane.NO_OPTION) {
                    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });
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