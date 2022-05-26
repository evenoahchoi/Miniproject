package vo;

public class MemberVo {

	private String member_ID;
	private String m_name;
	private String m_pwd;
	private String m_mail;
	private String m_tel;
	private String m_addr;
	private String acc_no;
	
	public MemberVo() {
	
	}
	
	public MemberVo(String member_ID, String m_name, String m_pwd, String m_mail, String m_tel, String m_addr) {
		super();
		this.member_ID = member_ID;
		this.m_name    = m_name;
		this.m_pwd     = m_pwd;
		this.m_mail    = m_mail;
		this.m_tel     = m_tel;
		this.m_addr    = m_addr;
	}

	public String getAcc_no() {
		return acc_no;
	}

	public void setAcc_no(String acc_no) {
		this.acc_no = acc_no;
	}

	public String getMember_ID() {
		return member_ID;
	}

	public void setMember_ID(String member_ID) {
		this.member_ID = member_ID;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_pwd() {
		return m_pwd;
	}

	public void setM_pwd(String m_pwd) {
		this.m_pwd = m_pwd;
	}

	public String getM_mail() {
		return m_mail;
	}

	public void setM_mail(String m_mail) {
		this.m_mail = m_mail;
	}

	public String getM_tel() {
		return m_tel;
	}

	public void setM_tel(String m_tel) {
		this.m_tel = m_tel;
	}

	public String getM_addr() {
		return m_addr;
	}

	public void setM_addr(String m_addr) {
		this.m_addr = m_addr;
	}

}
