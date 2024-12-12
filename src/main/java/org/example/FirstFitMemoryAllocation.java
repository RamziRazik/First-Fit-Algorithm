package org.example;

import java.util.Scanner;

public class FirstFitMemoryAllocation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Number of memory blocks and their capacities
        // Input number of blocks
        System.out.print("Enter the number of memory blocks: ");
        int numBlocks = scanner.nextInt();
        int[] blockSizes = new int[numBlocks];
        boolean[] blockAllocated = new boolean[numBlocks];

        // Input block capacities
        System.out.println("Enter the capacities of each block:");
        for (int i = 0; i < numBlocks; i++) {
            System.out.print("Block " + (i + 1) + " size: ");
            blockSizes[i] = scanner.nextInt();
            blockAllocated[i] = false; // Initially, all blocks are free
        }

        // Input: Number of processes and their sizes
        // Input number of processes
        System.out.print("\nEnter the number of processes: ");
        int numProcesses = scanner.nextInt();
        int[] processSizes = new int[numProcesses];

        // Input process sizes
        System.out.println("Enter the sizes of each process:");
        for (int i = 0; i < numProcesses; i++) {
            System.out.print("Process " + (i + 1) + " size: ");
            processSizes[i] = scanner.nextInt();
        }

        // Perform First Fit allocation and output the results
        System.out.println("\nFirst Fit Memory Allocation Results: ");
        for (int i = 0; i < numProcesses; i++) {
            boolean allocated = false;
            for (int j = 0; j < numBlocks; j++) {
                if (!blockAllocated[j] && blockSizes[j] >= processSizes[i]) {
                    blockAllocated[j] = true;
                    System.out.println("Process " + (i + 1) + " of size " + processSizes[i] + " allocated to block " + (j + 1));
                    allocated = true;
                    break;
                }
            }
            if (!allocated) {
                System.out.println("Process " + (i + 1) + " of size " + processSizes[i] + " could not be allocated.");
            }
        }

        // Display block allocation status
        System.out.println("\nBlock Allocation Status:");
        for (int i = 0; i < numBlocks; i++) {
            String status = blockAllocated[i] ? "Allocated" : "Free";
            System.out.println("Block " + (i + 1) + " is " + status + " (Capacity: " + blockSizes[i] + ")");
        }

        scanner.close();
    }
}
