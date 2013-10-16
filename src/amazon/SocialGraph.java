package amazon;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
	public Hashtable<Member, Boolean> exists = new Hashtable<Member, Boolean>();
	
	public void printSocialGraph(Member m) {
		queue.add(m);
		exists.put(m, true);
		fillQueue(m); //fill the queue with friends in order of level
		
		while (queue.size() > 0) {//print out their info
			Member friend = queue.poll();
			System.out.println("Name: " + friend.name + "    Email: " + friend.email);
		}
	}
	
	public void fillQueue(Member m) {
		if (m.friends.size() == 0) //if the member has no friends, then there's nothing to enqueue
			return;
		
		//enqueue all the friends that aren't in the queue yet
		for (int i = 0; i < m.friends.size(); i++) {
			Member friend = m.friends.get(i);
			if (!exists.containsKey(friend)) {
				queue.add(friend);
				exists.put(friend, true);
			}
		}
		
		//go through those friend's lists
		for (int i = 0; i < m.friends.size(); i++)
			printSocialGraph(m.friends.get(i));
	}
}
