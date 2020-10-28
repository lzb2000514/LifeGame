package lifegame;

public class Algorithm {
	static int [][] calnextGeneration(int [][] nowGenaration,int row,int column)
	{
		int [][]nextGenaration=new int[100][100];
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<column;j++)
			{
				int sum;//该细胞周围的活细胞数量
				//边角点
				if(i==0&&j==0)
				{
					sum=nowGenaration[1][0]+nowGenaration[0][1]+nowGenaration[1][1];
				}
				else if(i==0&&j==column-1)
				{
					sum=nowGenaration[0][column-2]+nowGenaration[1][column-1]+nowGenaration[1][column-2];
				}
				else if(i==row-1&&j==0)
				{
					sum=nowGenaration[row-2][0]+nowGenaration[row-2][1]+nowGenaration[row-1][1];
				}
				else if(i==row-1&&j==column-1)
				{
					sum=nowGenaration[row-1][column-2]+nowGenaration[row-2][column-2]+nowGenaration[row-2][column-1];
				}
				//边界边
				else if(i==0)
				{
					sum=nowGenaration[0][j+1]+nowGenaration[0][j-1]+nowGenaration[1][j]+
							nowGenaration[1][j+1]+nowGenaration[1][j-1];
				}
				else if(i==row-1)
				{
					sum=nowGenaration[row-1][j+1]+nowGenaration[row-1][j-1]+nowGenaration[row-2][j]+
							nowGenaration[row-2][j+1]+nowGenaration[row-2][j-1];
				}
				else if(j==0)
				{
					sum=nowGenaration[i-1][0]+nowGenaration[i+1][0]+nowGenaration[i-1][1]+
							nowGenaration[i][1]+nowGenaration[i+1][1];
				}
				else if(j==column-1)
				{
					sum=nowGenaration[i-1][column-1]+nowGenaration[i+1][column-1]+nowGenaration[i-1][column-2]+
							nowGenaration[i][column-2]+nowGenaration[i+1][column-2];
				}
				//普通情况
				else
				{
					sum=nowGenaration[i-1][j-1]+nowGenaration[i-1][j]+nowGenaration[i-1][j+1]+
							nowGenaration[i][j-1]+nowGenaration[i][j+1]+nowGenaration[i+1][j-1]+
							nowGenaration[i+1][j]+nowGenaration[i+1][j+1];
				}
				//下一代细胞状态
				if(sum==3)
				{
					nextGenaration[i][j]=1;//生存
				}
				else if(sum==2)
				{
					nextGenaration[i][j]=nowGenaration[i][j];//状态不变
				}
				else
				{
					nextGenaration[i][j]=0;//死亡
				}
			}
		}
		return nextGenaration;
	}
}
