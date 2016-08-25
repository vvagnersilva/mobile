package Questao28;

public class Car
{
	//private int wheelCount;
	protected int wheelCount; // CORRECAO
	private String vin;

	public Car(String vin)
	{
		this.vin = vin;
		this.wheelCount = 4;
	}

	public String extend()
	{
		return "zommzomm";
	}

	public String getInfo()
	{
		return "VIN: " + this.vin + "wheels: " + this.wheelCount;
	}
}


