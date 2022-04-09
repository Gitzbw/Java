package com;

@SuppressWarnings({"all"})

public class run {
    public static void main(String[] args) {
//        int[] arr = {7,3,10,12,5,1,9,2};
//        binarySortTree binarySortTree = new binarySortTree();
//        for(int i =0;i<arr.length;i++)
//        {
//            binarySortTree.add(new Node(arr[i]));
//        }
//        binarySortTree.infixOrder();
//        System.out.println("---------------------");
//        binarySortTree.remove(7);
//        binarySortTree.infixOrder();
        //int[] arr = {4,3,6,5,7,8};
        int[] arr = {10,11,7,6,8,9};
        AVLTree avlTree = new AVLTree();
        for(int i =0;i<arr.length;i++)
        {
            avlTree.add(new Node(arr[i]));
        }
        System.out.println(avlTree.root.height());
        System.out.println(avlTree.root.leftHeight());
        System.out.println(avlTree.root.rightHeight());
    }
}



@SuppressWarnings({"all"})

class AVLTree
{
    Node root;

    public void remove(int value)
    {
        if(root == null)
        {
            return;
        }
        Node targetNode = search(value);
        if(targetNode == null)
        {
            return;
        }
        if(root.left == null && root.right == null)//只有根节点的情况 也是处理根节点为叶子结点 其父结点为null的情况
        {
            root = null;
            return;
        }
        Node ParentNode = searchParent(value);
        if(targetNode.left == null && targetNode.right == null)//叶子结点的情况
        {
            if(ParentNode.value > targetNode.value)
            {
                ParentNode.left = null;
            }
            else
            {
                ParentNode.right = null;
            }
        }
        //先写删除有两颗子树的情况(条件好写) 只有一颗子树的情况就是最后的else
        else if(targetNode.left != null && targetNode.right != null)
        {
            int min = removeRightMin(targetNode.right);
            targetNode.value = min;
        }
        else//剩下的就是只有一颗子树的情况
        {
            if(ParentNode == null)//处理要删除的是根节点(则根节点的父结点为null) 并且根节点只有左子树或者是右子树
            {
                if(ParentNode.left != null)//有左子树
                {
                    root = ParentNode.left;
                }
                else//有右子树
                {
                    root = ParentNode.right;
                }
            }
            else//处理的不是根节点
            {
                if(targetNode.left != null)//删除结点是目标结点的左子树的一个结点
                {
                    if(ParentNode.left != null && ParentNode.left.value == targetNode.value)//目标结点其父结点的左子结点
                    {
                        ParentNode.left = targetNode.left;
                    }
                    else//目标结点其父结点的右子结点
                    {
                        ParentNode.right = targetNode.left;
                    }
                }
                else//删除结点是目标结点的右子树的一个结点
                {
                    if(ParentNode.left != null && ParentNode.left.value == targetNode.value)//目标结点其父结点的左子结点
                    {
                        ParentNode.left = targetNode.right;
                    }
                    else//目标结点其父结点的右子结点
                    {
                        ParentNode.right = targetNode.right;
                    }
                }
            }
        }
    }

    public int removeRightMin(Node node)//传入的结点是待删除结点的右子结点 该方法用于删除该右子结点所在树的最小结点并且返回被删除结点的value
    {
        if(node.left != null)
        {
            return removeRightMin(node.left);
        }
        else
        {
            int value = node.value;//保留最小值
            remove(node.value);//删除该结点(叶子结点)
            return value;
        }
    }

    public Node search(int value)
    {
        if(root == null)
        {
            return null;
        }
        else
        {
            return root.search(value);
        }
    }

    public Node searchParent(int value)
    {
        if(root == null)
        {
            return null;
        }
        else
        {
            return root.searchParent(value);
        }
    }

    public void add(Node node)
    {
        if(root == null)
        {
            root = node;
        }
        else
        {
            root.add(node);
        }
    }

    public void infixOrder()
    {
        if(root == null)
        {
            System.out.println("二叉排序树为空");
        }
        else
        {
            root.infixOrder();
        }
    }
}



@SuppressWarnings({"all"})

class Node
{
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    public void rightRotate()//右旋
    {
        Node newNode = new Node(this.value);
        newNode.right = this.right;
        newNode.left = this.left.right;
        this.value = this.left.value;
        this.left = this.left.left;
        this.right = newNode;
    }

    public void leftRotate()//左旋
    {
        Node newNode = new Node(this.value);//步骤1 以当前结点的值创建新结点
        newNode.left = this.left;//步骤2 把当前结点的左子结点赋给新结点的左子结点
        newNode.right = this.right.left;//步骤3 把当前结点的右子结点的右子结点赋给新结点的右子结点
        this.value = this.right.value;//步骤4 把当前结点的右子结点的值赋给当前结点
        this.right = this.right.right;//步骤5 把当前结点的右子结点的右子结点赋给当前结点的右子结点
        this.left = newNode;//步骤6 把新结点赋给当前结点的左子结点

    }

    public int leftHeight()//返回左子树的高度
    {
        if(left == null)
        {
            return 0;
        }
        else
        {
            return left.height();
        }
    }

    public int rightHeight()//返回右子树的高度
    {
        if(right == null)
        {
            return 0;
        }
        else
        {
            return right.height();
        }
    }

    public int height()//该方法用于返回以当前结点为根节点的树的高度
    {
        return Math.max(left == null ? 0 : left.height(),right == null ? 0 : right.height()) + 1;
    }

    public Node search(int value)//该方法用于查找目标结点
    {
        if(this.value == value)
        {
            return this;
        }
        else if(this.value > value)
        {
            if(this.left == null)
            {
                return null;
            }
            return this.left.search(value);
        }
        else
        {
            if(this.right == null)
            {
                return null;
            }
            return this.right.search(value);
        }
    }

    public Node searchParent(int value)//该方法用于查找目标结点的父结点
    {
        if((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value))
        {
            return this;
        }
        else
        {
            if(this.value > value && this.left != null)
            {
                return this.left.searchParent(value);
            }
            else if(this.value <= value && this.right != null)
            {
                return this.right.searchParent(value);
            }
            else
            {
                return null;
            }
        }

    }

    public void add(Node node)
    {
        if(node == null)
        {
            return;
        }
        if(this.value > node.value)
        {
            if(this.left == null)
            {
                this.left = node;
            }
            else
            {
                this.left.add(node);
            }
        }
        else
        {
            if(this.right == null)
            {
                this.right = node;
            }
            else
            {
                this.right.add(node);
            }
        }
        //当添加完一个结点 若新的树不再是AVL树并满足左旋转条件 就需要左旋转
        if(rightHeight() - leftHeight() > 1)
        {
            if(this.right != null && this.right.rightHeight() < this.right.leftHeight())
            {
                this.right.rightRotate();
            }
            this.leftRotate();
            return;
        }
        //当添加完一个结点 若新的树不再是AVL树并满足右旋转条件 就需要右旋转
        if(leftHeight() - rightHeight() > 1)
        {
            if(this.left != null && this.left.leftHeight() < this.left.rightHeight())
            {
                this.left.leftRotate();
            }
            this.rightRotate();
        }
    }

    public void infixOrder()
    {
        if(this.left != null)
        {
            this.left.infixOrder();
        }
        System.out.println(this.value);
        if(this.right != null)
        {
            this.right.infixOrder();
        }
    }
}

//@SuppressWarnings({"all"})
//
//class binarySortTree
//{
//    Node root;
//
//    public void remove(int value)
//    {
//        if(root == null)
//        {
//            return;
//        }
//        Node targetNode = search(value);
//        if(targetNode == null)
//        {
//            return;
//        }
//        if(root.left == null && root.right == null)//只有根节点的情况 也是处理根节点为叶子结点 其父结点为null的情况
//        {
//            root = null;
//            return;
//        }
//        Node ParentNode = searchParent(value);
//        if(targetNode.left == null && targetNode.right == null)//叶子结点的情况
//        {
//            if(ParentNode.value > targetNode.value)
//            {
//                ParentNode.left = null;
//            }
//            else
//            {
//                ParentNode.right = null;
//            }
//        }
//        //先写删除有两颗子树的情况(条件好写) 只有一颗子树的情况就是最后的else
//        else if(targetNode.left != null && targetNode.right != null)
//        {
//            int min = removeRightMin(targetNode.right);
//            targetNode.value = min;
//        }
//        else//剩下的就是只有一颗子树的情况
//        {
//            if(ParentNode == null)//处理要删除的是根节点(则根节点的父结点为null) 并且根节点只有左子树或者是右子树
//            {
//                if(ParentNode.left != null)//有左子树
//                {
//                    root = ParentNode.left;
//                }
//                else//有右子树
//                {
//                    root = ParentNode.right;
//                }
//            }
//            else//处理的不是根节点
//            {
//                if(targetNode.left != null)//删除结点是目标结点的左子树的一个结点
//                {
//                    if(ParentNode.left != null && ParentNode.left.value == targetNode.value)//目标结点其父结点的左子结点
//                    {
//                        ParentNode.left = targetNode.left;
//                    }
//                    else//目标结点其父结点的右子结点
//                    {
//                        ParentNode.right = targetNode.left;
//                    }
//                }
//                else//删除结点是目标结点的右子树的一个结点
//                {
//                    if(ParentNode.left != null && ParentNode.left.value == targetNode.value)//目标结点其父结点的左子结点
//                    {
//                        ParentNode.left = targetNode.right;
//                    }
//                    else//目标结点其父结点的右子结点
//                    {
//                        ParentNode.right = targetNode.right;
//                    }
//                }
//            }
//        }
//    }
//
//    public int removeRightMin(Node node)//传入的结点是待删除结点的右子结点 该方法用于删除该右子结点所在树的最小结点并且返回被删除结点的value
//    {
//        if(node.left != null)
//        {
//            return removeRightMin(node.left);
//        }
//        else
//        {
//            int value = node.value;//保留最小值
//            remove(node.value);//删除该结点(叶子结点)
//            return value;
//        }
//    }
//
//    public Node search(int value)
//    {
//        if(root == null)
//        {
//            return null;
//        }
//        else
//        {
//            return root.search(value);
//        }
//    }
//
//    public Node searchParent(int value)
//    {
//        if(root == null)
//        {
//            return null;
//        }
//        else
//        {
//            return root.searchParent(value);
//        }
//    }
//
//    public void add(Node node)
//    {
//        if(root == null)
//        {
//            root = node;
//        }
//        else
//        {
//            root.add(node);
//        }
//    }
//
//    public void infixOrder()
//    {
//        if(root == null)
//        {
//            System.out.println("二叉排序树为空");
//        }
//        else
//        {
//            root.infixOrder();
//        }
//    }
//}