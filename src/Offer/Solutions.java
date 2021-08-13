package Offer;

public class Solutions {

    // 本质上和二分查找类似
    // 这里选取右上角作为起点

    public boolean findNum(int[][] matrix,int rows,int cols,int num)
    {
        boolean found = false;
        if(matrix != null && rows > 0 && cols >0)
        {
            int row = 0;
            int column = cols -1;
            while(row < rows && column >= 0)
            {
                if(matrix[row][column] == num)
                {
                    found = true;
                    break;
                }
                else if(matrix[row][column] > num)
                    --column;
                else
                    ++row;
            }
        }
        return found;
    }
}
