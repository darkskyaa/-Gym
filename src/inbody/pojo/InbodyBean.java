package inbody.pojo;

import core.pojo.CoreBean;

public class InbodyBean extends CoreBean {
	private Integer id;
	private Double weight;
	private Double muscleMass;
	private Double tbw;
	private Double proteins;
	private Double minerals;
	private Double boneContent;
	private Double pbf;
	private Double vfl;
	private Double bmr;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getMuscleMass() {
		return muscleMass;
	}

	public void setMuscleMass(Double muscleMass) {
		this.muscleMass = muscleMass;
	}

	public Double getTbw() {
		return tbw;
	}

	public void setTbw(Double tbw) {
		this.tbw = tbw;
	}

	public Double getProteins() {
		return proteins;
	}

	public void setProteins(Double proteins) {
		this.proteins = proteins;
	}

	public Double getMinerals() {
		return minerals;
	}

	public void setMinerals(Double minerals) {
		this.minerals = minerals;
	}

	public Double getBoneContent() {
		return boneContent;
	}

	public void setBoneContent(Double boneContent) {
		this.boneContent = boneContent;
	}

	public Double getPbf() {
		return pbf;
	}

	public void setPbf(Double pbf) {
		this.pbf = pbf;
	}

	public Double getVfl() {
		return vfl;
	}

	public void setVfl(Double vfl) {
		this.vfl = vfl;
	}

	public Double getBmr() {
		return bmr;
	}

	public void setBmr(Double bmr) {
		this.bmr = bmr;
	}
}
