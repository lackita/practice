import java.util.*;

public class MathSet extends TreeSet<Integer> {
	private static final long serialVersionUID = 1;

	public MathSet() {
		super();
	}

	public MathSet(MathSet m) {
		super();
		addAll(m);
	}

	public LinkedList<MathSet> subsets() {
		LinkedList<MathSet> subsets = new LinkedList<MathSet>();
		if (isEmpty()) {
			subsets.add(new MathSet());
			return subsets;
		}

		subsets.add(new MathSet(this));
		for (Integer item : this) {
			MathSet subset = new MathSet(this);
			subset.remove(item);
			subsets.addAll(subset.subsets());
		}

		return subsets;
	}
}
