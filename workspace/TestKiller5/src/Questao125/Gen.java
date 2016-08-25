package Questao125;

enum enumElement 
{
	EARTH, WIND, 
	FIRE{public String info(){return "Hot";}
		}; // O ponto e virgula é OBRIGATORIO qdo ha um corpo
		
	public String info()
	{
		return "element";
	}
}
