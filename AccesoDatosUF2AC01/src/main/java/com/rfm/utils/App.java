package com.rfm.utils;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.Insets;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Choice;

public class App {

	private JFrame frmCrud;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frmCrud.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCrud = new JFrame();
		frmCrud.setTitle("CRUD");
		frmCrud.getContentPane().setBackground(Color.WHITE);
		frmCrud.setBounds(100, 100, 800, 437);
		frmCrud.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuPrincipal = new JMenuBar();
		frmCrud.setJMenuBar(menuPrincipal);
		
		JMenu menuOpciones = new JMenu("Opciones");
		menuPrincipal.add(menuOpciones);
		
		JMenuItem menuItemPrincipal = new JMenuItem("Volver a la pantalla principal");
		menuOpciones.add(menuItemPrincipal);
		
		JMenuItem menuItemSalir = new JMenuItem("Salir");
		menuItemSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menuOpciones.add(menuItemSalir);
		
		JMenu menuCrear = new JMenu("Crear");
		menuPrincipal.add(menuCrear);
		
		JMenuItem menuItemCrearEspecie = new JMenuItem("Crear Super Especie");
		menuCrear.add(menuItemCrearEspecie);
		menuItemCrearEspecie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel panelCrearEspecie = new JPanel();
				panelCrearEspecie.setVisible(true);
			}
		});
		
		JMenuItem menuItemCrearGuerrero = new JMenuItem("Crear Super Guerrero");
		menuCrear.add(menuItemCrearGuerrero);
		
		JMenu menuConsultar = new JMenu("Consultar");
		menuPrincipal.add(menuConsultar);
		
		JMenuItem menuItemConsultarGuerreros = new JMenuItem("Consultar Super Guerreros");
		menuConsultar.add(menuItemConsultarGuerreros);
		menuItemConsultarGuerreros.setHorizontalAlignment(SwingConstants.LEFT);
		
		JMenuItem menuItemConsultarEspecies = new JMenuItem("Consultar Super Especies");
		menuConsultar.add(menuItemConsultarEspecies);
		
		JMenu menuEditar = new JMenu("Editar");
		menuPrincipal.add(menuEditar);
		
		JMenuItem menuItemAddPoderGuerrero = new JMenuItem("Añadir poder a Super Guerrero");
		menuEditar.add(menuItemAddPoderGuerrero);
		
		JMenuItem menuItemReset = new JMenuItem("Resetear poderes de Super Guerrero");
		menuEditar.add(menuItemReset);
		
		JMenu menuBorrar = new JMenu("Borrar");
		menuPrincipal.add(menuBorrar);
		
		JMenuItem menuItemBorrarGuerrero = new JMenuItem("Borrar Super Guerrero");
		menuBorrar.add(menuItemBorrarGuerrero);
		
		JMenuItem menuItemBorrarEspecie = new JMenuItem("Borrar Super Especie");
		menuBorrar.add(menuItemBorrarEspecie);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{782, 0};
		gridBagLayout.rowHeights = new int[]{369, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		frmCrud.getContentPane().setLayout(gridBagLayout);
		
		JTextArea textoBienvenida = new JTextArea();
		textoBienvenida.setEditable(false);
		textoBienvenida.setText("BIENVENIDO!");
		GridBagConstraints gbc_textoBienvenida = new GridBagConstraints();
		gbc_textoBienvenida.insets = new Insets(0, 0, 5, 0);
		gbc_textoBienvenida.gridx = 0;
		gbc_textoBienvenida.gridy = 0;
		frmCrud.getContentPane().add(textoBienvenida, gbc_textoBienvenida);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
