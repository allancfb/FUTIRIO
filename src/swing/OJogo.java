package swing;

import java.io.Serializable;

import entity.*;

public class OJogo implements Serializable {

	private static final long serialVersionUID = 1L;
	private Time timeJogador;
	private Campeonato carioca;
	private String nomeTecnico;
	private int indexTime;
	private int indexENUM;

	public OJogo() {

		Time america = Main.carregarTime("America");
		america.setEscudo("/iconTimes/iconAmerica.png");
		Time bangu = Main.carregarTime("Bangu");
		bangu.setEscudo("/iconTimes/iconBangu.png");
		Time boavista = Main.carregarTime("Boavista-RJ");
		boavista.setEscudo("/iconTimes/iconBoavista.png");
		Time bonsucesso = Main.carregarTime("Bonsucesso");
		bonsucesso.setEscudo("/iconTimes/iconBonsucesso.png");
		Time botafogo = Main.carregarTime("Botafogo");
		botafogo.setEscudo("/iconTimes/iconBotafogo.png");
		Time cabofriense = Main.carregarTime("Cabofriense");
		cabofriense.setEscudo("/iconTimes/iconCabofriense.png");
		Time flamengo = Main.carregarTime("Flamengo");
		flamengo.setEscudo("/iconTimes/iconFlamengo.png");
		Time fluminense = Main.carregarTime("Fluminense");
		fluminense.setEscudo("/iconTimes/iconFluminense.png");
		Time goytacaz = Main.carregarTime("Goytacaz");
		goytacaz.setEscudo("/iconTimes/iconGoytacaz.png");
		Time macae = Main.carregarTime("Macaé");
		macae.setEscudo("/iconTimes/iconMacae.png");
		Time madureira = Main.carregarTime("Madureira");
		madureira.setEscudo("/iconTimes/iconMadureira.png");
		Time novaIguacu = Main.carregarTime("Nova Iguaçu");
		novaIguacu.setEscudo("/iconTimes/iconNovaIguacu.png");
		Time portuguesa = Main.carregarTime("Portuguesa-RJ");
		portuguesa.setEscudo("/iconTimes/iconPortuguesa.png");
		Time resende = Main.carregarTime("Resende");
		resende.setEscudo("/iconTimes/iconResende.png");
		Time vasco = Main.carregarTime("Vasco");
		vasco.setEscudo("/iconTimes/iconVasco.png");
		Time voltaRedonda = Main.carregarTime("Volta Redonda");
		voltaRedonda.setEscudo("/iconTimes/iconVoltaRedonda.png");

	}

	public int getIndexENUM() {
		return indexENUM;
	}

	public void setIndexENUM(int indexENUM) {
		this.indexENUM = indexENUM;
	}

	public Time getTimeJogador() {
		return timeJogador;
	}

	public void setTimeJogador(Time timeJogador) {
		this.timeJogador = timeJogador;
	}

	public Campeonato getCarioca() {
		return carioca;
	}

	public void createCarioca(int ano) {
		this.carioca = new Campeonato(ano);
	}

	public String getNomeTecnico() {
		return nomeTecnico;
	}

	public void setNomeTecnico(String nomeTecnico) {
		this.nomeTecnico = nomeTecnico;
	}

	public int getIndexTime() {
		return indexTime;
	}

	public void setIndexTime(int indexTime) {
		this.indexTime = indexTime;
	}

}
