package fr.tpt.aadl.ramses.util.math;

public class LeastCommonMultiple {

	public static long lcm(long a, long b)
	{
	    return a * (b / GreatestCommonDivisor.gcd(a, b));
	}

	public static long lcm(Long[] input)
	{
	    long result = input[0];
	    for(int i = 1; i < input.length; i++) result = lcm(result, input[i]);
	    return result;
	}

}
