package Logica;

import Persistencia.UsuarioDAC;

public class Usuario {

	private static UsuarioDAC DAC = new UsuarioDAC();

	public static boolean validarDatos(String usuario, char[] contraseña) throws Exception {
		try
		{
		if (usuario.length() == 0) {
			throw new RuntimeException("Usuario vacío");
		} else {
			String password = "";
			for (int i = 0; i < contraseña.length; i++) {
				password = password + contraseña[i];
			}
			if (!DAC.validarDatos(usuario, password))
			{
				throw new RuntimeException("Contraseña incorrecta");
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
