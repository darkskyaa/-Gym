package inbody.pojo;

import core.pojo.CoreBean;

/**
 * The pojo of Inbody subsystem
 * @date 2018-04-23
 * @category Inbody
 * @author William
 */
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

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the weight
	 */
	public Double getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(Double weight) {
		this.weight = weight;
	}

	/**
	 * @return the muscleMass
	 */
	public Double getMuscleMass() {
		return muscleMass;
	}

	/**
	 * @param muscleMass the muscleMass to set
	 */
	public void setMuscleMass(Double muscleMass) {
		this.muscleMass = muscleMass;
	}

	/**
	 * @return the tbw
	 */
	public Double getTbw() {
		return tbw;
	}

	/**
	 * @param tbw the tbw to set
	 */
	public void setTbw(Double tbw) {
		this.tbw = tbw;
	}

	/**
	 * @return the proteins
	 */
	public Double getProteins() {
		return proteins;
	}

	/**
	 * @param proteins the proteins to set
	 */
	public void setProteins(Double proteins) {
		this.proteins = proteins;
	}

	/**
	 * @return the minerals
	 */
	public Double getMinerals() {
		return minerals;
	}

	/**
	 * @param minerals the minerals to set
	 */
	public void setMinerals(Double minerals) {
		this.minerals = minerals;
	}

	/**
	 * @return the boneContent
	 */
	public Double getBoneContent() {
		return boneContent;
	}

	/**
	 * @param boneContent the boneContent to set
	 */
	public void setBoneContent(Double boneContent) {
		this.boneContent = boneContent;
	}

	/**
	 * @return the pbf
	 */
	public Double getPbf() {
		return pbf;
	}

	/**
	 * @param pbf the pbf to set
	 */
	public void setPbf(Double pbf) {
		this.pbf = pbf;
	}

	/**
	 * @return the vfl
	 */
	public Double getVfl() {
		return vfl;
	}

	/**
	 * @param vfl the vfl to set
	 */
	public void setVfl(Double vfl) {
		this.vfl = vfl;
	}

	/**
	 * @return the bmr
	 */
	public Double getBmr() {
		return bmr;
	}

	/**
	 * @param bmr the bmr to set
	 */
	public void setBmr(Double bmr) {
		this.bmr = bmr;
	}
}
