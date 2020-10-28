package lifegame;

import static org.junit.Assert.*;
import org.junit.Test;

import java.awt.List;
import java.util.LinkedList;

public class AlgorithmTest {

	@Test
	public void testCalnextGeneration() {
		int row=3;
		int column=3;
		int [][]generation=new int[row][column];
		generation[0][0]=1;
		generation[0][1]=1;
		generation[0][2]=1;
		generation[1][0]=1;
		generation[1][1]=1;
		generation[1][2]=0;
		generation[2][0]=1;
		generation[2][1]=1;
		generation[2][2]=0;
		
		int [][]generation1=Algorithm.calnextGeneration(generation, row, column);
		int [][]real_generation=new int[row][column];
		real_generation[0][0]=1;
		real_generation[0][1]=0;
		real_generation[0][2]=1;
		real_generation[1][0]=0;
		real_generation[1][1]=0;
		real_generation[1][2]=0;
		real_generation[2][0]=1;
		real_generation[2][1]=1;
		real_generation[2][2]=0;
		
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<column;j++)
			{
				assertEquals(real_generation[i][j],generation1[i][j]);
			}
		}
		
	}
	
	@Test
	public void testCalnextGeneration1() { 
		int row=3;
		int column=3;
		int [][]generation=new int[row][column];
		generation[0][0]=0;
		generation[0][1]=1;
		generation[0][2]=0;
		generation[1][0]=1;
		generation[1][1]=1;
		generation[1][2]=0;
		generation[2][0]=1;
		generation[2][1]=0;
		generation[2][2]=1;
		
		int [][]generation1=Algorithm.calnextGeneration(generation, row, column);
		int [][]real_generation=new int[row][column];
		real_generation[0][0]=1;
		real_generation[0][1]=1;
		real_generation[0][2]=0;
		real_generation[1][0]=1;
		real_generation[1][1]=0;
		real_generation[1][2]=1;
		real_generation[2][0]=1;
		real_generation[2][1]=0;
		real_generation[2][2]=0;
		
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<column;j++)
			{
				assertEquals(real_generation[i][j],generation1[i][j]);
			}
		}
	}

}
