package Structure.Tree;

import Structure.Node;

public class DisjointSet extends Node {
    Object data;
    DisjointSet parentNode;

    public DisjointSet(Object data) {
        this.data = data;
    }

    

    /** *분리 집합 - 합집합 연산 */
    public void UnionSet(DisjointSet set) {
        DisjointSet tempSet = this;

        tempSet = tempSet.SearchSet();
        tempSet.parentNode = set;
    }


    
    /** *분리 집합 - 탐색 연산 */
    public DisjointSet SearchSet() {
        DisjointSet tempSet = this;

        while(tempSet.parentNode != null) tempSet = tempSet.parentNode;
        return tempSet;
    }
}
