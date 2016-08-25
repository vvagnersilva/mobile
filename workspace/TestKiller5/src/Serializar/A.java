package Serializar;
import java.io.Serializable;


public class A implements Serializable
{
	private static final long serialVersionUID = 1L;
	public String nome;
	public A(String n){this.nome = n;}
}