package Research;

public class Timer 
{
	final long startTime = System.currentTimeMillis();
	long elapsedTime;
	long elapsedSeconds;
	int finalscore;
	static int percent = 0;
	
	public static void CountStart(long startTime,long elapsedTime)
	{
		elapsedTime = System.currentTimeMillis() - startTime;
	}
	
	public static void CountTiming(long elapsedTime, long startTime, int finalscore)
	{
		int temp = 0;
		while (true)
		{
			if ((elapsedTime - startTime) % 60 == 0)
			{
				temp += 1;
			}
			percent = percent(temp, finalscore);
			if (finalscore == temp)
			{
				break;
			}
		}
	}
	
	static int percent(int temp, int finalscore)
	{
		return (temp/finalscore)*100;
	}

	@Override
	public String toString() 
	{
		return "Research: " + percent + " %";
	}
	
	
}
