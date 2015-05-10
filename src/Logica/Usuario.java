package Logica;

import Persistencia.UsuarioDAC;

public class Usuario {
	
	private static UsuarioDAC DAC = new UsuarioDAC();
	
	public static boolean validarDatos(String usuario, char[] contraseņa)
	{
		String password = "";
		for (int i = 0; i< contraseņa.length; i++)
		{
			password = password + contraseņa[i];
		}
		return DAC.validarDatos(usuario, password);
	}

}
