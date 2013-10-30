package com.example.thanhtoantiensach;

public class KhachHang {
	private String tenKH;
	private int soLuong;
	private boolean VIP;

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public boolean isVIP() {
		return VIP;
	}

	public void setVIP(boolean vIP) {
		VIP = vIP;
	}

	public KhachHang(String tenKH, int soLuong, boolean vIP) {
		this.tenKH = tenKH;
		this.soLuong = soLuong;
		VIP = vIP;
	}

	public KhachHang() {
		this.tenKH = "";
		this.soLuong = 0;
		this.VIP = false;
	}
	public long getSoTien(){
		long t=0;
		if(!this.VIP){
			t=t+this.soLuong*20000;
    	} else {
    		t=t+this.soLuong*18000;
    	}
		return t;
	}

}
