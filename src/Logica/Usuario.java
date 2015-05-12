package Logica;

import Persistencia.UsuarioDAC;

public class Usuario {

	private static UsuarioDAC DAC = new UsuarioDAC();

	public static boolean validarDatos(String usuario, char[] contrase�a) throws Exception {
		try
		{
		if (usuario.length() == 0) {
			throw new RuntimeException("Usuario vac�o");
		} else {
			String password = "";
			for (int i = 0; i < contrase�a.length; i++) {
				password = password + contrase�a[i];
			}
			if (!DAC.validarDatos(usuario, password))
			{
				throw new RuntimeException("Contrase�a incorrecta");
			}
			return true;
		}
		}
		catch (Exception e)
		{
			throw e;
		}
	}
}
