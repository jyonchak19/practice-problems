package main.java.graphProblems;

import java.util.List;
import java.util.ArrayList;

class NaryNode {
    int value;
    List<NaryNode> children;

    public NaryNode(int value){
        this.value = value;
        this.children = new ArrayList<>();
    }

    public NaryNode(int value, List<NaryNode> children){
        this.value = value;
        this.children = children;
    }
}
