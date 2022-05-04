package may;

// 733. Flood Fill
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        
        dfs(image, sr, sc, color, newColor);
        
    	return image;
    }
    
    public void dfs(int[][] image, int r, int c, int color, int newColor) {
    	
    	// Do not fill color if: index of row or column is smaller than 0 OR 
    	// greater than or equal to length of row or column
    	// Do not fill if the original color of the current pixel is different 
    	// from original color of starting pixel
    	if (r < 0 || c < 0 || r >= image.length || c >= image[0].length || image[r][c] != color) {
    		return;
    	}
    	
    	// If current pixel already has new color, do nothing
    	if (image[r][c] == newColor)
    		return;
    	
    	// Change current pixel's color to new color
    	image[r][c] = newColor;
    	
    	// Continue to neighboring cells
    	dfs(image, r-1, c, color, newColor);
    	dfs(image, r+1, c, color, newColor);
    	dfs(image, r, c-1, color, newColor);
    	dfs(image, r, c+1, color, newColor);
    	
    }
}
