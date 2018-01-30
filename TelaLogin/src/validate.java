
public class validate {
	public static boolean validation;
	public validate() {
		validation = false;
		String userdigitado, usernobanco, passdigitada, passnobanco;
		userdigitado = Inicio.userdigit;
		usernobanco = banco.user;
		passdigitada = Inicio.passdigit;
		passnobanco = banco.password;
		if (userdigitado.equals(usernobanco) && passdigitada.equals(passnobanco)) {
			validation = true;
		}
		
	}
}
