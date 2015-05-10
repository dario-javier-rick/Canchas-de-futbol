package Logica;

import Persistencia.UsuarioDAC;

public class Usuario {
	
	private static UsuarioDAC DAC = new UsuarioDAC();
	
	public static boolean validarDatos(String usuario, char[] contrase�a)
	{
		String password = "";
		for (int i = 0; i< contrase�a.length; i++)
		{
			password = password + contrase�a[i];
		}
		return DAC.validarDatos(usuario, password);
	}

}
