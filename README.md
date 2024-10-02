# DataStructures-Assignment1-RajuKhatri
Name and Student Id : Raju Khatri C0910190

1. Artifact Vault Challenge (20 points)
Challenge: Create an ArtifactVault class to store and manage a collection of artifacts. Implement methods to:
Add artifacts (sorted by age).
Remove artifacts by name.
Search artifacts using linear and binary search.
Display all artifacts.

Approach:
a. Data Structure:
A fixed-size array (artifacts[]) holds the collection of artifacts.
Each artifact is represented by the Artifact class, which implements the Comparable interface to enable sorting by artifact age.
The vault automatically sorts artifacts by age after every addition or removal.

b.Adding Artifacts:
The addArtifact method inserts artifacts into the first available slot and keeps the collection sorted by age. If the vault is full, the method returns false.

c.Removing Artifacts:
The removeArtifact method searches for an artifact by name and replaces it with the last artifact in the array. It then reduces the array size and re-sorts the vault.

d.Searching:
Linear search is used to find an artifact by name in the collection without assuming the order of the array.
Binary search is applied to efficiently find an artifact by name in the sorted array. It has a time complexity of O(log n), leveraging the sorted nature of the array.

e.Displaying Artifacts:
The displayArtifacts method iterates through the array and prints the details of each artifact.

Assumptions:
The vault has a fixed size, which is determined at initialization.
Artifacts have unique names.
Artifacts are added in a sorted manner based on their age to enable binary search.


2. The Linked List Labyrinth (20 points)
Challenge: Implement a singly linked list that models a labyrinth path with methods to add a new location, remove the last location, check for loops, and print the path.
Approach:
-> I used a basic singly linked list structure where each node contains a location and a pointer to the next node.
-> For adding a location, I inserted nodes at the end of the list.
-> For removing the last location, I traversed the list to update the tail reference.
-> To detect loops, I implemented Floyd’s cycle detection algorithm (using slow and fast pointers).
-> The print method simply traverses the list and prints each location in sequence.

Assumptions: The list is a singly linked list where locations are represented as strings.

3. The Scroll Stack (20 points)
Challenge: Implement a stack to manage ancient scrolls with operations to push, pop, peek, and check if a scroll is in the stack.
Approach:
-> Used Java’s built-in Stack class for easy management of scrolls.
-> Implemented push, pop, and peek methods using standard stack operations.
-> The contains method checks if a scroll is already in the stack using the contains function.
   Assumptions: The stack size is dynamic, and scrolls are stored as strings.

4. The Queue of Explorers (20 points)
Challenge: Implement a circular queue to manage explorers in line with methods for enqueue, dequeue, peek, and checks for full/empty queue.
Approach:
-> Used an array to represent the circular queue.
-> Managed the circular behavior by updating the front and rear indices using modulo arithmetic.
-> Implemented methods for enqueue, dequeue, peek, and checking if the queue is full or empty based on the number of explorers currently in the queue.
-> Assumptions: The queue has a fixed size, and explorers are stored as strings.

5. The Binary Tree of Clues (20 points)
Challenge: Implement a binary tree to manage clues with methods to insert, traverse (in-order, pre-order, post-order), find a clue, and count the number of clues.
Approach:
-> Built a binary tree where each node contains a clue string and pointers to left and right children.
-> Insertions were done recursively, maintaining alphabetical order.
-> For tree traversals, I implemented in-order, pre-order, and post-order traversal methods.
-> The find method uses a recursive search to locate a specific clue.
-> The count method recursively counts all nodes in the tree.
Assumptions: Clues are inserted alphabetically, and all clues are unique.

Design Decisions:
Data Structures: Chose a array, singly linked list, stack, circular queue, and binary tree based on the specific operations required by each challenge.
Efficiency: Ensured that all operations (insertion, traversal, searching, etc.) were implemented with optimal time complexity.
Modularity: Organized each feature into separate methods to improve clarity and reusability.


Instructions on How to Run the Code:
Requirements: Java Development Kit (JDK) installed on your machine.

Steps:
1. Create a .java file for each class (e.g., LabyrinthPath.java, ScrollStack.java, ExplorerQueue.java, ClueTree.java).
2. Copy the code for each challenge into its respective .java file.
3. Open a terminal or command prompt and navigate to the directory containing the .java files.
4. Compile each file using:
javac <filename>.java
Example:
javac LabyrinthPath.java
5. Run the compiled class using:
java <filename>
Example:
java LabyrinthPath
This will execute the program and display the output for each challenge based on the sample code provided in the main() method of each class.
