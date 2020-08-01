package SortDemo;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:wanghuimin
 * Date:2020-05-13
 * Time:19:23
 * 一万年太久，只争朝夕，加油
 */
public class BinarySearchTree {
    static class Node{
        public int key;
        public int value;
        public Node left;
        public Node right;

        public Node(int key,int value) {
            this.key = key;
            this.value=value;
        }
    }
    //记录树的根节点,当root==null，表示空树
    private Node root=null;
    //查找
    public Node find(int key){
        Node cur=root;
        while(cur!=null){
            if(key<cur.key){
                cur=cur.left;
            }else if(key>cur.key){
                cur=cur.right;
            }else{
                return cur;
            }
        }
    return null;
    }
    //插入
    public Node insert(int key,int value){
        if(root==null){
            root=new Node(key,value);
            return root;
        }
        //找到要插入的位置
        Node cur=root;
        Node prev=null;
        while(cur!=null){
            if(key<cur.key){
                prev=cur;
                cur=cur.left;
            }else if(key>cur.key){
                prev=cur;
                cur=cur.right;
            }else{
                //找到了和key相等的元素,直接插入失败/不创建新节点，把当前节点的value改为新的value
                cur.value=value;
            }
        }
        //找到合适的插入位置
        Node newNode=new Node(key,value);
        if(prev.key>key){
            prev.left=newNode;
        }else{
            prev.right=newNode;
        }
        return newNode;
}
//先序遍历
    public  void preOrder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.key+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    //中序遍历
    public  void inOrder(Node root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.key+" ");
        inOrder(root.right);
    }
//删除元素
    public void remove(int key){
        //先找到要删除的节点位置，记录该节点的父节点
        //记录要删除的那个元素的前驱节点
        Node parent=null;
        Node cur=root;
        while(cur!=null){
            if(key<root.key){
                parent=cur;
                cur=cur.left;
            }else if(key>root.key){
                parent=cur;
                cur=cur.right;
            }else{
                //说明找到了这个要删除的节点
                removeNode(cur,parent);

            }
        }

//没找到
        return;
    }

    private void removeNode(Node cur, Node parent) {
        //没有左子树的情况
        if(cur.left==null){
            if(cur==root){
                root=cur.right;
            }else if(cur==parent.left){
                parent.left=cur.right;
            }else if(cur==parent.right){
                parent.right=cur.right;
            }

        }else if(cur.right==null){
            //没有右子树的情况
            if(cur==root){
                root=cur.left;
            }else if(cur==parent.left){
                parent.left=cur.left;
            }else if(cur==parent.right){
                parent.right=cur.left;
            }
        }else{
            //左右子树都有
            //找到右子树中最小值，即替罪羊
            Node scapeGoat=cur.right;
            Node scapeGoatParent=cur;
            while(scapeGoat.left!=null){
                scapeGoatParent=scapeGoat;
                scapeGoat=scapeGoat.left;
            }
            //scapeGoat指向了右子树的最小值（左子树）
            cur.key=scapeGoat.key;
            cur.value=scapeGoat.value;
            if(scapeGoat==scapeGoatParent.left){
                scapeGoatParent.left=scapeGoat.right;
            }else{
                scapeGoatParent.right=scapeGoat.right;
            }
        }
    }

    public static void main(String[] args) {
        BinarySearchTree b=new BinarySearchTree();
        b.insert(9,90);
        b.insert(5,50);
        b.insert(2,20);
        b.insert(7,70);
        b.insert(3,30);
        b.insert(6,60);
        b.insert(8,80);
        b.preOrder(b.root);
        System.out.println();
        b.inOrder(b.root);
        System.out.println();
        b.remove(8);
        b.preOrder(b.root);
        System.out.println();
        b.inOrder(b.root);



    }
}

