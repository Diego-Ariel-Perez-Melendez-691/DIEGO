import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class usuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtid;
	private JTextField txtNombre;
	private JTextField txtAP;
	private JTextField txtAM;
	private JTextField txtCurp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					usuario frame = new usuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public usuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("usuarios");
		btnNewButton.setBounds(5, 5, 424, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("id:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(75, 54, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(75, 89, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("apellido paterno:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(28, 114, 93, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("apellido matermo:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(23, 139, 98, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("curp");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(75, 164, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		txtid = new JTextField();
		txtid.setBounds(131, 51, 158, 20);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(131, 86, 147, 20);
		contentPane.add(txtNombre);
		
		txtAP = new JTextField();
		txtAP.setColumns(10);
		txtAP.setBounds(131, 111, 147, 20);
		contentPane.add(txtAP);
		
		txtAM = new JTextField();
		txtAM.setColumns(10);
		txtAM.setBounds(131, 136, 147, 20);
		contentPane.add(txtAM);
		
		txtCurp = new JTextField();
		txtCurp.setColumns(10);
		txtCurp.setBounds(131, 165, 147, 20);
		contentPane.add(txtCurp);
		
		JButton btnguardar = new JButton("guardar");
		btnguardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			guardarUsuario();
			}
		});
		btnguardar.setBounds(28, 204, 89, 23);
		contentPane.add(btnguardar);
		
		JButton btnActualizar = new JButton("actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarUsuario();
			}
		});
		btnActualizar.setBounds(218, 204, 89, 23);
		contentPane.add(btnActualizar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultaUsuario();
			}
		});
		btnConsultar.setBounds(125, 204, 89, 23);
		contentPane.add(btnConsultar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarUsuario();
			}
		});
		btnEliminar.setBounds(314, 204, 89, 23);
		contentPane.add(btnEliminar);
	}
	public void guardarUsuario() {
		DatosUsuario du=new DatosUsuario();
		vUsuario u=new vUsuario();
		u.setNombre(txtNombre.getText());
		u.setAp(txtAM.getText());
		u.setAm(txtAP.getText());
		u.setCurp(txtCurp.getText());
		boolean guardado = du.insertavUsuario(u);
		if(guardado) {
			JOptionPane.showConfirmDialog(null, "guardado");
		}else {
			JOptionPane.showConfirmDialog(null, "no se pudo guardar");	
		}
	}
	
	public void consultaUsuario() {
		DatosUsuario du=new DatosUsuario();
		vUsuario u=du.consultaVUsuario(Integer.parseInt(txtid.getText()));
		if(u.getNombre()!=null) {
		txtNombre.setText(u.getNombre());
		txtAP.setText(u.getAp());
		txtAM.setText(u.getAm());
		txtCurp.setText(u.getCurp());
		}else {
			JOptionPane.showMessageDialog(null, "usuario no encontrado");
		}
	}
	public void actualizarUsuario() {
		DatosUsuario du=new DatosUsuario();
		vUsuario u=new vUsuario();
		u.setNombre(txtNombre.getText());
		u.setAp(txtAM.getText());
		u.setAm(txtAP.getText());
		u.setCurp(txtCurp.getText());
		u.setId(Integer.parseInt(txtid.getText()));
		boolean guardado = du.actualizavUsuario(u);
		if(guardado) {
			JOptionPane.showConfirmDialog(null, "Actualizado");
		}else {
			JOptionPane.showConfirmDialog(null, "no se pudo actualizar");	
		}
	}
	public void eliminarUsuario() {
		DatosUsuario du=new DatosUsuario();
		boolean eliminado=du.eliminarVUsuario(Integer.parseInt(txtid.getText()));
		if(eliminado) {
			JOptionPane.showMessageDialog(null, "usuario eliminado");
		}else {
			JOptionPane.showMessageDialog(null, "usuario no eliminado");
		}
	}
	}
