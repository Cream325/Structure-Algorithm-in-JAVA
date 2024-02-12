import Algorithm.HashTable.Chaining.*;
import Algorithm.HashTable.OpenAddressing.OpenAddressingHashTable;
import Structure.Tree.BinaryTree.Heap.ArrayHeap;
import Algorithm.*;
import Structure.LinkedList.*;
import Structure.Stack.*;
import Structure.Queue.*;
import Structure.Queue.PriorityQueue.*;
import Structure.Deque.*;
import Structure.Tree.*;
import Structure.Tree.BinaryTree.*;
import Structure.Tree.BinaryTree.Heap.*;
import Structure.Tree.BinaryTree.BalancedTree.*;
import Structure.Graph.*;

public class Main {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(20);
        //LinkedListStack stack = new LinkedListStack();

        stack.PushAll(new Object[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});

        PrintTool.PrintObjects(stack.PopAll());
    }
}

/*
  [ To-Do later ]

    Hash Table - Open Addressing

    Trie
    B Tree
    B+ Tree

    DFS
    BFS
*/