package com.elizwy.leetcode;

import java.util.*;

public class L0326 {
    private static class Node {
        List<Node> preNode;
        String value;
        Node nextNode;

        public Node(String value, Node nextNode) {
            this.value = value;
            this.nextNode = nextNode;
        }

        public void addPreNode(Node node) {
            preNode.add(node);
        }
    }

    public static void main(String[] args) {
        final Node node1 = new Node("6", null);
        final Node node2 = new Node("3", node1);
        final Node node3 = new Node("1", node2);
        final Node node4 = new Node("5", node3);
        final Node node5 = new Node("4", null);
        final Node node6 = new Node("2", node5);

        Set<Node> tail = findTail(List.of(node1, node2, node3, node4, node5, node6));
        //todo 循环引用
        int count = 0;
        List<Node> sortNode;
        tail.stream().filter(r -> checkRound(r)).findAny().get();

    }

    private static boolean checkRound(Node tail) {
        Node firstNode = tail;
        if (tail.preNode == null) {
            return false;
        } else if (tail.preNode.size() == 1) {
            if(tail.preNode.get(0) == firstNode){
                return true;
            }
//            checkRound(tail,tail.preNode.get(0));
        }
        return true;
    }

    private static Set<Node> findTail(List<Node> nodes) {
        Set<Node> roots = new HashSet<>();
        Set<Node> tails = new HashSet<>();
        for (Node node : nodes) {
            if (node.nextNode != null) {
                node.nextNode.addPreNode(node);
                roots.remove(node.nextNode);
                tails.remove(node);
            } else {
                tails.add(node);
            }

            if (node.preNode == null) {
                roots.add(node);
            }
        }
        return tails;
    }


}
