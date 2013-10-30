package com.example.thanhtoantiensach;

import java.util.ArrayList;
import java.util.Iterator;

public class DSKhachHang {
	private ArrayList<KhachHang> list=new ArrayList<KhachHang>();

	public ArrayList<KhachHang> getDsKhachHang() {
		return list;
	}

	public void addKhachHang(KhachHang kh) {
		this.list.add(kh);
	}

	public void setDsKhachHang(ArrayList<KhachHang> dsKhachHang) {
		this.list = dsKhachHang;
	}

	// lay tong so khach hang
	public int getTongKH() {
		return list.size();
	}

	// Lay tong so khach hang la vip
	public int getTongKHVip() {
		int d = 0;
		Iterator<KhachHang> iterator = list.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().isVIP())
				d = d + 1;
		}
		return d;
	}

	public long getTongDoanhThu() {
		long d = 0;
		Iterator<KhachHang> iterator = list.iterator();
		while (iterator.hasNext()) {
			d = d + iterator.next().getSoTien();
		}
		return d;
	}

}
