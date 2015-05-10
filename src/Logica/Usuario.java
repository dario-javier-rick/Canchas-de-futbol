package Logica;

import Persistencia.UsuarioDAC;

public class Usuario {
	
	private static UsuarioDAC DAC = new UsuarioDAC();
	
	public static boolean validarDatos(String usuario, char[] contraseña)
	{
		String password = "";
		for (int i = 0; i< contraseña.length; i++)
		{
			password = password + contraseña[i];
		}
		return DAC.validarDatos(usuario, password);
	}

}
