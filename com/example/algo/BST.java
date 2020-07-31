package com.example.algo;

public class BST {

  Node root;

  public BST() {

    root = null;
  }

  class Node {

    int key;

    String value;

    Node left, right;

    public Node(int key, String value) {

      this.key = key;
      this.value = value;
    }

    public Node min() {

      if (left == null) {
        return this;
      } else {
        return left.min();
      }
    }
  }

  public String find(int key) {

    Node node = find(root, key);

    return node == null ? null : node.value;
  }

  private Node find(Node node, int key) {

    if (node == null || node.key == key) {
      return node;
    } else if (key < node.key) {
      return find(node.left, key);
    } else if (key > node.key) {
      return find(node.right, key);
    }
    return null;
  }

  public void insert(int key, String value) {

    root = insertItem(root, key, value);
  }

  public Node insertItem(Node node, int key, String value) {

    if (node == null) {
      node = new Node(key, value);
      ;
      return node;
    }

    if (key < node.key) {
      node.left = insertItem(node.left, key, value);
    }
    if (key > node.key) {
      node.right = insertItem(node.right, key, value);
    }

    return node;
  }

  public int findMinKey() {

    return findMin(root).key;
  }

  public Node findMin(Node node) {

    return node.min();
  }

  public void delete(int key) {

    root = delete(root, key);
  }

  public Node delete(Node node, int key) {

    if (node == null) {
      return null;
    } else if (key < node.key) {
      node.left = delete(node.left, key);
    } else if (key > node.key) {
      node.right = delete(node.right, key);
    } else {

      if (node.left == null && node.right == null) {
        node = null;
      } else if (node.left == null) {
        node = node.right;
      } else if (node.right == null) {
        node = node.left;
      } else {

        Node minRight = findMin(node.right);

        node.key = minRight.key;
        node.value = minRight.value;

        node.right = delete(node.right, node.key);
      }
    }

    return node;
  }
}
