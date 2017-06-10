package com.jason.algorithm;



import java.util.ArrayList;
import java.util.List;



public class TreeNode2 implements Comparable<TreeNode2>{

    private String name; // 节点名称
    private Integer count; // 计数
    private TreeNode2 parent; // 父节点
    private List<TreeNode2> children; // 子节点
    private TreeNode2 nextHomonym; // 下一个同名节点
  
    public TreeNode2() {
  
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	public void Sum(Integer count) {
		this.count =this.count+count;
	}
	public TreeNode2 getParent() {
		return parent;
	}

	public void setParent(TreeNode2 parent) {
		this.parent = parent;
	}

	public List<TreeNode2> getChildren() {
		return children;
	}

	public void setChildren(List<TreeNode2> children) {
		this.children = children;
	}

	public TreeNode2 getNextHomonym() {
		return nextHomonym;
	}

	public void setNextHomonym(TreeNode2 nextHomonym) {
		this.nextHomonym = nextHomonym;
	}

    public void addChild(TreeNode2 child) {
        if (this.getChildren() == null) {
            List<TreeNode2> list = new ArrayList<TreeNode2>();
            list.add(child);
            this.setChildren(list);
        } else {
            this.getChildren().add(child);
        }
    }

    public TreeNode2 findChild(String name) {
        List<TreeNode2> children = this.getChildren();
        if (children != null) {
            for (TreeNode2 child : children) {
                if (child.getName().equals(name)) {
                    return child;
                }
            }
        }
        return null;
    }


    @Override
    public int compareTo(TreeNode2 arg0) {
        // TODO Auto-generated method stub
        int count0 = arg0.getCount();
        // 跟默认的比较大小相反，导致调用Arrays.sort()时是按降序排列
        return count0 - this.count;
    }
}
