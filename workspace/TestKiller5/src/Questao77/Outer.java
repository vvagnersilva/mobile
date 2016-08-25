package Questao77;

import java.awt.List;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

import Questao33.Boochy;

class Inner
{
	private int x;
	public void setX (int x){ this.x = x;}
	public int getX(){return x;}
}

public class Outer
{
	private Inner y;

	public void setY (Inner y)
	{
		this.y = y;
	}

	public Inner getY(){return y;}

	public static void main(String[] args)
	{
		
	}
}

