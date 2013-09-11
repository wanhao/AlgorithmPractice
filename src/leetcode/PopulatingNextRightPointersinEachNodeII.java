package leetcode;


public class PopulatingNextRightPointersinEachNodeII {

	static class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}

	public void connect(TreeLinkNode root) {
		if(root==null) return;
		
		TreeLinkNode head=root;
		TreeLinkNode newHead=null, newLast=null;
		
		while(true){
			if(head!=null){
				if(head.left!=null){
					if(newLast==null){
						newHead=head.left;
						newLast=head.left;
					}else{
						newLast.next=head.left;
						newLast=newLast.next;
					}
				}
				
				if(head.right!=null){
					if(newLast==null){
						newHead=head.right;
						newLast=head.right;
					}else{
						newLast.next=head.right;
						newLast=newLast.next;
					}
				}
				
				head=head.next;
			}else{
				if(newHead!=null){
					head=newHead;
					newHead=null;
					newLast=null;
				}else{
					break;
				}
			}
		}
		
		
	}

}
