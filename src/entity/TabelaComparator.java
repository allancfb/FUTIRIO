package entity;

import java.util.Comparator;

public class TabelaComparator implements Comparator<TimeTabela> {
	public int compare(TimeTabela timeTabela, TimeTabela outroTimeTabela) {
		return timeTabela.compareTo(outroTimeTabela);
	}
}
