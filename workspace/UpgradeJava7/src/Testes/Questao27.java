package Testes;

class MyTask extends RecursiveTask<Integer> 
{
	final int low;
	final int high;

	static final int THRESHOLD; /* . . . */

			MyTask (int low, int high) 
			{ 
			this.low = low; this.high = high; 
		}
	
	Integer computeDirectly() /* . . . */

	protected void compute() {

		if (high – low <= THRESHOLD)
			return computeDirectly();
		
		int mid = (low + high) / 2;
		
		invokeAll(new MyTask(low, mid), new MyTask(mid, high));
	}
}