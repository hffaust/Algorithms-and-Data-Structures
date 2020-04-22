/*
 * QuickSort.h
 *
 *  Created on: Apr 21, 2020
 *      Author: hfaust
 */
//#pragma once  // could use instead of ifndef, define, endif preprocessor commands
#ifndef QUICKSORT_H_
#define QUICKSORT_H_

void swap (int* a, int* b);

int partition(int arr[], int low, int high);

void quickSort(int arr[], int low, int high);

#endif /* QUICKSORT_H_ */
