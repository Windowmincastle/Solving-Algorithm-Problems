class Solution {
    
    public int[] solution(int brown, int yellow) {
        
        int Tiles = brown + yellow;
        for (int h = 3; h <= Tiles; h++){
            
            if ( Tiles % h == 0 ){
                
                int w = Tiles / h;
                
                if ((w-2) * (h-2) == yellow )  {
                    
                    return new int[]{w,h};
                    
                }
                
            }
            
        }

        return new int[0];
    
    }
}