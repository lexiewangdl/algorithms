package july;

public class PowXN {
	
    public double getPow(double x, long n) {
    	if (n == 1)
    		return x;
    	
    	double num = getPow(x, n/2);
    	
    	return n % 2 == 0 ? num * num : num * num * x;
    }
	
    public double myPow(double x, int n) {
    	
    	if (x == 0)
    		return 0;
    	else if (n == 0 || x == 1)
    		return 1.0;
    	
    	long N = n;
    	
    	// A negative exponent is the multiplicative inverse of the base,
    	// raised to the power which is opposite to the given power
    	if (n < 0)
    		return 1.0 / getPow(x, -N);

    	return getPow(x, N);
    }

    

}
