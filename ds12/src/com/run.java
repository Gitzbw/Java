package com;

public class run {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        binaryTree binaryTree = new binaryTree(node1);
        node1.left = node2;
        node1.right = node3;
        node3.right = node4;
//        binaryTree.preOrder();//1234
//        System.out.println("-------------------------");
//        binaryTree.infixOrder();//2134
//        System.out.println("-------------------------");
//        binaryTree.postOrder();//2431
        Node node = binaryTree.postOrderSearch(5);
        if(node != null)
        {
            System.out.println("找到了");
        }
        else
        {
            System.out.println("找不到");
        }
    }
}

@SuppressWarnings({"all"})
class binaryTree
{
    Node root;

    public binaryTree(Node root) {
        this.root = root;
    }

    public void preOrder()
    {
        if(root != null)
        {
            root.preOrder();
        }
        else
        {
            System.out.println("二叉树为空");
        }
    }

    public void infixOrder()
    {
        if(root != null)
        {
            root.infixOrder();
        }
        else
        {
            System.out.println("二叉树为空");
        }
    }

    public void postOrder()
    {
        if(root != null)
        {
            root.postOrder();
        }
        else
        {
            System.out.println("二叉树为空");
        }
    }

    public Node preOrderSearch(int data)
    {
        if(root != null)
        {
            return root.preOrderSearch(data);
        }
        else
        {
            return null;
        }
    }

    public Node infixOrderSearch(int data)
    {
        if(root != null)
        {
            return root.infixOrderSearch(data);
        }
        else
        {
            return null;
        }
    }

    public Node postOrderSearch(int data)
    {
        if(root != null)
        {
            return root.postOrderSearch(data);
        }
        else
        {
            return null;
        }
    }

}

@SuppressWarnings({"all"})
class Node
{
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }

    public void preOrder()
    {
        System.out.println(this.data);
        if(this.left != null)
        {
            this.left.preOrder();
        }
        if(this.right != null)
        {
            this.right.preOrder();
        }
    }

    public void infixOrder()
    {
        if(this.left != null)
        {
            this.left.infixOrder();
        }
        System.out.println(this.data);
        if(this.right != null)
        {
            this.right.infixOrder();
        }
    }

    public void postOrder()
    {
        if(this.left != null)
        {
            this.left.postOrder();
        }
        if(this.right != null)
        {
            this.right.postOrder();
        }
        System.out.println(this.data);
    }

    public Node preOrderSearch(int data)
    {
        if(this.data == data)
        {
            return this;
        }
        Node resNode = null;//该结点用来保存递归下一层的返回值
        if(this.left != null)
        {
            resNode = this.left.preOrderSearch(data);
        }
        if(resNode != null)
        {
            return resNode;
        }
        if(this.right != null)
        {
            resNode = this.right.preOrderSearch(data);
        }
        return resNode;//这里直接返回而不判断空 是因为已经全部找完了 如果是空 就代表没找到
    }

    public Node infixOrderSearch(int data)
    {
        Node resNode = null;//该结点用来保存递归下一层的返回值
        if(this.left != null)
        {
            resNode = this.left.infixOrderSearch(data);
        }
        if(resNode != null)
        {
            return resNode;
        }
        if(this.data == data)
        {
            return this;
        }
        if(this.right != null)
        {
            resNode = this.right.infixOrderSearch(data);
        }
        return resNode;//这里直接返回而不判断空 是因为已经全部找完了 如果是空 就代表没找到
    }

    public Node postOrderSearch(int data)
    {
        Node resNode = null;//该结点用来保存递归下一层的返回值
        if(this.left != null)
        {
            resNode = this.left.postOrderSearch(data);
        }
        if(resNode != null)
        {
            return resNode;
        }
        if(this.right != null)
        {
            resNode = this.right.postOrderSearch(data);
        }
        if(resNode != null)
        {
            return resNode;
        }
        if(this.data == data)
        {
            return this;
        }
        return resNode;//如果都找不到 就返回resNode(此时resNode为空)
    }
}


