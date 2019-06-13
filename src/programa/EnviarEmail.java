package programa;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.SimpleEmail;

public class EnviarEmail extends JFrame implements ActionListener {

	private String senha;
	private String email;
	private JPasswordField campoSenha = new JPasswordField();
	private JTextField txtEmail = new JTextField();
	private JPanel pnlPainel = new JPanel();
	private JButton btnOk = new JButton("Concluir");

	public EnviarEmail() {
		GerarTela();
	}

	public void GerarTela() {
		this.setSize(new Dimension(300, 220));
		setLocationRelativeTo(null);
		setResizable(false);
		
		txtEmail.setBounds(50, 30, 200, 30);
		campoSenha.setBounds(50, 80, 200, 30);
		btnOk.setBounds(95, 150, 100, 30);
		pnlPainel.setBackground(Color.getHSBColor(135, 202, 235));
		
		this.add(campoSenha);
		this.add(btnOk);
		this.add(txtEmail);
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


	public void autenticar() {
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
			email.setSubject("Salve email por java"); // Título que irá aparecer no email
			email.setMsg("IIIIII DEU CERTO AHUHAUHUSHHAUHSUHUHAUHSHUASH GGG"); // Aqui vem a mensagem por email
			email.addTo("riandd3@gmail.com"); // Aqui você escolhe para quem enviar o email
			email.send(); // Envia email
			System.out.println("Email enviado com sucesso!");

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
