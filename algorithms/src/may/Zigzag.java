package may;

// 6. Zigzag conversion

public class Zigzag {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        
        char[][] zz = new char[numRows][s.length()];
        
        int mid = numRows - 2;
        
        int row = 0;
        int column = 0;
        int row_zz = 1;
        int c = 1;
        
        for (int i = 1; i <= s.length(); i++) {
        	if (c == numRows + mid + 1) {
        		c = 1;
        		column++;
        	}
        	
        	if (c > numRows && c < (numRows + mid + 1)) {
        		zz[row_zz][column] = s.charAt(i);
        		if (row_zz + 1 == numRows - 1)
        			row_zz = mid;
        		else row_zz++;
        		column++;
        	}
        	
        	zz[row][column] = s.charAt(i);
        	row++;
        	
        	if (row == numRows - 1)
        		row = 0;
        }
        
        return " ";
        
    }
}
