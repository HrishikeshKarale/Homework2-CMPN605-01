/**
* Board.java
*
* @version   $Id: Board.java,v_1.0 2014/09/09 18:22:00
*
* @author    hhk9433 (Hrishikesh Karale)
* 
* Revisions:
*      Initial revision
*/


/*
 * This program places maximum number of queens on the given board
 * without them attacking each other.
 */

public class Board 
{
	static int duplicateQueenCount= 0;
	static int queenpos[][]= new int[8][2];
	static boolean check= false;

	private void display(int [][] boardDisplay)
	{
		
		for(int i=0; i<8; i++)
		{
			for (int j=0; j<8; j++)
			{
				if(boardDisplay[i][j]==1)
					System.out.print(" Q");
				else
					System.out.print(" -");
			}System.out.println();
		}
	}
	

	/*
	 * This method blocks the attacking position of the queen diagonally, vertically and horizontally,
	 *  also checks for walls present.
	 */
	public void block(int duplicateChessBoard[][], int row, int column)
	{
		int row2=row+1;
		while(row2<8)	//blocks vertically downwards
		{
			if(duplicateChessBoard[row2][column]!= 1 /*&& boardObject.isWall(row2-1, row2, column, column)==false*/)
				if(duplicateChessBoard[row2][column]== 0)
					duplicateChessBoard[row2++][column]= 2;
				else
					duplicateChessBoard[row2++][column]++;
		}
		
		row2=row-1;
		while(row2>=0)	//blocks vertically upwards
		{
			if(duplicateChessBoard[row2][column]!= 1 /*&& boardObject.isWall(row2+1, row2, column, column)==false*/)
				if(duplicateChessBoard[row2][column]== 0)
					duplicateChessBoard[row2--][column]= 2;
				else	
					duplicateChessBoard[row2--][column]++;
		}
		
		int column2=column+1;
		while(column2<8)	// blocks horizontally to the right
		{
			if(duplicateChessBoard[row][column2]!=1 /*&& boardObject.isWall(row, row, column2-1, column2)==false*/)
				if(duplicateChessBoard[row][column2]== 0)
					duplicateChessBoard[row][column2++]= 2;
				else
					duplicateChessBoard[row][column2++]++;
		}
		
		column2=column-1;
		while(column2>=0)	// blocks horizontally to the left
		{
			if(duplicateChessBoard[row][column2]!= 1 /*&& boardObject.isWall(row2, row2, column2+1, column2)==false*/)
				if(duplicateChessBoard[row][column2]== 0)
					duplicateChessBoard[row][column2--]= 2;
				else
					duplicateChessBoard[row][column2--]++;
		}
	
		row2=row-1;
		column2=column+1;
		while(row2>=0 && column2<8)	//blocks diagonally upwards right
		{
			if(duplicateChessBoard[row2][column2]!= 1 /*&& boardObject.isWall(row2+1, row2, column2-1, column2)==false*/)
				if(duplicateChessBoard[row2][column2]== 0)
					duplicateChessBoard[row2--][column2++]= 2;
				else
					duplicateChessBoard[row2--][column2++]++;
		}
		
		row2=row+1;
		column2=column-1;
		while(row2<8 && column2>=0)	//blocks diagonally downwards left
		{
			if(duplicateChessBoard[row2][column2]!= 1 /*&& boardObject.isWall(row2-1, row2, column+1, column)==false*/)
				if(duplicateChessBoard[row2][column2]== 0)
					duplicateChessBoard[row2++][column2--]= 2;
				else
					duplicateChessBoard[row2++][column2--]++;
		}
		
		row2=row-1;
		column2=column-1;
		while(row2>=0 && column2>=0)	// blocks diagonally upwards left
		{
			if(duplicateChessBoard[row2][column2]!= 1 /*&& boardObject.isWall(row+1, row, column2+1, column2)==false*/)
				if(duplicateChessBoard[row2][column2]== 0)
					duplicateChessBoard[row2--][column2--]= 2;
				else
					duplicateChessBoard[row2--][column2--]++;
		}
		
		row2=row+1;
		column2=column+1;
		while(row2<8 && column2<8)	//blocks diagonally downwards right
		{
			if(duplicateChessBoard[row2][column2]!= 1 /*&& boardObject.isWall(row2-1, row2, column2-1, column2)==false*/)
				if(duplicateChessBoard[row2][column2]== 0)
					duplicateChessBoard[row2++][column2++]= 2;
				else
					duplicateChessBoard[row2++][column2++]++;
		}
				
	}


	
	
	public void unBlock(int duplicateChessBoard[][], int row, int column)
	{
		int row2=row+1;
		while(row2<8)	//blocks vertically downwards
		{
			if(duplicateChessBoard[row2][column]== 2)
				duplicateChessBoard[row2++][column]= 0;
			else if(duplicateChessBoard[row2][column]!= 0)
				duplicateChessBoard[row2++][column]--;
			else if(duplicateChessBoard[row2][column]== 0)
				row2++;
		}
		
		row2=row-1;
		while(row2>=0)	//blocks vertically upwards
		{
			if(duplicateChessBoard[row2][column]== 2)
					duplicateChessBoard[row2--][column]= 0;
			else if(duplicateChessBoard[row2][column]!= 0)
				duplicateChessBoard[row2--][column]--;
			else if(duplicateChessBoard[row2][column]== 0)
				row2--;
		}
		
		int column2=column+1;
		while(column2<8)	// blocks horizontally to the right
		{
			if(duplicateChessBoard[row][column2]== 2)
				duplicateChessBoard[row][column2++]= 0;
			else if(duplicateChessBoard[row][column2]!= 0)
				duplicateChessBoard[row][column2++]--;
			else if(duplicateChessBoard[row][column2]== 0)
				column2++;
		}
		
		column2=column-1;
		while(column2>=0)	// blocks horizontally to the left
		{
			if(duplicateChessBoard[row][column2]== 2)
				duplicateChessBoard[row][column2--]= 0;
			else if(duplicateChessBoard[row][column2]!= 0)
				duplicateChessBoard[row][column2--]--;
			else if(duplicateChessBoard[row][column2]== 0)
				column2--;
		}
	
		row2=row-1;
		column2=column+1;
		while(row2>=0 && column2<8)	//blocks diagonally upwards right
		{
			if(duplicateChessBoard[row2][column2]== 2)
				duplicateChessBoard[row2--][column2++]= 0;
			else if(duplicateChessBoard[row2][column2]!= 0)
				duplicateChessBoard[row2--][column2++]--;
			else if(duplicateChessBoard[row2][column2]== 0)
			{
				row2--;
				column++;
			}
		}
		
		row2=row+1;
		column2=column-1;
		while(row2<8 && column2>=0)	//blocks diagonally downwards left
		{
			if(duplicateChessBoard[row2][column2]== 2)
				duplicateChessBoard[row2++][column2--]= 0;
			else if(duplicateChessBoard[row2][column2]!= 0)
				duplicateChessBoard[row2++][column2--]--;
			else if(duplicateChessBoard[row2][column2]== 0)
			{
				row2++;
				column--;
			}
		}
		
		row2=row-1;
		column2=column-1;
		while(row2>=0 && column2>=0)	// blocks diagonally upwards left
		{
			if(duplicateChessBoard[row2][column2]== 2)
				duplicateChessBoard[row2--][column2--]= 0;
			else if(duplicateChessBoard[row2][column2]!= 0)
				duplicateChessBoard[row2--][column2--]--;
			else if(duplicateChessBoard[row2][column2]== 0)
			{
				row2--;
				column--;
			}
		}
		
		row2=row+1;
		column2=column+1;
		while(row2<8 && column2<8)	//blocks diagonally downwards right
		{
			if(duplicateChessBoard[row2][column2]== 2)
				duplicateChessBoard[row2++][column2++]= 0;
			else if(duplicateChessBoard[row2][column2]!= 0)
				duplicateChessBoard[row2++][column2++]--;
			else if(duplicateChessBoard[row2][column2]== 0)
			{
				row2++;
				column++;
			}
		}
				
	}

	private void placeQueen(int duplicateChessBoard[][], int rows, int columns)
	{
		int row=rows;
		int column= columns;
		
		while( row<8)	//checks if no of rows are in bounds
		{
			while( column<8)
			{
				if(duplicateQueenCount==8)
				{
					System.out.println("\nNo Of Queens: "+duplicateQueenCount);
					display(duplicateChessBoard);
					System.exit(0);
				}
				
				// checks availability of vacancy for queen
				if(duplicateChessBoard[row][column]== 0)	
				{
					duplicateChessBoard[row][column]= 1;
					duplicateQueenCount++;
					
					queenpos[duplicateQueenCount-1][0] = row;
					queenpos[duplicateQueenCount-1][1] = column;
					
					block(duplicateChessBoard/*tempChessBoard*/, row, column);
					
					
					if(++column>=9)	// checks no of columns don't exceed their bounds
					{
						if(queenpos[duplicateQueenCount-1][0]==row++)
							placeQueen(duplicateChessBoard/*tempChessBoard*/, row, 0);	//recursive method call
						else
						{
							check=true;
							duplicateQueenCount--;
							duplicateChessBoard[queenpos[duplicateQueenCount][0]][queenpos[duplicateQueenCount][1]]= 0;
							unBlock(duplicateChessBoard, queenpos[duplicateQueenCount][0], queenpos[duplicateQueenCount][1]);
							return;
						}	
					}

				
					placeQueen(duplicateChessBoard/*tempChessBoard*/, ++row,0);

					if(check)
					{ 
							check=false;
							duplicateChessBoard[queenpos[duplicateQueenCount][0]][queenpos[duplicateQueenCount][1]]= 0;
							unBlock(duplicateChessBoard, queenpos[duplicateQueenCount][0], queenpos[duplicateQueenCount][1]);
							placeQueen(duplicateChessBoard, queenpos[duplicateQueenCount][0], ++queenpos[duplicateQueenCount-1][1]);
					}
				}
				else
				{
					placeQueen(duplicateChessBoard/*tempChessBoard*/,row,++column);
					
					if(check)
					{ 
							check=false;
							duplicateChessBoard[queenpos[duplicateQueenCount][0]][queenpos[duplicateQueenCount][1]]= 0;
							unBlock(duplicateChessBoard, queenpos[duplicateQueenCount][0], queenpos[duplicateQueenCount][1]);
							placeQueen(duplicateChessBoard, queenpos[duplicateQueenCount][0], ++queenpos[duplicateQueenCount][1]);
					}
				}
			}

			if(queenpos[duplicateQueenCount-1][0]==row++)
				placeQueen(duplicateChessBoard/*tempChessBoard*/, row, 0);	//recursive method call
			else
			{
				if(check)
				{ 
						check=false;
						duplicateChessBoard[queenpos[duplicateQueenCount][0]][queenpos[duplicateQueenCount][1]]= 0;
						unBlock(duplicateChessBoard, queenpos[duplicateQueenCount][0], queenpos[duplicateQueenCount][1]);
						placeQueen(duplicateChessBoard, queenpos[duplicateQueenCount][0], ++queenpos[duplicateQueenCount][1]);
				}
				check=true;
				duplicateQueenCount--;
				return;
			}
		}		
	}
	

	public static void main(String[] args)
	{
		//chessboard matrix declaration. 
		int [][] chessBoard = new int [8][8];	
		//board object initialized
		Board boardObject = new Board();	
		
		//Initializes chessBoard to defaults
		for(int row=0; row<8; row++)	
		{
			for (int column=0; column<8; column++)
			{
				chessBoard[row][column]= 0;
			}
			queenpos[row][0]= 0;
			queenpos[row][1]= 0;
		}
		
		/*
		 * calls placeQueen() for every possible position of queen on board
		 * compares the dublicateChessBoard and chessBoard and stores the best 
		 * board positions on chessBoard 
		 */
		boardObject.placeQueen(chessBoard, 0,0);
	}
}