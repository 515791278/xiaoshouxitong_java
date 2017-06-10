package com.jason.algorithm;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;



public class Myfptree2 {
	public static final int  support = 2; // �趨��С֧��Ƶ��Ϊ2 
	//�����һ�εĴ���
	public Map<String,Integer> ordermap=new HashMap<String,Integer>();
	public LinkedList<LinkedList<String>> readF1() throws IOException {      
		LinkedList<LinkedList<String>> records=new LinkedList<LinkedList<String>>();
		//String filePath="scripts/clustering/canopy/canopy.dat";
		String filePath="E:/Desktop/data.txt";
		BufferedReader br = new BufferedReader(new InputStreamReader(
        new FileInputStream(filePath)));
        for (String line = br.readLine(); line != null; line = br.readLine()) {
            if(line.length()==0||"".equals(line))continue;
        	String[] str=line.split(",");   
        	LinkedList<String> litm=new LinkedList<String>();
        	for(int i=0;i<str.length;i++){
        		litm.add(str[i].trim());
        	}
            records.add(litm);             
        }
        br.close();
        return records;
    }
	//������ͷ��
	public LinkedList<TreeNode2> buildHeaderLink(LinkedList<LinkedList<String>> records){
		LinkedList<TreeNode2> header=null;
		if(records.size()>0){
			header=new LinkedList<TreeNode2>();
		}else{
			return null;
		}
		Map<String, TreeNode2> map = new HashMap<String, TreeNode2>();
		for(LinkedList<String> items:records){
			
			for(String item:items){
				//�������������1��������������
				if(map.containsKey(item)){
					map.get(item).Sum(1);
				}else{
					TreeNode2 node=new TreeNode2();
					node.setName(item);
					node.setCount(1);
					map.put(item, node);
				}
             }
		}
		 // ��֧�ֶȴ��ڣ�����ڣ�minSup������뵽F1��
        Set<String> names = map.keySet();
        for (String name : names) {
            TreeNode2 tnode = map.get(name);
            if (tnode.getCount() >= support) {
            	header.add(tnode);
            }
        }
        sort(header);
		
        String test="ddd";
		return header;
	}
	//ѡ������,���������ȣ�����������,�ֵ�˳��,��Сд���д
	public List<TreeNode2> sort(List<TreeNode2> list){
		int len=list.size();
		for(int i=0;i<len;i++){
			
			for(int j=i+1;j<len;j++){
				TreeNode2 node1=list.get(i);
				TreeNode2 node2=list.get(j);
				if(node1.getCount()<node2.getCount()){
					TreeNode2 tmp=new TreeNode2();
					tmp=node2;
					list.remove(j);
					//listָ��λ�ò��룬ԭ����>=jԪ�ض��������ƣ�����ɾ��,���Բ���ǰҪɾ����ԭ����Ԫ��
					list.add(j,node1);
					list.remove(i);
					list.add(i,tmp);
				}
				//���������ȣ�����������,�ֵ�˳��,��Сд���д
				if(node1.getCount()==node2.getCount()){
					String name1=node1.getName();
					String name2=node2.getName();
					int flag=name1.compareTo(name2);
					if(flag>0){
						TreeNode2 tmp=new TreeNode2();
						tmp=node2;
						list.remove(j);
						//listָ��λ�ò��룬ԭ����>=jԪ�ض��������ƣ�����ɾ��,���Բ���ǰҪɾ����ԭ����Ԫ��
						list.add(j,node1);
						list.remove(i);
						list.add(i,tmp);
					}
					

				}
			}
		}
		
		return list;
	}
	//ѡ�����򣬽���,���ͬ����L �еĴ�������
	public   List<String> itemsort(LinkedList<String> lis,List<TreeNode2> header){
		//List<String> list=new ArrayList<String>();
		//ѡ������
		int len=lis.size();
		for(int i=0;i<len;i++){
			for(int j=i+1;j<len;j++){
				String key1=lis.get(i);
				String key2=lis.get(j);
				Integer value1=findcountByname(key1,header);
				if(value1==-1)continue;
				Integer value2=findcountByname(key2,header);
				if(value2==-1)continue;
				if(value1<value2){
					String tmp=key2;
					lis.remove(j);
					lis.add(j,key1);
					lis.remove(i);
					lis.add(i,tmp);
				}
				if(value1==value2){
					int v1=ordermap.get(key1);
					int v2=ordermap.get(key2);
					if(v1>v2){
						String tmp=key2;
						lis.remove(j);
						lis.add(j,key1);
						lis.remove(i);
						lis.add(i,tmp);
					}
				}
		     }
		}
		return lis;
	}
	public Integer findcountByname(String itemname,List<TreeNode2> header){
		Integer count=-1;
		for(TreeNode2 node:header){
			if(node.getName().equals(itemname)){
				count= node.getCount();
			}
		}
		return count;
	}
	

	public TreeNode2 builderFpTree(LinkedList<LinkedList<String>> records,List<TreeNode2> header){
		
		   TreeNode2 root;
		   if(records.size()<=0){
			   return null;
		   }
		   root=new TreeNode2();
		   for(LinkedList<String> items:records){
			   itemsort(items,header);
			  addNode(root,items,header);
			}
		String dd="dd";	
		String test=dd;
		return root;
	}
	//���Ѿ��з�֦���ڵ�ʱ���ж������Ľڵ��Ƿ����ڸ÷�֦��ĳ���ڵ㣬��ȫ���غϣ��ݹ�
	public  TreeNode2 addNode(TreeNode2 root,LinkedList<String> items,List<TreeNode2> header){
		if(items.size()<=0)return null;
		String item=items.poll();
		//��ǰ�ڵ�ĺ��ӽڵ㲻�����ýڵ㣬��ô���ⴴ��һ֧��֧��
		TreeNode2 node=root.findChild(item);
		if(node==null){
            node=new TreeNode2();
			node.setName(item);
			node.setCount(1);
			node.setParent(root);
			root.addChild(node);
			
			//�ӽ������ڵ�ӵ���ͷ�� 
			for(TreeNode2 head:header){
				if(head.getName().equals(item)){
					while(head.getNextHomonym()!=null){
						head=head.getNextHomonym();
					}
					head.setNextHomonym(node);
					break;
				}
			}
			//�ӽ������ڵ�ӵ���ͷ��
		}else{
			node.setCount(node.getCount()+1);
		}
 
		addNode(node,items,header);
		return root;
	}
	//��Ҷ���ҵ����ڵ㣬�ݹ�֮
	public void toroot(TreeNode2 node,LinkedList<String> newrecord){
		if(node.getParent()==null)return;
		String name=node.getName();
		newrecord.add(name);
		toroot(node.getParent(),newrecord);
	}
	//������FP-tree��������ϣ������Ƶ���
	public void combineItem(TreeNode2 node,LinkedList<String> newrecord,String Item){
		if(node.getParent()==null)return;
		String name=node.getName();
		newrecord.add(name);
		toroot(node.getParent(),newrecord);
	}
	//fp-growth
	public void fpgrowth(LinkedList<LinkedList<String>> records,String item){
		//�����µ�����ģʽ���ĸ�����¼�������¹���FP-tree
		LinkedList<LinkedList<String>> newrecords=new LinkedList<LinkedList<String>>();
		//������ͷ
		LinkedList<TreeNode2> header=buildHeaderLink(records);
		//����FP-Tree
		TreeNode2 fptree= builderFpTree(records,header);
		//�����ݹ������
		if(header.size()<=0||fptree==null){
			System.out.println("-----------------");
			return;
		}
		//��ӡ���,���Ƶ���
		if(item!=null){
			//Ѱ������ģʽ��,����β��ʼ
			for(int i=header.size()-1;i>=0;i--){
				TreeNode2 head=header.get(i);
				String itemname=head.getName();
				Integer count=0;
				while(head.getNextHomonym()!=null){
					head=head.getNextHomonym();
					//Ҷ��count���ڶ��٣������������¼
					count=count+head.getCount();
					
				}
				//��ӡƵ���
				System.out.println(head.getName()+","+item+"\t    "+count);
			}
		}
		//Ѱ������ģʽ��,����β��ʼ
		for(int i=header.size()-1;i>=0;i--){
			TreeNode2 head=header.get(i);
			String itemname;
			//�����
			if(item==null){
				itemname=head.getName();
			}else{
				itemname=head.getName()+","+item;
			}
			
			while(head.getNextHomonym()!=null){
				head=head.getNextHomonym();
				//Ҷ��count���ڶ��٣������������¼
				Integer count=head.getCount();
				for(int n=0;n<count;n++){
				   LinkedList<String> record=new LinkedList<String>();
				   toroot(head.getParent(),record);
				   newrecords.add(record);
				}
			}
//			System.out.println("-------x----------");
			//�ݹ�֮,������FP-Tree
			fpgrowth(newrecords,itemname);
		}
    }
	
	public void orderF1(LinkedList<TreeNode2> orderheader){
		for(int i=0;i<orderheader.size();i++){
			TreeNode2 node=orderheader.get(i);
			ordermap.put(node.getName(), i);
		}
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*String s1="i1";
		int flag=s1.compareTo("I1");
		System.out.println(flag);*/
		//��ȡ����
		Myfptree2 fpg=new Myfptree2();
		LinkedList<LinkedList<String>> records=fpg.readF1();
	
		LinkedList<TreeNode2> orderheader=fpg.buildHeaderLink(records);

		fpg.orderF1(orderheader);
      fpg.fpgrowth(records,null);
	}

}
