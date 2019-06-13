package programa;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.SimpleEmail;

public class EnviarEmail extends JFrame implements ActionListener {

	private String senha;
	private String email;
	private String mensagem;
	private String destinatario;
	private String titulo;

	private JLabel lblTitulo = new JLabel("Insira um Título ");
	private JLabel lblMensagem = new JLabel("Escreva uma mensagem ");
	private JLabel lblDestinatario = new JLabel("Destinatário ");
	private JLabel lblEmail = new JLabel("Seu email");
	private JLabel lblSenha = new JLabel("Sua senha");

	private JTextField txtTitulo = new JTextField();
	private JTextField txtEmail = new JTextField();
	private JTextField txtDestinatario = new JTextField();
	private JTextField txtMensagem = new JTextField();
	private JPasswordField campoSenha = new JPasswordField();

	private JPanel pnlPainel = new JPanel();
	private JButton btnOk = new JButton("Concluir");

	public EnviarEmail() {
		GerarTela();
	}

	public void GerarTela() {
		this.setSize(new Dimension(300, 550));
		setLocationRelativeTo(null);
		setResizable(false);

		lblTitulo.setBounds(50, 40, 200, 30);
		txtTitulo.setBounds(50, 75, 200, 30);
		lblDestinatario.setBounds(50, 120, 100, 30);
		txtDestinatario.setBounds(50, 160, 200, 30);
		lblMensagem.setBounds(50, 200, 160, 30);
		txtMensagem.setBounds(50, 240, 200, 30);
		lblEmail.setBounds(50, 280, 100, 30);
		txtEmail.setBounds(50, 320, 200, 30);
		lblSenha.setBounds(50, 360, 200, 30);
		campoSenha.setBounds(50, 400, 200, 30);
		btnOk.setBounds(80, 460, 120, 30);

		pnlPainel.setBackground(Color.getHSBColor(135, 202, 235));

		this.add(lblTitulo);
		this.add(txtTitulo);
		this.add(lblDestinatario);
		this.add(txtDestinatario);
		this.add(lblMensagem);
		this.add(txtMensagem);
		this.add(lblEmail);
		this.add(txtEmail);
		this.add(lblSenha);
		this.add(campoSenha);
		this.add(btnOk);
		this.add(pnlPainel);

		btnOk.addActionListener(this);
		this.setVisible(true);

	}

	public void setSenha() {
		this.senha = campoSenha.getText();
	}

	public String getSenha() {
		return this.senha;
	}

	public void setEmail() {
		this.email = txtEmail.getText();
	}

	public String getEmail() {
		return this.email;
	}

	public void setMensagem() {
		this.mensagem = txtMensagem.getText();
	}

	public String getMensagem() {
		return this.mensagem;
	}

	public void setTitulo() {
		this.titulo = txtTitulo.getText();
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setDestinatario() {
		this.destinatario = txtDestinatario.getText();
	}

	public String getDestinatario() {
		return this.destinatario;
	}

	public void autenticar() {
		setTitulo();
		setMensagem();
		setDestinatario();
		setEmail();
		setSenha();

		String meuEmail = getEmail();
		String minhaSenha = getSenha();

		SimpleEmail email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator(meuEmail, minhaSenha));
		email.setSSLOnConnect(true); // Vai ativar a conexão de forma segura

		try {

			email.setFrom(meuEmail);
			email.setSubject(getTitulo()); // Título que irá aparecer no email
			email.setMsg(getMensagem()); // Aqui vem a mensagem por email
			email.addTo(getDestinatario()); // Aqui você escolhe para quem enviar o email
			email.send(); // Envia email
			JOptionPane.showMessageDialog(null, "enviado com sucesso");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOk) {
			autenticar();

		}
	}

	public static void main(String[] args) {
		new EnviarEmail();
	}
}
