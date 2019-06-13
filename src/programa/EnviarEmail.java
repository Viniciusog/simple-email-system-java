package programa;

import javax.swing.JOptionPane;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.SimpleEmail;

import visual.Tela;

public class EnviarEmail {
	

	public void autenticar() {
		Tela t = new Tela();		
		t.gerarTela();	
		
		String meuEmail = t.getEmail();
		String minhaSenha = t.getSenha();

		SimpleEmail email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator(meuEmail, minhaSenha));
		email.setSSLOnConnect(true); // Vai ativar a conexão de forma segura

		try {

			email.setFrom(meuEmail);
			email.setSubject(t.getTitulo()); // Título que irá aparecer no email
			email.setMsg(t.getMensagem()); // Aqui vem a mensagem por email
			email.addTo(t.getDestinatario()); // Aqui você escolhe para quem enviar o email
			email.send(); // Envia email
			JOptionPane.showMessageDialog(null, "enviado com sucesso");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new EnviarEmail().autenticar();
	}
}
