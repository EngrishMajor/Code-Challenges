package amazon;
import java.util.*;

/*
Setup:
Assume primitive Facebook. FB has Members.
class Member {
    String name;
    String email;
    List<Member> friends;
}
Question: 
Code printSocialGraph(Member m). Direct friends of m are Level 1 friends. Friends of friends are level 2 friends.....and so on
Print level 1 friends first. Then print level 2 friends....and so on
void printSocialGraph (Member m){
//Your code here
}
*/

public class SocialGraph {
	public class Member {
		String name;
		String email;
		List<Member> friends;
	}
	
	public Queue<Member> queue = new LinkedList<Member>();
	public ArrayList<Member> exists = new ArrayList<Member>();
	
	public void printSocialGraph(Member m) {
		queue.add(m);
		exists.add(m);
		
		/*
		 * Do a breadth-first search starting from member m.
		 * A breadth-first seach will do a by-level traversal.
		 * We dequeue whoever is on top, print his/her info, then
		 * enqueue that member's friends. If the friend has already
		 * been put into the queue, then don't enqueue them.
		 */
		
		while (queue.size() > 0) {
			Member friend = queue.poll();
			System.out.println("Name: " + friend.name + "    Email: " + friend.email);
			
			for (int i = 0; i < m.friends.size(); i++) {
				Member member = m.friends.get(i);
				if (!exists.contains(member)) {
					queue.add(member);
					exists.add(member);
				}
			}
		}
	}
}
