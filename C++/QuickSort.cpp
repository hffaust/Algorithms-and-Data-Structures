
#include <iostream>
#include <ctime>
#include <cstdlib>
/*
 * In C, we would include:
 * <stdio.h>
 * <time.h>
 * <stdlib.h>
 */

/*
 * Worst-case performance: O(n^2)
 *
 * Best-case  performance: O(n log n) ---> simple partition
 *                                 or
 *                         O(n)       ---> three-way partition and equal keys
 *
 * Average Performance:    O(n log n)
 *
 * Worst-case (auxiliary)
 * space complexity:       O(n)       ---> naive
 *                         O(log n)   ---> Sedgewick 1978
 *
 * source: https://en.wikipedia.org/wiki/Quicksort
 */

/* ASCII QuickSort Diagram
 * Author: Hank Faust
 *
                                                             Pivot
                    +----+----+----+----+----+----+----+----XXXXXX
                    |    |    |    |    |    |    |    |    X    X
                    |  9 | -3 |  5 |  2 |  6 |  8 | -6 |  1 X  3 X
                    |    |    |    |    |    |    |    |    X    X
                    +----+----+----+----+--+-+----+----+----XXXXXX
                                           |
                         +-----------------+----------------+
                  <=3    |                                  |    >=3
                         V                                  V
              +----+----+----XXXXXX     XXXXXX    +----+----+----XXXXXX
              |    |    |    X    X     X    X    |    |    |    X    X
              | -3 |  2 | -6 X  1 X     X  3 X    |  8 |  5 |  9 X  6 X
              |    |    |    X    X     X    X    |    |    |    X    X
              +----+----+----XXXXXX     XXXXXX    +----+----+----XXXXXX
                        |                                   |
             +----------+----------+            +-----------+----------+
         <=1 |                     | >=1    <=6 |                      | >=6
             V                     V            V                      V
        +----XXXXXX     XXXXXX   +----+      +----+   XXXXXX      +----XXXXXX
        |    X    X     X    X   |    |      |    |   X    X      |    X    X
        | -3 X -6 X     X  1 X   |  2 |      |  5 |   X  6 X      |  9 X  8 X
        |    X    X     X    X   |    |      |    |   X    X      |    X    X
        +----XXXXXX     XXXXXX   +----+      +----+   XXXXXX      +----XXXXXX
             |                                                         |
      +------+------+                                           +------+------+
      |             | >= -6                                     |             | >=8
      V             V                                           V             V
   XXXXXX        +----+                                      XXXXXX        +----+
   X    X        |    |                                      X    X        |    |
   X -6 X        | -3 |                                      X  8 X        |  9 |
   X    X        |    |                                      X    X        |    |
   XXXXXX        +----+                                      XXXXXX        +----+

 *
 *
 */



// A utility function to swap two elements
void swap (int* a, int* b)
{
	int temp = *a;
	*a = *b;
	*b = temp;
}

int partition(int arr[], int low, int high)
{
	/*
	 * goal is to find the true position of the pivot
	 *
	 * 'i' remembers the last position that an element
	 * was place in, that was less than the pivot
	 *
	 * 'j' scans all items from right boundary to left boundary - 1 (inclusive)
	 * to see if the items are greater than (or equal to) or less than the pivot
	 */

	int pivot  = arr[high];
	int i = (low - 1); //index of smaller element
	int j; //index of element being scanned

	for(j = low; j <= high - 1; j++)
	{
		// if current element is smaller than or equal to pivot
		if(arr[j] <= pivot)
		{
			i++; //increment index of smaller element
			swap(&arr[i], &arr[j]);
		}
	}
	swap(&arr[i + 1], &arr[high]);
	return(i + 1);
}

void quickSort(int arr[], int low, int high)
{
	if(low < high)
	{
		/*
		 * p_i is partitioning index, equal to the pivot + 1,
		 * arr[pivot] is now at the right place
		 */
		int p_i = partition(arr, low, high);

		// Separately sort elements before
		// and after the partition index, p_i
		quickSort(arr, low, p_i - 1);
		quickSort(arr, p_i + 1, high);
	}
}

int main(int argc, char **argv)
{
	srand(time(NULL)); //seed generator for pseudo-random numbers
	int i;
	int size;
	std::cout << "Enter the number of elements: " <<std::endl;
	std::cin >> size;

	int arr[size];
	//int size = sizeof(arr) / sizeof(arr[0]); // use this if not using user input and instead hard-coding array size

	std::cout << "Un-Sorted Array:" << std::endl;
	// Loops to randomly fill the array
	for(i = 0; i < size; i++)
	{
		arr[i] = rand() % 100 + 1; //range from 1 to 100
		std::cout << arr[i] << " ";
	}

	quickSort(arr, 0, size - 1);

	std::cout << std::endl; // make a new line
	std::cout << "Sorted Array:" << std::endl;
	for(i = 0; i < size; i++)
	{
		std::cout << arr[i] << " ";
	}

	return 0;
}
