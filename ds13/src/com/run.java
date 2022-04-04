package com;

public class run {
    public static void main(String[] args) {
//        Node node1 = new Node(1);
//        Node node2 = new Node(2);
//        Node node3 = new Node(3);
//        Node node4 = new Node(4);
//        binaryTree binaryTree = new binaryTree(node1);
//        node1.left = node2;
//        node1.right = node3;
//        node3.right = node4;
        int[] arr = {1,2,3,4,5,6,7};
        arrBinaryTree arrBinaryTree = new arrBinaryTree(arr);
        arrBinaryTree.preOrder(0);


    }
}


@SuppressWarnings({"all"})

class threadedBinaryTree
{
    Node root;
    //为了实现线索化 我们需要一个指针指向当前结点的前驱结点
    Node pre;

    public threadedBinaryTree(Node root) {
        this.root = root;
    }

    //对二叉树的中序线索化
    public void infixThreadedNode(Node node)//这里传入的结点就是当前需要线索化的结点 一开始传入的是root结点
    {
        if(node == null)
        {
            return;
        }
        //1.索引化左子树
        infixThreadedNode(node.left);
        //2.索引化"当前"结点
        //2.1索引化当前结点的前驱(如果需要的话)
        if(node.left == null)
        {
            node.left = pre;
            node.setLeftType(1);
        }
        //2.2索引化上一个结点的后继(如果需要的话)
        if(pre != null && pre.right == null)
        {
            pre.right = node;
            pre.setRightType(1);
        }
        pre = node;//处理完一个结点后 把pre赋值为当前结点
        //3.索引化右子树
        infixThreadedNode(node.right);
    }

    public void remove(int data)
    {
        if(root != null)
        {
            if(root.data == data)
            {
                root = null;//只有根节点 相当于把二叉树置空
            }
            else
            {
                root.remove(data);
            }
        }
        else
        {
            System.out.println("二叉树为空");
        }
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

class arrBinaryTree
{
    int[] arr;

    public arrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder(int index)
    {
        if(arr == null && arr.length ==0)//这两个判断条件是不同的 前面是判断引用有没有指向数组 后者是判断数组是否为空
        {
            System.out.println("数组为空");
            return;
        }
        System.out.println(arr[index]);
        if(index*2 + 1 < arr.length)//防止索引越界
        {
            preOrder(index*2 + 1);
        }
        if(index*2 + 2 < arr.length)//防止索引越界
        {
            preOrder(index*2 + 2);
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

    public void remove(int data)
    {
        if(root != null)
        {
            if(root.data == data)
            {
                root = null;//只有根节点 相当于把二叉树置空
            }
            else
            {
                root.remove(data);
            }
        }
        else
        {
            System.out.println("二叉树为空");
        }
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
    //我们规定 leftType为0代表指向左子树 为1代表指向前驱结点 rightType为0代表指向右子树 为1代表指向后继结点
    int leftType;
    int rightType;

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public Node(int data) {
        this.data = data;
    }

    public void remove(int data)
    {
        if(this.left != null && this.left.data == data)
        {
            this.left = null;
            return;
        }
        if(this.right != null && this.right.data == data)
        {
            this.right =null;
            return;
        }
        if(this.left != null)
        {
            this.left.remove(data);
        }
        if(this.right != null)
        {
            this.right.remove(data);
        }
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
