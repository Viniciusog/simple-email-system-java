package programa;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.SimpleEmail;

public class EnviarEmail {
	public static void main(String[] args) {

		String meuEmail = "yourEmail";
		String minhaSenha = "yourPassword";

		SimpleEmail email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator(meuEmail, minhaSenha));
		email.setSSLOnConnect(true); // Vai ativar a conexão de forma segura

		try {
			
			email.setFrom(meuEmail);
			email.setSubject("Meu primeiro envio de email com java");  			//Título que irá aparecer no email
			email.setMsg("Como enviar um email através de um programa java"); 	// Aqui vem a mensagem por email
			email.addTo(meuEmail); 												// Aqui você escolhe para quem enviar o email
			email.send();		   												//Envia email
			System.out.println("Email enviado com sucesso!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
