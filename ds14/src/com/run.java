package com;

import java.util.Arrays;

@SuppressWarnings({"all"})
public class run {
    public static void main(String[] args) {
        int[] arr = {4,6,8,5,9};
        System.out.println(Arrays.toString(arr));
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr)
    {
        for(int i = arr.length/2 -1 ;i >= 0;i--)//该循环用于把数组转换成一个大顶堆 按从左到右从下到上的顺序传入的非叶子结点满足i/2-1
        {
            adjustHeap(arr,i,arr.length);
        }
        for (int j = arr.length-1; j > 0; j--) {//该循环用于交替执行 交换调整操作 完成数组升序排序
            int temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            //以上三行代码完成交换 原理是大顶堆第一个元素最大 交换到无序的最后一个索引处
            //交换完之后不一定是一个大顶堆了 我们需要继续调整 使其仍是一个大顶堆 但即使不是一个大顶堆 也只有根节点是错误的 只需传入根节点即可
            adjustHeap(arr,0,j);
        }
    }

    //i代表非叶子结点的索引 length表示对数组中多少个元素进行调整 该方法用于将数组(树的顺序存储结构)中传入的非叶子结点的局部结构调整成大顶堆
    public static void adjustHeap(int[] arr,int i,int length)//传入非叶子结点的顺序是 从左到右 从下到上
    {
        int temp = arr[i];//定义临时变量 保存非叶子结点的元素
        for (int k = 2*i+1 ; k < length; k = k*2+1 ) {
            //第一次循环是找左右子结点 看是否需要和传入的非叶子结点交换
            //如果不需要交换 直接break
            //如果需要交换 因为交换 改变了子结点的数值 因此需要继续循环来调整子树 使其仍是大顶堆
            if(k+1 < length && arr[k] < arr[k+1])//比较左右子结点大小 找到较大的 如果k+1 >= length 不需要比较
            {
                k++;
            }
            if(arr[i] < arr[k])//如果传入的非叶子结点的比左右子结点中较大的小 则交换
            {
                arr[i] = arr[k];
                i = k;//把i赋值给k
            }
            else
            {
                break;
                //这里可以直接退出循环 原因如下:
                // 情况一:传入的是第一个非叶子结点 无需调整 自然可以退出
                // 情况二:传入的不是第一个非叶子结点 但其子结点在之前就已完成调整 故可以直接退出
            }
            arr[i] = temp;
        }
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

    public void infixThreadedNode()
    {
        infixThreadedNode(root);
    }

    //遍历中序线索化二叉树
    public void infixThreadedList()
    {
        Node node = root;//定义一个辅助结点
        while(node != null)//循环终止条件 因为在中序线索化二叉树中 最后一个结点的right为空 即遍历完最后一个结点 循环就会终止
        {
            while(node.leftType == 0)//为0代表左子树 不需要输出
            {
                node = node.left;
            }
            System.out.println(node.data);//为1代表前驱 即找到了叶子结点 输出
            while(node.rightType == 1)//为1代表后继 把后继赋值给node并输出
            {
                node = node.right;
                System.out.println(node.data);
            }
            node = node.right;//把node的右子树赋给node
        }
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
        if(pre != null && pre.right == null)//pre != null 这个判断条件针对的是第一次线索化 此时pre为null
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

    public void preOrder()
    {
        preOrder(0);
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
