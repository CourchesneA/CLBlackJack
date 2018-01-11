

/*
 * 		COMP202 section 1
 * 		Assignment 3 question 1
 * 		Anthony Courchesne
 * 		McGill ID: 260688650
 * 		Last Edited:  November 10 2015
 */

public class Sudoku {

	public static void main(String[] args){
		
	}
	public static boolean isSudoku(int[][] s){
		if(!isValidArray(s)){		//array is not 9X9
			//System.out.println("Is not 9X9");
			return false;
		}
		if(!isValidInput(s)){			//array contain number lower than 1 or higher than 9
			//System.out.println("invalid numbers");
			return false;
		}
		//check each row
		for (int i=0;i<9;i++){
			if(!isValidElement(sort(s[i]))){
				//System.out.println("incorrect row nb: " +i);
				return false;
			}
		}
		//check each column
		for (int i=0;i<9;i++){
			if(!isValidElement(sort(getColumn(s,i)))){
				//System.out.println("incorrect column nb: "+ i);
				return false;
			}
		}
		//check for each square
		for (int i=0;i<9;i+=3){
			for (int j=0;j<9;j+=3){
				if(!isValidElement(sort(flatten(subGrid(s, i, j, 3))))){
					//System.out.println("invalid square : "+ i+",2"+j);
					return false;
				}
			}
		}
		return true;
		
	}
	
	public static int[] sort(int[] inpArray){
		//To make sure this method is as general as possible, I use the swap technique:
		//I scan the array from index i and  swap the lower value with array[i], then i++
		int[] sortedArray=new int[inpArray.length];
		for(int i=0;i<inpArray.length;i++){		//copy array into a new so we don't change value of input array
			sortedArray[i]=inpArray[i];
		}
		int last=0;
		int lastIndex=0;
		int temp=0;
		
		for(int i=0;i<sortedArray.length;i++){
			//last=sortedArray[i];
			//lastIndex=i;
			for(int j=i;j<sortedArray.length;j++){
				//this loop find the lowest of remaining and store its value and its index
				if(j==i){
					last=sortedArray[j];
					lastIndex=j;
				}
				if(sortedArray[j]<last){
					last=sortedArray[j];
					lastIndex=j;
				}
			}
			//swap inst with lowest of remaining
			temp=sortedArray[i];
			sortedArray[i]=sortedArray[lastIndex];
			sortedArray[lastIndex]=temp;
		}
		
		return sortedArray;
		
	}

	public static boolean uniqueEntries(int[] inputArray){
		int inst=0;
		
		for(int i=0;i<inputArray.length;i++){
			inst=inputArray[i];				//At i=0, check if any value equal input[0]
			for(int j=i+1;j<inputArray.length;j++){
				if(inst==inputArray[j]){
					return false;
				}
			}
		}
		return true;
	}

	public static int[] getColumn(int[][] inputArray, int j){
		int[] column=new int[inputArray.length];
		for(int i=0;i<column.length;i++){
			column[i]=inputArray[i][j];
		}
		return column;
	}
	
	public static int[] flatten(int[][] inputArray){
		int[] flatArray=new int[inputArray.length*inputArray[0].length];
		for(int i=0;i<inputArray.length;i++){
			for (int j=0;j<inputArray[0].length;j++){
				flatArray[3*i+j]=inputArray[i][j];
			}
		}
		return flatArray;
	}
	
	public static int[][] subGrid(int[][] inputArray,int i, int j, int m){
		int[][] subArray=new int[m][m];
		for (int k=0;k<m;k++){
			for (int l=0;l<m;l++){
				subArray[k][l]=inputArray[i+k][j+l];
			}
		}
		return subArray;
	}
	
	//following methods are additional helpers that were not asked
	public static boolean isValidArray(int[][] inputArray){
		//check if input array is square
		if(inputArray.length!=9){
			//System.out.println("Array is not 9X9 so it's not a Sudoku");		//Additional information, commented out because assignement doesnt ask for it
			return false;
		}
		for(int i=0;i<inputArray.length;i++){
			if(inputArray[i].length!=inputArray.length){
				//System.out.println("Array is not square so it is not a Sudoku"+i);	//Additional information, commented out because assignement doesnt ask for it
				return false;
			}
		}
		return true;
	}
	
	public static boolean isValidInput(int[][] inputArray){
		//check if input contains numbers between 0 and 10
		for(int i=0;i<inputArray.length;i++){
			for (int j=0;j<inputArray[0].length;j++){
				if(inputArray[i][j]<1 || inputArray[i][j]>9){
					//System.out.println("Array do not contains number from 1 to 9 so it is not a Sudoku");	//Additional information, commented out because assignement doesnt ask for it
					return false;
				}
			}
		}
		return true;
	}

	public static boolean isValidElement(int[] inputArray){
		//this method compare input array to array {1,2,3,4,5,6,7,8,9}
		for(int i=0;i<9;i++){
			if(inputArray[i]!=i+1){
				return false;
			}
		}
		return true;
	}
	
}
