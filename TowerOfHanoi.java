public class TowerOfHanoi {
	
	public static void main(String[] args) {

		int n = 4;

		solve(n, 1, 2, 3);
	}

	public static void solve(int disk, int from, int dest, int help){

		if(disk == 1){
			System.out.println("Move disk-" + disk + " from tower-" + from + " to tower-" + dest);
		}
		else{
			solve(disk-1, from, help, dest);
			System.out.println("Move disk-" + disk + " from tower-" + from + " to tower-" + dest);
			solve(disk-1, help, dest, from);
		}
	}
}