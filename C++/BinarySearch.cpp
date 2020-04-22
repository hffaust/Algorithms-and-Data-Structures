#include "BinarySearch.h"
#include <iostream>
#include <ctime>
#include <cstdlib>

int binarySearch(int arr[], int left_index, int right_index, int find_me)
{
	while(left_index <= right_index)
	{
		int middle = left_index + (right_index - left_index) / 2;
		if(find_me == arr[middle])
		{
			return middle;
		}
		else if (find_me < arr[middle])
		{
			right_index = middle - 1;  // looks at right half of array
		}
		else
		{
			left_index = middle + 1;  // looks at left half of array
		}
	}
	return -1; // returns -1 if value was not found in the array
}



int main(int argc, char **argv)
{
	srand(time(NULL)); //seed generator for pseudo-random numbers
	int size;
	std::cout << "Enter the number of elements: " <<std::endl;
	std::cin >> size;
	int arr[size];

	int window_size = 5; // this is the number of ints that could be selected in each iteration of the init loop, also the difference in range between each loop
	int window_arr [window_size];
	int smallest_possible_num = 1; // this is the start number for 1st run of init loop
	//int largest_possible_num = size * window_size; // this number is size, aka number of loops, times the window size, aka the size of the range for each loop
	int start = smallest_possible_num;
	//int end = smallest_possible_num + window_size; // largest possible number in a given loop
	int rand_index, selected_value;
	int i, j;

	// this loop fills the array with random value (from designated window) while keeping them in order from smallest to largest...
	// having the values be in order is REQUIRED to perform a successful binary search
	for(i = 0; i < size; i++)
	{
		for(j = 0; j < window_size; j++)
		{
			// fill window array with possible values to be selected randomly
			window_arr[j] = start;
			//std::cout << window_arr[j] << std::endl;  // test print
			start++;
		}

		rand_index = rand() % window_size; //randomly pick an index
		//std::cout << "Rand index: " << rand_index << std::endl;  // test print
		selected_value = window_arr[rand_index];
		//std::cout << "Selected Val: " << selected_value << std::endl;  // test print
		arr[i] = selected_value;
	}

	std::cout << std::endl; // print a new line
	std::cout << "The array contains:" << std::endl;
	for(i = 0; i < size; i++)
	{
		std::cout << arr[i] << " ";
	}
	std::cout << std::endl; // print a new line

	std::cout << "Please select a value to locate: ";
	int find_me;
	std::cin >> find_me;

	int ret_value = binarySearch(arr, 0, size - 1, find_me);
	if(ret_value == -1)
	{
		std::cout << "The value you selected was not found in the array" << std::endl;
	}
	else
	{
		std::cout << find_me << " was found at index: " << ret_value << std::endl;
	}

	return 0;
}
