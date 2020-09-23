import java.util.ArrayList;

public class MySet<E> {
	private ArrayList<E> list = new ArrayList<>();
	
	
	public boolean add(E e) {
		if (e instanceof Citizen) {
			if (list.get(0) == null) {
				list.add(e);
				return true;
			}
			if (!contains(e)) {
				list.add(e);
				return true;
			}
		}
		return false;
	}

	public boolean addAll(ArrayList<E> listOther) {
		for (int i = 0; i < listOther.size(); i++) {
			if (!add(listOther.get(i))) {
				return false;
			}
		}
		return true;
	}

	public boolean contains(E e) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals(e)) {
				return true;
			}
		}
		return false;
	}

	public boolean isEmpty() {
		if (list.get(0) == null) {
			return true;
		}
		return false;
	}

	public int size() {
		return list.size();
	}
	
}
